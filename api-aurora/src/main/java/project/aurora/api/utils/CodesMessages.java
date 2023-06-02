package project.aurora.api.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CodesMessages {
	
	public static String unexpectedError = "unexpectedError";
	public static String accessTokenInvalid = "accessTokenInvalid";
	public static String userEmailInUse = "userEmailInUse";
	public static String invalidCredencials = "invalidCredencials";
	public static String userNotFound = "userNotFound";
	public static String invalidAccessToken = "invalidAccessToken";
	public static String authorizationHeaderNotPresent = "authorizationHeaderNotPresent";
	public static String errorSendingEmail = "errorSendingEmail";
	public static String emailCodeNotPresent = "emailCodeNotPresent";
	public static String passwordCodeNotPresent = "passwordCodeNotPresent";
	public static String transportRecordNotPresent = "transportRecordNotPresent";
	public static String householdRecordNotPresent = "householdRecordNotPresent";
	public static String notificationRecordNotPresent = "notificationRecordNotPresent";
	
	public static Map<String, String> messages;
	static {
		messages = new HashMap<String, String>();
		messages.put(unexpectedError, "An unexpected error has occurred. Please contact your system Administrator");
		messages.put(accessTokenInvalid, "Bad request");
		messages.put(userEmailInUse, "Email already in use, use another email");
		messages.put(invalidCredencials, "Invalid credentials used, please check email and/or password");
		messages.put(userNotFound, "No user found with this email, please check email used for login");
		messages.put(invalidAccessToken, "Provided invalid access token");
		messages.put(authorizationHeaderNotPresent, "Authorization header is not present in the request");
		messages.put(errorSendingEmail, "An unexpected error has occurred while sending email. Please contact your system Administrator");
		messages.put(emailCodeNotPresent, "Email code provided is not valid. Please check the code entered or ask for a new one.");
		messages.put(passwordCodeNotPresent, "Password code provided is not valid. Please check the code entered or ask for a new one.");
		messages.put(transportRecordNotPresent, "Transport record ID is not valid.");
		messages.put(householdRecordNotPresent, "Household record ID is not valid.");
		messages.put(notificationRecordNotPresent, "Notification record ID is not valid.");

	}
	
	public static String createMessage(String code) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("message", messages.get(code));
		try {
			return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map);
		} catch (JsonProcessingException e) {
			return "{ \n"+
					  "	\"code\": \"" + code + "\", \n"+
					  "	\"message\": \"\" + messages.get(code) + \"\" \n" +
					"}";
		}
	}

}
