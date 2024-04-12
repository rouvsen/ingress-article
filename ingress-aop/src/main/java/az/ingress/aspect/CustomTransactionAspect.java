package az.ingress.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
@Component
@RequiredArgsConstructor
public class CustomTransactionAspect {

    private final PlatformTransactionManager transactionManager;

    @Around("@annotation(az.ingress.annotation.custom.CustomTransactional)")
    public Object manageCustomTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            Object result = joinPoint.proceed();
            transactionManager.commit(status);
            return result;
        } catch (Exception ex) {
            if (ex instanceof RuntimeException) {
                transactionManager.rollback(status);
                throw ex;
            } else {
                transactionManager.commit(status);
                throw new RuntimeException("Checked exception occurred but transaction committed", ex);
            }
        }
    }
}
