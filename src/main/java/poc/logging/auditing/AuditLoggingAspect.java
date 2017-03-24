package poc.logging.auditing;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by 310280812 on 3/24/2017.
 */

@Slf4j
@Aspect
@Component
public class AuditLoggingAspect {


    @Around("within(poc.logging..*) && @annotation(poc.logging.auditing.AuditController)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Starting to log....");
        log.debug("Join point kind : " + joinPoint.getKind());
        log.debug("Signature declaring type : "+ joinPoint.getSignature().getDeclaringTypeName());
        log.debug("Signature name : " + joinPoint.getSignature().getName());
        log.debug("Arguments : " + Arrays.toString(joinPoint.getArgs()));
        log.debug("Target class : "+ joinPoint.getTarget().getClass().getName());
        log.debug("This class : " + joinPoint.getThis().getClass().getName());

        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach( arg -> log.info("Arg: {}", arg));

        try {

            Object result = joinPoint.proceed(args);

            log.info("Result: {}", result);

            return result;
        }catch(Throwable ex) {
            log.error("ERROR >>>>>>>> {}", ex);
            throw ex;
        }
    }

}
