package daelim.spring_ch04.config;

import daelim.spring_ch04.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"daelim.spring_ch04", "test"})
//        excludeFilters = {
//            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class),
//            @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "daelim.spring_ch04.*Service")
//        })

public class AppContext {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

//    @Bean
//    public MemberRegisterService memberRegisterService() {
////        return new MemberRegisterService(memberDao());
//        return new MemberRegisterService();
//    }

//    @Bean
//    public ChangePasswordService changePasswordService() {
//        ChangePasswordService changePasswordService = new ChangePasswordService();
////        세터 메서드를 통해 직접 의족을 주입하지 않아도 스프링이 @Autowired가 붙은 필드에 해당 타입의 빈 객체를 찾아서 주입한다.
////        changePasswordService.setMemberDao(memberDao());
//        return changePasswordService;
//    }

    @Bean
    @Qualifier("memberPrinter")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }
    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummryPrinter memberPrinter2() {
        return new MemberSummryPrinter();
    }

//    @Bean
//    public MemberList memberList() {
////        return new MemberList(memberDao(), memberPrinter());
//        return new MemberList();
//    }

//    @Bean
//    public MemberInfoPrinter memberInfoPrinter() {
//        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
//        //memberInfoPrinter.setMemberDao(memberDao());
//        memberInfoPrinter.setMemberPrinter(memberPrinter2());
//        return memberInfoPrinter;
//    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(2);
        versionPrinter.setMinorVersion(1);
        return versionPrinter;
    }
}
