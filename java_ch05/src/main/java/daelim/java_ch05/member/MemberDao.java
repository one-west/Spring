package daelim.java_ch05.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemberDao {

    private Map<String, MemberVo> memberMap = new HashMap<String, MemberVo>();

    public void insertMember(MemberVo memberVo) {
        System.out.println("MemberDao::insertMember");
        System.out.println("id: " + memberVo.getId());
        System.out.println("password: " + memberVo.getPassword());
        System.out.println("email: " + memberVo.getEmail());
        System.out.println("phone: " + memberVo.getPhone());

        memberMap.put(memberVo.getId(), memberVo);

    }
}
