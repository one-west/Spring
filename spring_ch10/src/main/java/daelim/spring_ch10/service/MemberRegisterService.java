package daelim.spring_ch10.service;

import daelim.spring_ch10.DuplicationMemberException;
import daelim.spring_ch10.Member;
import daelim.spring_ch10.MemberDao;
import daelim.spring_ch10.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Collection;

public class MemberRegisterService {

    @Autowired
    private MemberDao memberDao;

    public MemberRegisterService() {
    }

    public void regist(RegisterRequest req) {
        // 1 이메일로 회원 데이터 조회
        Member member = memberDao.selectByEmail(req.getEmail());
        // 2 member !=  null : 이미 가입된 이메일을 가진 회원이 존재한다면 
        // Exception 예외처리
        if (member != null) {
            throw new DuplicationMemberException("Duplication Email : " + req.getEmail());
        }
        // 3 신규 회원등록
        memberDao.insert(new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()));
    }

    public void selectAll() {
        Collection<Member> members = memberDao.selectAll();
        for (Member member : members) {
            System.out.println(member.getId() + " : " + member.getName() + "(" + member.getEmail() + ")");
        }
    }
}
