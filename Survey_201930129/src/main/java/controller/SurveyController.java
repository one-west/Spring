package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SurveyController {
    
    @GetMapping("/survey")
    public String submit(Errors errors, HttpSession session, HttpServletResponse response) {
        return "survey/surveyForm";
    }
}
