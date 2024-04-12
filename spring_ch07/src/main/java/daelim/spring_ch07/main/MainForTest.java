package daelim.spring_ch07.main;

import daelim.spring_ch07.config.AppContext;
import daelim.spring_ch07.db.DbQuery;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        DbQuery dbQuery = ctx.getBean("dbQuery", DbQuery.class);
        System.out.println(dbQuery.count());
    }
}
