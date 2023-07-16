package security;

import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import mailservice.EmailServiceImpl;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	
	@Bean
	public EmailServiceImpl getemail() {
		return new EmailServiceImpl();
	}
}
