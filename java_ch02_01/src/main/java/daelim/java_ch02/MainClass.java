package daelim.java_ch02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext gxc = new GenericXmlApplicationContext("classpath:applicationContext.xml");
        TransportationWalk transportationWalk = gxc.getBean("transportationWalk", TransportationWalk.class);
        transportationWalk.move();

        gxc.close();
    }
}
