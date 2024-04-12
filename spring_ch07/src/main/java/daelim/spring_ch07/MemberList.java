package daelim.spring_ch07;

import java.util.Collection;

public class MemberList {
    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public MemberList(MemberDao memberDao, MemberPrinter memberPrinter) {
        this.memberDao = memberDao;
        this.memberPrinter = memberPrinter;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(member -> memberPrinter.print(member));
    }
}
