package daelim.spring_ch02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    @Bean /* B */
    public Greeter greeter() {
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕");
        return g;
    }
}
