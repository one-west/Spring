package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import survey.Survey;
import survey.SurveyRegisterService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {
    
    @Autowired
    private SurveyRegisterService surveyRegisterService;
    
    @GetMapping("/surveyForm")
    public String surveyForm(Model model) {
        System.out.println("[SurveyController.surveyForm()]");
        model.addAttribute("surveyCommand", new SurveyCommand());
        return "survey/surveyForm";
    }
    
    @PostMapping("/surveyForm")
    public String surveyComplete(@Valid SurveyCommand surveyCommand, Errors errors) {
        System.out.println("[SurveyController.surveyComplete()]");
        if (errors.hasErrors()) {
            return "survey/surveyForm";
        }
        
        try {
            surveyRegisterService.register(surveyCommand);
            return "survey/surveyComplete";
        } catch (Exception e) {
            e.printStackTrace();
            return "survey/surveyForm";
        }
    }
    
    @GetMapping("/surveyList")
    public String surveyList(Model model) {
        System.out.println("[SurveyController.surveyList()]");
        
        List<Survey> surveyList = surveyRegisterService.selectAll();
        model.addAttribute("list",surveyList);
        return "survey/surveyList";
    }
}
