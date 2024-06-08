package daelim.book.rental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileConfig {
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8"); // 파일인코딩
        multipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024); // 파일 당 업로드 크기 제한(5MB)
        return multipartResolver;
    }
}
