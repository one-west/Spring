package daelim.book.rental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {
    
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost("smtp.gmail.com");
        javaMailSenderImpl.setPort(587);
        javaMailSenderImpl.setUsername("wjdgkstj112@gmail.com");
        javaMailSenderImpl.setPassword("xymbdnmbbtwxlphf");
        
        Properties properties = javaMailSenderImpl.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        
        return javaMailSenderImpl;
    }
}
