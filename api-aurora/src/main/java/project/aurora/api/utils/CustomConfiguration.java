package project.aurora.api.utils;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
	
	Logger logger = Logger.getLogger(CustomConfiguration.class.getSimpleName());
    
    @Value("${mail.smtp.host}")
    private String mailSmtpHost;
    
    @Value("${mail.smtp.port}")
    private String mailSmtpPort;
    
    @Value("${mail.smtp.user}")
    private String mailSmtpUser;
    
    @Value("${mail.smtp.pass}")
    private String mailSmtpPass;

    @Value("${mail.smtp.from}")
    private String mailSmtpFrom;
    
    @Value("${temp.path}")
    private String tempPath;
    
	@PostConstruct
	public void initializeApplication() {
	}

	public String getMailSmtpHost() {
		return mailSmtpHost;
	}

	public String getMailSmtpPort() {
		return mailSmtpPort;
	}

	public String getMailSmtpUser() {
		return mailSmtpUser;
	}

	public String getMailSmtpPass() {
		return mailSmtpPass;
	}

	public String getMailSmtpFrom() {
		return mailSmtpFrom;
	}

	public String getTempPath() {
		return tempPath;
	}
	
}
