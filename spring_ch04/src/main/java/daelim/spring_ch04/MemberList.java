package daelim.spring_ch04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MemberList {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    @Qualifier("summaryPrinter")
    private MemberPrinter memberPrinter;

//    public MemberList(MemberDao memberDao, MemberPrinter memberPrinter) {
//        this.memberDao = memberDao;
//        this.memberPrinter = memberPrinter;
//    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(member -> memberPrinter.print(member));
    }
}
