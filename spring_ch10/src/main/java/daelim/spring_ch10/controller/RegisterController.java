package daelim.spring_ch10.controller;

import daelim.spring_ch10.DuplicationMemberException;
import daelim.spring_ch10.service.MemberRegisterService;
import daelim.spring_ch10.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    public MemberRegisterService memberRegisterService;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("register/step1")
    public String handstep1() {
        System.out.println("Step 1 >>>>>");
        return "register/step1";
    }

    @GetMapping("register/step2")
    public String handstep2Get() {
        System.out.println("[GET] step2 >>>>>");
        return "redirect:/register/step1";
    }

    @PostMapping("register/step2")
    public String handstep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
        System.out.println("Step 2 >>>>>");
//        String agree = request.getParameter("agree");
        if (!agree) {
            return "redirect:/register/step1";
        }
        model.addAttribute("formData", new RegisterRequest());
        return "register/step2";
    }

    @PostMapping("/register/step3")
    public String handleStep3(@Valid @ModelAttribute("formData") RegisterRequest registerRequest, Errors errors) {
        System.out.println("[POST] step3 >>>");
        System.out.println(registerRequest.getName());
        System.out.println(registerRequest.getEmail());

//        new RegisterRequestValidator().validate(registerRequest, errors);
        System.out.println("Error: " + errors.hasErrors());
        if (errors.hasErrors()) {
            return "register/step2";
        }

        // service 로직
        try {
            memberRegisterService.regist(registerRequest);
            return "register/step3";
        } catch (DuplicationMemberException ex) {
            ex.printStackTrace();
            errors.rejectValue("email", "duplicate");
            return "redirect:register/step2";
        }

//        String email = request.getParameter("email");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String confirmPassword = request.getParameter("confirmPassword");
//
//        RegisterRequest regReq = new RegisterRequest();
//        regReq.setEmail(email);
//        regReq.setName(name);
//        regReq.setPassword(password);
//        regReq.setConfirmPassword(confirmPassword);
//        return "register/step3";
    }
}
