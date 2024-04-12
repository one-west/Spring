package daelim.spring_ch03;

import com.sun.jdi.request.DuplicateRequestException;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
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
