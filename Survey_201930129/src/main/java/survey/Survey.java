package survey;

import java.time.LocalDateTime;

public class Survey {
    private Long id;
    private String q1;
    private String q2;
    private String q3;
    private String respondentName;
    private int respondentAge;
    private LocalDateTime regDate;
    
    public Survey(String field, String devtool, String talk, String respondentName, int respondentAge, LocalDateTime regDate) {
        this.q1 = field;
        this.q2 = devtool;
        this.q3 = talk;
        this.respondentName = respondentName;
        this.respondentAge = respondentAge;
        this.regDate = regDate;
    }
    
    public Survey() {
    
    }
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getQ1() {
        return q1;
    }
    
    public void setQ1(String q1) {
        this.q1 = q1;
    }
    
    public String getQ2() {
        return q2;
    }
    
    public void setQ2(String q2) {
        this.q2 = q2;
    }
    
    public String getQ3() {
        return q3;
    }
    
    public void setQ3(String q3) {
        this.q3 = q3;
    }
    
    public String getRespondentName() {
        return respondentName;
    }
    
    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
    }
    
    public int getRespondentAge() {
        return respondentAge;
    }
    
    public void setRespondentAge(int respondentAge) {
        this.respondentAge = respondentAge;
    }
    
    public LocalDateTime getRegDate() {
        return regDate;
    }
    
    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }
}
