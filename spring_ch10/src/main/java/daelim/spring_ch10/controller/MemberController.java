package daelim.spring_ch10.controller;

import daelim.spring_ch10.ListCommand;
import daelim.spring_ch10.Member;
import daelim.spring_ch10.MemberNotFoundException;
import daelim.spring_ch10.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    
    @Autowired
    private MemberService memberService;
    
    @RequestMapping("/members")
    public String list(@ModelAttribute("cmd") ListCommand listCommand, Model model, Errors errors) {
        
        if (errors.hasErrors()) {
            System.out.println(errors);
            return "member/memberList";
        }
        
        if (listCommand.getFrom() != null && listCommand.getTo() != null) {
            System.out.println("time : " + listCommand.getFrom() + " / " + listCommand.getTo());
            List<Member> members = memberService.selectByRegdate(listCommand);
            model.addAttribute("members", members);
        }
        
        return "member/memberList";
    }
    
    @GetMapping("/members/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Member member = memberService.selectById(id);
        if (member == null) throw new MemberNotFoundException();
        model.addAttribute("member", member);
        return "member/memberdetail";
    }
    
//    @ExceptionHandler(TypeMismatchException.class)
//    public String handleTypeMismatchException() {
//        return "member/invalidId";
//    }
//
//    @ExceptionHandler(MemberNotFoundException.class)
//    public String handleMemberNotFoundException() {
//        return "member/noMember";
//    }
}
