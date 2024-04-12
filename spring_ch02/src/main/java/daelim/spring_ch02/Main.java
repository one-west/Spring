package daelim.spring_ch02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Greeter g = new Greeter();
//        g.setFormat("%s, 안녕");
//        String a = g.greet("spring");
//        System.out.println(a);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        Greeter g = ctx.getBean("greeter", Greeter.class);
        String msg = g.greet("spring");
        System.out.println(msg);

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g == g2);
        ctx.close();
    }
}
