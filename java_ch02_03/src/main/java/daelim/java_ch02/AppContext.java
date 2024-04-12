package daelim.java_ch02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    private CalDiv calDiv;

    @Bean
    public CalAdd callAdd(){
        return new CalAdd();
    }

    @Bean
    public CalSub callSub(){
        return new CalSub();
    }

    @Bean
    public CalMul callMul(){
        return new CalMul();
    }

    @Bean
    public CalDiv callDiv(){
        return new CalDiv();
    }

    @Bean
    public MyCalculator myCalculator(){
        return new MyCalculator();
    }

    @Bean
    public CalAssembler calAssembler(){
        return new CalAssembler(myCalculator(), callAdd(), callSub(), callMul(), callDiv());
    }
}
