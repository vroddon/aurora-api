package project.aurora.api.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.aurora.api.entity.Country;
import project.aurora.api.entity.DemoSite;
import project.aurora.api.entity.DeviceToken;
import project.aurora.api.entity.Email;
import project.aurora.api.entity.EmailCode;
import project.aurora.api.entity.HeatingSource;
import project.aurora.api.entity.HouseholdData;
import project.aurora.api.entity.LevelOfOccupancy;
import project.aurora.api.entity.LoginData;
import project.aurora.api.entity.Notification;
import project.aurora.api.entity.Password;
import project.aurora.api.entity.PasswordCode;
import project.aurora.api.entity.PasswordConfirmationCode;
import project.aurora.api.entity.RefreshToken;
import project.aurora.api.entity.Token;
import project.aurora.api.entity.TransportData;
import project.aurora.api.entity.User;
import project.aurora.api.entity.VehicleType;
import project.aurora.api.repository.CountryRepository;
import project.aurora.api.repository.DemoSiteRepository;
import project.aurora.api.repository.DeviceTokenRepository;
import project.aurora.api.repository.EmailCodeRepository;
import project.aurora.api.repository.HeatingsourceRepository;
import project.aurora.api.repository.HouseholdDataRepository;
import project.aurora.api.repository.LevelOfOccupancyRepository;
import project.aurora.api.repository.NotificationRepository;
import project.aurora.api.repository.PasswordCodeRepository;
import project.aurora.api.repository.SiteRepository;
import project.aurora.api.repository.TokenRepository;
import project.aurora.api.repository.TransportDataRepository;
import project.aurora.api.repository.UserRepository;
import project.aurora.api.repository.VehicleTypeRepository;
import project.aurora.api.utils.CodesMessages;
import project.aurora.api.utils.CustomConfiguration;
import project.aurora.api.utils.GenerateZipFile;
import project.aurora.api.utils.SendEmail;

@RestController
@RequestMapping("/v1/api")
public class ApiController {
	
	static Logger logger = Logger.getLogger(ApiController.class.getName());

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@Autowired
	private EmailCodeRepository emailCodeRepository;
	
	@Autowired
	private PasswordCodeRepository passwordCodeRepository;
	
	@Autowired
	private SiteRepository siteRepository;
	
	@Autowired
	private DemoSiteRepository demoSiteRepository;
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	@Autowired
	private LevelOfOccupancyRepository levelOfOccupancyRepository;
	
	@Autowired
	private TransportDataRepository transportDataRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private HeatingsourceRepository heatingSourceRepository;
	
	@Autowired
	private HouseholdDataRepository householdDataRepository;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private DeviceTokenRepository deviceTokenRepository;
	
	@Autowired
	private CustomConfiguration customConfiguration;
	
	/*
	 * 
	 * 	AUTHENTICATION MODULE
	 * 
	 * 
	 */
	
	// create user
	@PutMapping("/authentication/register")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		logger.log(Level.INFO, "PUT /authentication/register");
		if (this.userRepository.existsByEmail(user.getEmail())) {
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.userEmailInUse), HttpStatus.BAD_REQUEST);
		}
		else {
			this.userRepository.save(user);
			Token token = new Token(user.getId(), user.getEmail());
			this.tokenRepository.save(token);	
			try {
				Map<String, Object> map = token.toJsonMap();
				return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map), HttpStatus.OK);
			} catch (JsonProcessingException e) {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
			}
		}
	}
	
	// login
	@PostMapping("/authentication/login")
	public ResponseEntity<String> login(@RequestBody LoginData login) {
		logger.log(Level.INFO, "POST /authentication/login");
		if (this.userRepository.existsByEmail(login.getEmail())) {
			User user = this.userRepository.findByEmail(login.getEmail()).get();
			if (user.getEmail().equals(login.getEmail()) && user.getPassword().contentEquals(login.getPassword()) ) {
				Token token = new Token(user.getId(), user.getEmail());
				this.tokenRepository.save(token);
				try {
					Map<String, Object> map = token.toJsonMap();
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidCredencials), HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.userNotFound), HttpStatus.BAD_REQUEST);
		}

	}
	
	// logout
	@DeleteMapping("/authentication/logout")
	public ResponseEntity<String> logout(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "DELETE /authentication/logout");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent()) {
				this.tokenRepository.delete(token.get());
				return new ResponseEntity<String>("", HttpStatus.OK);
			} else
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.UNAUTHORIZED);
	}
	
	// refresh tokens
	@PostMapping("/authentication/refresh")
	public ResponseEntity<String> refresh(@RequestHeader Map<String, String> headers, @RequestBody RefreshToken refreshToken) {
		logger.log(Level.INFO, "POST /authentication/refresh");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken) 
					&& token.get().getRefreshToken().equals(refreshToken.getRefreshToken())) {
				User user = this.userRepository.findByEmail(token.get().getEmail()).get();
				Token newToken = new Token(user.getId(), token.get().getEmail());
				this.tokenRepository.delete(token.get());
				this.tokenRepository.save(newToken);
				try {
					Map<String, Object> map = newToken.toJsonMap();
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	// change email
	@PostMapping("/authentication/email")
	public ResponseEntity<String> changeEmail(@RequestHeader Map<String, String> headers, @RequestBody Email email) {
		logger.log(Level.INFO, "POST /authentication/email");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				EmailCode emailCode = new EmailCode(accessToken, email.getEmail());
				try {
					SendEmail.sendChangeEmail(token.get().getEmail(), emailCode.getConfirmationCode(), customConfiguration);
				} catch (Exception e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.errorSendingEmail), HttpStatus.BAD_REQUEST);
				}
				this.emailCodeRepository.save(emailCode);
				return new ResponseEntity<String>("", HttpStatus.OK);
			} else
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	// confirm change email
	@PatchMapping("/authentication/email")
	public ResponseEntity<String> confirmChangeEmail(@RequestHeader Map<String, String> headers, @RequestBody EmailCode emailCode) {
		logger.log(Level.INFO, "PATCH /authentication/email");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				Optional<EmailCode> emCode = this.emailCodeRepository.findByEmailAndConfirmationCode(emailCode.getEmail(), emailCode.getConfirmationCode());
				if (emCode.isPresent()) {
					User user = this.userRepository.findByEmail(token.get().getEmail()).get();
					user.setEmail(emailCode.getEmail());				
					this.emailCodeRepository.delete(emCode.get());
					this.tokenRepository.delete(token.get());
					this.userRepository.save(user);
					return new ResponseEntity<String>("", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.emailCodeNotPresent), HttpStatus.UNAUTHORIZED);
				}
			} else
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}

	// change password
	@PatchMapping("/authentication/password")
	public ResponseEntity<String> changePassword(@RequestHeader Map<String, String> headers, @RequestBody Password password) {
		logger.log(Level.INFO, "PATCH /authentication/password");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				Optional<User> user = this.userRepository.findByEmail(token.get().getEmail());
				user.get().setPassword(password.getPassword());
				this.userRepository.save(user.get());
				return new ResponseEntity<String>("", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}
			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	// reset password
	@PostMapping("/authentication/password-reset")
	public ResponseEntity<String> passwordReset(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "POST /authentication/password-reset");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				PasswordCode passwordCode = new PasswordCode(token.get().getEmail(), accessToken);
				try {
					SendEmail.sendResetPassword(token.get().getEmail(), passwordCode.getConfirmationCode(), customConfiguration);
				} catch (Exception e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.errorSendingEmail), HttpStatus.BAD_REQUEST);
				}
				this.passwordCodeRepository.save(passwordCode);
				return new ResponseEntity<String>("", HttpStatus.OK);
			} else
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	// confirm reset password
	@PatchMapping("/authentication/password-reset")
	public ResponseEntity<String> passwordReset(@RequestHeader Map<String, String> headers, @RequestBody PasswordConfirmationCode passwordConfirmationCode) {
		logger.log(Level.INFO, "PATCH /authentication/password-reset");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				Optional<PasswordCode> pwCode = this.passwordCodeRepository.findByEmailAndConfirmationCode(token.get().getEmail(), passwordConfirmationCode.getConfirmationCode());
				if (pwCode.isPresent()) {
					Optional<User> user = this.userRepository.findByEmail(token.get().getEmail());
					user.get().setPassword(passwordConfirmationCode.getPassword());
					this.userRepository.save(user.get());
					this.tokenRepository.delete(token.get());
					this.passwordCodeRepository.delete(pwCode.get());
					return new ResponseEntity<String>("", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.passwordCodeNotPresent), HttpStatus.UNAUTHORIZED);
				}
			} else
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	/*
	 * 
	 * 	USER MODULE
	 * 
	 * 
	 */
	
	// get user
	@GetMapping("/user")
	public ResponseEntity<String> getUser(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /user");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				Optional<User> user = this.userRepository.findByEmail(token.get().getEmail());
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(user.get().toJsonMap()), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// change password
	@PatchMapping("/user")
	public ResponseEntity<String> updateUser(@RequestHeader Map<String, String> headers, @RequestBody User newDataUser) {
		logger.log(Level.INFO, "PATCH /user");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				Optional<User> user = this.userRepository.findByEmail(token.get().getEmail());
				user.get().setFirstName(newDataUser.getFirstName());
				user.get().setLastName(newDataUser.getLastName());
				user.get().setYearOfBirth(newDataUser.getYearOfBirth());
				user.get().setSites(newDataUser.getSites());				
				this.userRepository.save(user.get());
				return new ResponseEntity<String>("", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}
			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	// change password
	@DeleteMapping("/user")
	public ResponseEntity<String> deleteUser(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "DELETE /user");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				Optional<User> user = this.userRepository.findByEmail(token.get().getEmail());				
				this.userRepository.delete(user.get());
				return new ResponseEntity<String>("", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}
			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}

	// reset password
	@PostMapping("/user/export-data")
	public ResponseEntity<String> exportDataUser(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "POST /user/export-data");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				Optional<User> user = this.userRepository.findByEmail(token.get().getEmail());				
				GenerateZipFile.createAndSendFile(user.get(), customConfiguration);
				return new ResponseEntity<String>("", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	/*
	 * 
	 * 	SITES MODULE
	 * 
	 * 
	 */
	
	// get sites
	@GetMapping("/sites")
	public ResponseEntity<String> getSite(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /sites");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				List<DemoSite> demoSites = this.demoSiteRepository.findAll();
				List<Map<String, Object>> output = new ArrayList<Map<String,Object>>();
				for (DemoSite demoSite:demoSites) {
					output.add(demoSite.toJsonMap());
				}
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output), HttpStatus.OK);
				} catch (JsonProcessingException e) {

					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	/*
	 * 
	 * 	TRANSPORTATION MODULE
	 * 
	 * 
	 */
	
	// get vehicle types
	@GetMapping("/vehicle-types")
	public ResponseEntity<String> getVehicleTypes(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /vehicle-types");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				List<VehicleType> vehicleTypes = this.vehicleTypeRepository.findAll();
				List<Map<String, Object>> output = new ArrayList<Map<String,Object>>();
				for (VehicleType vehicleType:vehicleTypes) {
					output.add(vehicleType.toJsonMap());
				}
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// get levels of occupancy
	@GetMapping("/level-of-occupancy")
	public ResponseEntity<String> getLevelofOccupancy(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /level-of-occupancy");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				List<LevelOfOccupancy> levelsOfOccupancy = this.levelOfOccupancyRepository.findAll();
				List<Map<String, Object>> output = new ArrayList<Map<String,Object>>();
				for (LevelOfOccupancy levelOfOccupancy:levelsOfOccupancy) {
					output.add(levelOfOccupancy.toJsonMap());
				}
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// get levels of occupancy
	@GetMapping("/countries")
	public ResponseEntity<String> getCountries(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /countries");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				List<Country> countries = this.countryRepository.findAll();
				List<Map<String, Object>> output = new ArrayList<Map<String,Object>>();
				for (Country country:countries) {
					output.add(country.toJsonMap());
				}
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// add transport data record
	@PutMapping("/transport")
	public ResponseEntity<String> createTransportData(@RequestHeader Map<String, String> headers, @RequestBody TransportData transportData) {
		logger.log(Level.INFO, "PUT /transport");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				TransportData tpd = new TransportData(transportData.getUserId(), transportData.getCountryId(), transportData.getDateOfTravel(), transportData.getTypeOfVehicleId(), transportData.getLevelOfOccupancyId(), transportData.getDistanceTravelled());
				TransportData newtpd = this.transportDataRepository.save(tpd);
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newtpd.toJsonMap()), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}				
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// update transport data record
	@PatchMapping("/transport/{id}")
	public ResponseEntity<String> updateTransportData(@PathVariable ("id") long tpdId, @RequestHeader Map<String, String> headers, @RequestBody TransportData transportData) {
		logger.log(Level.INFO, "PATCH /transport/" + tpdId);
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				if (this.transportDataRepository.findByIdAndUserId(tpdId, transportData.getUserId()).isPresent()) {					
					TransportData tpd = this.transportDataRepository.findByIdAndUserId(tpdId, transportData.getUserId()).get();
					tpd.setDateOfTravel(transportData.getDateOfTravel());
					tpd.setDistanceTravelled(transportData.getDistanceTravelled());
					tpd.setLevelOfOccupancyId(transportData.getLevelOfOccupancyId());
					tpd.setTypeOfVehicleId(transportData.getTypeOfVehicleId());
					tpd.setModified(LocalDateTime.now());
					tpd.updateEnergyEmissionsValues();
					TransportData newtpd = this.transportDataRepository.save(tpd);
					try {
						return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newtpd.toJsonMap()), HttpStatus.OK);
					} catch (JsonProcessingException e) {
						return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
					}
				} else {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.transportRecordNotPresent), HttpStatus.UNAUTHORIZED);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// delete transport data record
	@DeleteMapping("/transport/{id}")
	public ResponseEntity<String> deleteTransportData(@PathVariable ("id") long tpdId, @RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "DELETE /transport/" + tpdId);
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				if (this.transportDataRepository.findById(tpdId).isPresent()) {					
					this.transportDataRepository.deleteById(tpdId);
					return new ResponseEntity<String>("", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.transportRecordNotPresent), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}
			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	// get list of transport data records
	@GetMapping("/transport")
	public ResponseEntity<String> getTransportationData(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /transport");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				User user = this.userRepository.findByEmail(token.get().getEmail()).get();
				List<TransportData> transportDataList = this.transportDataRepository.findAllByUserId(user.getId());
				List<Map<String, Object>> output = new ArrayList<Map<String,Object>>();
				for (TransportData transportData:transportDataList) {
					output.add(transportData.toJsonMap());
				}
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output), HttpStatus.OK);
				} catch (JsonProcessingException e) {

					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// get transport data summary
	@GetMapping("/transport/summary")
	public ResponseEntity<String> getSummaryTransportationData(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /transport/summary");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				User user = this.userRepository.findByEmail(token.get().getEmail()).get();
				int days = this.transportDataRepository.countDistinctDateOfTravel(user.getId());
				float energy = this.transportDataRepository.sumEnergyConsumption(user.getId());
				float emissions = this.transportDataRepository.sumEmissions(user.getId());
				Map<String, Object> map = new HashMap<>();
				map.put("numberOfDays", days);
				map.put("totalEnergyConsumption", energy);
				map.put("totalEmissions", emissions);
				map.put("energyConsumptionPerDay", energy/(float)days);
				map.put("emissionsPerDay", emissions/(float)days);
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	/*
	 * 
	 * 	HOUSEHOLD MODULE
	 * 
	 * 
	 */
	
	// get sites
	@GetMapping("/heating-sources")
	public ResponseEntity<String> getHeatingSources(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /heating-sources");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				List<HeatingSource> heatingSources = this.heatingSourceRepository.findAll();
				List<Map<String, Object>> output = new ArrayList<Map<String,Object>>();
				for (HeatingSource heatingSource:heatingSources) {
					output.add(heatingSource.toJsonMap());
				}
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output), HttpStatus.OK);
				} catch (JsonProcessingException e) {

					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}

	// add household data record
	@PutMapping("/household")
	public ResponseEntity<String> createHouseholdData(@RequestHeader Map<String, String> headers, @RequestBody HouseholdData householdData) {
		logger.log(Level.INFO, "PUT /household");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				HouseholdData hd = new HouseholdData(householdData.getUserId(), householdData.getCountryId(), householdData.getHeatingSourceId(), householdData.getSiteId(), householdData.getNumberOfPersons(), householdData.getInitialDate(), householdData.getFinalDate(), householdData.getElectricityConsumption(), householdData.getThermalConsumption());
				HouseholdData newHd = this.householdDataRepository.save(hd);
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newHd.toJsonMap()), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}				
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// update household data record
	@PatchMapping("/household/{id}")
	public ResponseEntity<String> updateHouseholdData(@PathVariable ("id") long hdId, @RequestHeader Map<String, String> headers, @RequestBody HouseholdData householdData) {
		logger.log(Level.INFO, "PATCH /household/" + hdId);
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
					if (this.householdDataRepository.findByIdAndUserId(hdId, householdData.getUserId()).isPresent()) {
						HouseholdData hd = this.householdDataRepository.findByIdAndUserId(hdId, householdData.getUserId()).get();
						hd.setCountryId(householdData.getCountryId());
						hd.setSiteId(householdData.getSiteId());
						hd.setHeatingSourceId(householdData.getHeatingSourceId());
						hd.setNumberOfPersons(householdData.getNumberOfPersons());
						hd.setInitialDate(householdData.getInitialDate());
						hd.setFinalDate(householdData.getFinalDate());
						hd.setElectricityConsumption(householdData.getElectricityConsumption());
						hd.setThermalConsumption(householdData.getThermalConsumption());
						hd.updateConsumptionValues();
						HouseholdData newHd = this.householdDataRepository.save(hd);
						try {
							return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newHd.toJsonMap()), HttpStatus.OK);
						} catch (JsonProcessingException e) {
							return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
						}
					} else {
						return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.householdRecordNotPresent), HttpStatus.UNAUTHORIZED);
					}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// delete transport data record
	@DeleteMapping("/household/{id}")
	public ResponseEntity<String> deleteHouseholdData(@PathVariable ("id") long hdId, @RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "DELETE /household/" + hdId);
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				if (this.householdDataRepository.findById(hdId).isPresent()) {					
					this.householdDataRepository.deleteById(hdId);
					return new ResponseEntity<String>("", HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.householdRecordNotPresent), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}
			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);

	}
	
	// get list of household data records
	@GetMapping("/household")
	public ResponseEntity<String> getHouseholdData(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /household");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				User user = this.userRepository.findByEmail(token.get().getEmail()).get();
				List<HouseholdData> householdDataList = this.householdDataRepository.findAllByUserId(user.getId());
				List<Map<String, Object>> output = new ArrayList<Map<String,Object>>();
				for (HouseholdData householdData:householdDataList) {
					output.add(householdData.toJsonMap());
				}
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output), HttpStatus.OK);
				} catch (JsonProcessingException e) {

					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// get transport data summary
	@GetMapping("/household/summary")
	public ResponseEntity<String> getSummaryHouseholdData(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /household/summary");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				User user = this.userRepository.findByEmail(token.get().getEmail()).get();
				int exists = this.householdDataRepository.existUser(user.getId());
				Map<String, Object> map = new HashMap<>();
				if (exists != 0) {
					Map<String,Object> summaryUser = this.householdDataRepository.getSummaryUser(user.getId());
					
					int days = ((BigDecimal) summaryUser.get("NOD")).intValue();
					double electricityConsumptionPerCapita = (double) summaryUser.get("ECPC");
					double thermalConsumptionPerCapita = (double) summaryUser.get("TCPC");
					double emissionsElectricityConsumption = (double) summaryUser.get("EEC");
					double emissionsThermalConsumption = (double) summaryUser.get("ETC");
					
					map.put("numberOfDays", days);
					map.put("totalElectricityConsumptionPerCapita", electricityConsumptionPerCapita);
					map.put("totalEmissionsElectricityConsumption", emissionsElectricityConsumption);
					map.put("totalThermalConsumptionPerCapita", thermalConsumptionPerCapita);
					map.put("totalEmissionsThermalConsumption", emissionsThermalConsumption);
					map.put("totalElectricityConsumptionPerCapitaPerDay", electricityConsumptionPerCapita/days);
					map.put("totalEmissionsElectricityConsumptionPerDay", emissionsElectricityConsumption/days);
					map.put("totalThermalConsumptionPerCapitaPerDay", thermalConsumptionPerCapita/days);
					map.put("totalEmissionsThermalConsumptionPerDay", emissionsThermalConsumption/days);
					List<Long> siteIds = this.householdDataRepository.getSiteIds(user.getId());
					for (Long siteId:siteIds) {
						Map<String, Object> site = new HashMap<>();
						if (this.siteRepository.existsById(siteId)) {							
							Map<String,Object> summaryUserSite = this.householdDataRepository.getSummaryUserPerSite(user.getId(),siteId);
							days = ((BigDecimal) summaryUserSite.get("NOD")).intValue();
							electricityConsumptionPerCapita = (double) summaryUserSite.get("ECPC");
							thermalConsumptionPerCapita = (double) summaryUserSite.get("TCPC");
							emissionsElectricityConsumption = (double) summaryUserSite.get("EEC");
							emissionsThermalConsumption = (double) summaryUserSite.get("ETC");
							site.put("numberOfDays", days);
							site.put("totalElectricityConsumptionPerCapita", electricityConsumptionPerCapita);
							site.put("totalEmissionsElectricityConsumption", emissionsElectricityConsumption);
							site.put("totalThermalConsumptionPerCapita", thermalConsumptionPerCapita);
							site.put("totalEmissionsThermalConsumption", emissionsThermalConsumption);
							site.put("totalElectricityConsumptionPerCapitaPerDay", electricityConsumptionPerCapita/days);
							site.put("totalEmissionsElectricityConsumptionPerDay", emissionsElectricityConsumption/days);
							site.put("totalThermalConsumptionPerCapitaPerDay", thermalConsumptionPerCapita/days);
							site.put("totalEmissionsThermalConsumptionPerDay", emissionsThermalConsumption/days);
							if (this.siteRepository.isPrimaryHouse(siteId)){
								map.put("primaryHouse:", site);
							} else {
								map.put("secondaryHouse:", site);
							}
						}
					}
				}
				
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map), HttpStatus.OK);
				} catch (JsonProcessingException e) {
					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	/*
	 * 
	 * 	HOUSE MODULE
	 * 
	 * 
	 */
	
	// get sites
	@GetMapping("/notifications")
	public ResponseEntity<String> getNotifications(@RequestHeader Map<String, String> headers) {
		logger.log(Level.INFO, "GET /notifications");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				List<Notification> notifications = this.notificationRepository.findAll();
				List<Map<String, Object>> output = new ArrayList<Map<String,Object>>();
				for (Notification notification:notifications) {
					output.add(notification.toJsonMap());
				}
				try {
					return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(output), HttpStatus.OK);
				} catch (JsonProcessingException e) {

					return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// update household data record
	@PatchMapping("/notifications/{id}")
	public ResponseEntity<String> updateNotification(@PathVariable ("id") long id, @RequestHeader Map<String, String> headers, @RequestBody Notification notification) {
		logger.log(Level.INFO, "PATCH /notifications/" + id);
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
					if (this.notificationRepository.findById(id).isPresent()) {
						Notification not = this.notificationRepository.findById(id).get();
						not.setFrequency(notification.getFrequency());
						not.setFrequencyValue(notification.getFrequencyValue());
						Notification newNot = this.notificationRepository.save(not);
						try {
							return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newNot.toJsonMap()), HttpStatus.OK);
						} catch (JsonProcessingException e) {
							return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.unexpectedError), HttpStatus.BAD_REQUEST);
						}
					} else {
						return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.notificationRecordNotPresent), HttpStatus.UNAUTHORIZED);
					}
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
	
	// update household data record
	@PutMapping("/notifications/device-token")
	public ResponseEntity<String> putDeviceToken(@RequestHeader Map<String, String> headers, @RequestBody DeviceToken deviceToken) {
		logger.log(Level.INFO, "PUT /notifications/device-token");
		if (headers.containsKey("authorization")) {
			String accessToken = headers.get("authorization").replace("Bearer ", "");
			Optional<Token> token = this.tokenRepository.findByAccessToken(accessToken);
			if (token.isPresent() && token.get().getAccessToken().equals(accessToken)) {
				User user = this.userRepository.findByEmail(token.get().getEmail()).get();
				deviceToken.setUserId(user.getId());
				this.deviceTokenRepository.save(deviceToken);
				return new ResponseEntity<String>("", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.invalidAccessToken), HttpStatus.UNAUTHORIZED);
			}			
		} else
			return new ResponseEntity<String>(CodesMessages.createMessage(CodesMessages.authorizationHeaderNotPresent), HttpStatus.BAD_REQUEST);
	}
}

