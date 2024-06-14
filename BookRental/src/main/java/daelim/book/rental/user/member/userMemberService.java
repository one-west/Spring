package daelim.book.rental.user.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Service
public class userMemberService {
    
    final static public int ADMIN_ACCOUNT_ALREADY_EXISTS = 0;
    final static public int ADMIN_ACCOUNT_CREATE_SUCCESS = 1;
    final static public int ADMIN_ACCOUNT_CREATE_FAIL = -1;
    
    @Autowired
    private UserMemberDao userMemberDao;
    
    @Autowired
    JavaMailSender javaMailSender;
    
    public int createAccount(UserMemberVo adminMemberVo) {
        System.out.println("[UserMemberService] createAccount");
        
        boolean isMember = userMemberDao.exsitUserAccount(adminMemberVo.getId());
        if (!isMember) {
            int result = userMemberDao.insertUserAccount(adminMemberVo);
            if (result > 0) {
                System.out.println("[UserMemberService] createAccount success");
                return ADMIN_ACCOUNT_CREATE_SUCCESS;
            } else {
                System.out.println("[UserMemberService] createAccount fail");
                return ADMIN_ACCOUNT_CREATE_FAIL;
            }
        } else {
            System.out.println("[UserMemberService] createAccount already exists");
            return ADMIN_ACCOUNT_ALREADY_EXISTS;
        }
    }
    
    public UserMemberVo loginConfirm(UserMemberVo userMemberVo) {
        System.out.println("[UserMemberService] loginConfirm()");
        UserMemberVo loginedAdminMemberVo = userMemberDao.selectUser(userMemberVo);
        
        if (loginedAdminMemberVo != null) {
            System.out.println("[UserMemberService] loginConfirm success");
        } else {
            System.out.println("[UserMemberService] loginConfirm fail");
        }
        return loginedAdminMemberVo;
    }
    
    public List<UserMemberVo> selectAllAdmin() {
        System.out.println("[UserMemberService] getAllAdminMembers");
        return userMemberDao.selectAllUser();
    }
    
    public void setAdminApproval(int no) {
        System.out.println("[UserMemberService] setAdminApproval " + no);
        int result = userMemberDao.updateAdminAccount(no);
    }
    
    public int modifyAccountConfirm(UserMemberVo adminMemberVo) {
        System.out.println("[UserMemberService] modifyAccountConfirm()");
        return userMemberDao.updateAdminAccount(adminMemberVo);
    }
    
    public UserMemberVo getLoginedAdminMemberVo(int no) {
        System.out.println("[UserMemberService] getLoginedUserMemberVo()");
        return userMemberDao.selectUser(no);
    }
    
    public int findPasswordConfirm(UserMemberVo adminMemberVo) {
        System.out.println("[UserMemberService] findPasswordConfirm()");
        UserMemberVo selectUserMemberVo = userMemberDao.selectUser(adminMemberVo.getId(), adminMemberVo.getName(), adminMemberVo.getEmail());
        
        int result = 0;
        if (selectUserMemberVo != null) {
            // 2. 일치하는 사용자가 있으면 신규 비밀번호 생성 후 업데이트 비밀번호
            String newPassword = createNewPassword();
            result = userMemberDao.updatePassword(adminMemberVo.getId(), newPassword);
            
            // 3. 신규 비밀번호를 포함한 이메일 발송
            if (result > 0) {
                sendNewPasswordByMail(adminMemberVo.getEmail(), newPassword);
            }
        }
        return result;
        
    }
    
    private String createNewPassword() {
        System.out.println("[AdminMemberService] createNewPassword()");
        
        char[] chars = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'
        };
        
        StringBuffer stringBuffer = new StringBuffer();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(new Date().getTime());
        
        int index = 0;
        int length = chars.length;
        for (int i = 0; i < 8; i++) {
            index = secureRandom.nextInt(length);
            if (index % 2 == 0) {
                stringBuffer.append(String.valueOf(chars[index]).toUpperCase());
            } else {
                stringBuffer.append(String.valueOf(chars[index]).toLowerCase());
            }
        }
        System.out.println("[AdminMemberService] NEW PASSWORD: " + stringBuffer.toString());
        return stringBuffer.toString();
    }
    
    private void sendNewPasswordByMail(String toMailAddr, String newPassword) {
        System.out.println("[AdminMemberService] sendNewPasswordByMail()");
        
        final MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                final MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setTo(toMailAddr);
                mimeMessageHelper.setSubject("[한서 도서관] 새 비밀번호 안내입니다.");
                mimeMessageHelper.setText("새 비밀번호 : " + newPassword, true);
            }
        };
        
        javaMailSender.send(mimeMessagePreparator);
    }
}