package daelim.spring.controller;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class SurveyCommand {
    
    @NotEmpty
    private String q1;
    
    @NotEmpty
    private String q2;
    
    @NotEmpty
    private String q3;
    
    @NotBlank
    private String respondentName;
    
    @Min(value = 1)
    private String respondentAge;
    
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
    
    public String getRespondentAge() {
        return respondentAge;
    }
    
    public void setRespondentAge(String respondentAge) {
        this.respondentAge = respondentAge;
    }
}
