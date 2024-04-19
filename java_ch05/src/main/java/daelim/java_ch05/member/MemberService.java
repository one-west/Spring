package daelim.java_ch05.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public int signUpCcnfirm(MemberVo memberVo) {
        System.out.println("MemberService::signUpCcnfirm");
        System.out.println("id : " + memberVo.getId());
        System.out.println("pw : " + memberVo.getPassword());
        System.out.println("email : " + memberVo.getEmail());
        System.out.println("phone : " + memberVo.getPhone());

        memberDao.insertMember(memberVo);
        return 0;
    }
}
