package daelim.spring_ch10.service;

import daelim.spring_ch10.Member;
import daelim.spring_ch10.MemberDao;
import daelim.spring_ch10.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {

    @Autowired
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Transactional
    public void changePassword(String email, String oldPassword, String newPassword) {
        // 1. 이메일로 화면 조회
        Member member = memberDao.selectByEmail(email);
        // 2. 존재하지 않는 회원 예외처리
        if (member == null) {
            throw new MemberNotFoundException();
        }
        // 3. 비밀번호 변경
        member.changePassword(oldPassword, newPassword);
        memberDao.update(member);
    }


}
