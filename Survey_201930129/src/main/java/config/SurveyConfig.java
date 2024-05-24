package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import survey.SurveyDao;
import survey.SurveyRegisterService;

@Configuration
@EnableTransactionManagement
public class SurveyConfig {
    
    @Bean
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://daelim-spring.cxo2064mukrj.ap-northeast-2.rds.amazonaws.com/library?characterEncoding=UTF-8");
        ds.setUsername("admin");
        ds.setPassword("daelimspring");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        return ds;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
    
    @Bean
    public SurveyDao memberDao() {
        return new SurveyDao(dataSource());
    }
    
    @Bean
    public SurveyRegisterService surveyRegisterService() {
        return new SurveyRegisterService();
    }
}
