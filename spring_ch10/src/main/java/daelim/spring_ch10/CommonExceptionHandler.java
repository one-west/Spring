package daelim.spring_ch10;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"daelim.spring_ch10.controller"})
public class CommonExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        e.printStackTrace();
        return "error/commonException";
    }
    
    @ExceptionHandler(TypeMismatchException.class)
    public String handleTypeMismatchException() {
        return "member/invalidId";
    }
    
    @ExceptionHandler(MemberNotFoundException.class)
    public String handleMemberNotFoundException() {
        return "member/noMember";
    }
}
