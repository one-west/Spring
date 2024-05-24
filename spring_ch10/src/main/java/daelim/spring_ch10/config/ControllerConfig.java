package daelim.spring_ch10.config;

import daelim.spring_ch10.controller.HelloController;
import daelim.spring_ch10.controller.LoginController;
import daelim.spring_ch10.controller.RegisterController;
import daelim.spring_ch10.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    private AuthService authService;

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }

    @Bean
    public LoginController loginController() {
        LoginController loginController = new LoginController();
        loginController.setAuthService(authService);
        return loginController;
    }
}
