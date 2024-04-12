package daelim.java_ch02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
//        MyCalculator calculator = new MyCalculator();
//        calculator.calculator(10, 5, new CalAdd());
//        calculator.calculator(10, 5, new CalSub());
//        calculator.calculator(10, 5, new CalMul());
//        calculator.calculator(10, 5, new CalDiv());
//        new CalAssembler().assembler();

        /* XML 사용 */
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");

        /* Annotation 사용 */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        CalAssembler calAssembler = ctx.getBean("calAssembler", CalAssembler.class);
        calAssembler.assemble();

        ctx.close();
    }
}
