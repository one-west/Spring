package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect {

    // Pointcut 공통기능을 적용할 대상
    @Pointcut("execution(public * daelim.spring_ch06..*(..))")
    private void publicTarget() {
    }

    // Advice
    @Around("publicTarget()")
    public Object main(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        try {
            Object result = joinPoint.proceed();
            return result;

        } finally {
            long end = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            // Object getTarget() : 대상객체를 구한다.
            // Object[] getArgs() : 파라미터 목록을 구한다.
            // sig.getName() : 호출되는 메서드의 이름을 구한다.
            System.out.printf("%s %s(%s) 실행시간 : %d\n", joinPoint.getTarget(), sig.getName(), Arrays.toString(joinPoint.getArgs()), end - start);
        }
    }
}
