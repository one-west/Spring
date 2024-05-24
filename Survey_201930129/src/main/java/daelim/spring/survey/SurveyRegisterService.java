package daelim.spring.survey;

import daelim.spring.controller.SurveyCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SurveyRegisterService {
    
    @Autowired
    private SurveyDao surveyDao;
    
    public void MemberRegisterService() {
    }
    
    public List<Survey> selectAll() {
        System.out.println("[SurveyRegisterService.selectAll()]");
        return surveyDao.selectAll();
    }
    
    public void register(SurveyCommand surveyCommand) {
        surveyDao.insert(new Survey(surveyCommand.getQ1(), surveyCommand.getQ2(), surveyCommand.getQ3(), surveyCommand.getRespondentName(), Integer.parseInt(surveyCommand.getRespondentAge()), LocalDateTime.now()));
    }
}
