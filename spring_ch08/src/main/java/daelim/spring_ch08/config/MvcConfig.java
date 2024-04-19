package daelim.spring_ch08.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
@EnableWebMvc // spring MVC 설정을 활성화 시킨다는 의미
public class MvcConfig implements WebMvcConfigurer {
    // 정적 콘텐츠 처리 설정
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 고정적인 리소스에 대한 요청을 직접 처리하지 않고, 서블릿 컨테이너의 디폴트 서블릿 전달 요청
        configurer.enable();
    }

    // .jsp파일을 찾기 위한 메서드
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }


}
