package survey;

import java.time.LocalDateTime;

public class Survey {
    private String field;
    private String devtool;
    private String talk;
    private String respondentName;
    private String respondentAge;
    private LocalDateTime regDate;

    public String getDevtool() {
        return devtool;
    }

    public void setDevtool(String devtool) {
        this.devtool = devtool;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getRespondentAge() {
        return respondentAge;
    }

    public void setRespondentAge(String respondentAge) {
        this.respondentAge = respondentAge;
    }

    public String getRespondentName() {
        return respondentName;
    }

    public void setRespondentName(String respondentName) {
        this.respondentName = respondentName;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }
}
