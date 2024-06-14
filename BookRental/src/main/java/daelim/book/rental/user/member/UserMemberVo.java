package daelim.book.rental.user.member;

public class UserMemberVo {
    
    int no;              // 유저 번호
    String id;           // 유저 아이디
    String pw;           // 유저 비밀번호
    String name;         // 유저 이름
    
    public String getPw() {
        return pw;
    }
    
    public void setPw(String pw) {
        this.pw = pw;
    }
    
    String gender;       // 유저 성별 구분
    String email;        // 유저 이메일
    String phone;        // 유저 전화번호
    String regDate;      // 유저 등록일
    String modDate;      // 유저 수정일
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getModDate() {
        return modDate;
    }
    
    public void setModDate(String modDate) {
        this.modDate = modDate;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getRegDate() {
        return regDate;
    }
    
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
