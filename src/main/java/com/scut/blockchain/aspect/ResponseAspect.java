package com.scut.blockchain.aspect;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ResponseAspect {

    @Data
    public static class GeneralResponse {
        private Integer errno = 0;
        private String errmsg = "Success";
        private Object data;
    }

    public Object createStandardResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        GeneralResponse response = new GeneralResponse();
        try {
            Object result = joinPoint.proceed();
            response.setData(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Around("execution(* com.scut.blockchain.controller.BankController.*(..)) ||" +
            "execution(* com.scut.blockchain.controller.CompanyController.*(..)) ||" +
            "execution(* com.scut.blockchain.controller.indexController.*(..)) ||" +
            "execution(* com.scut.blockchain.controller.LoginController.*(..)) ||" +
            "execution(* com.scut.blockchain.controller.RegisterController.*(..)) ||" +
            "execution(* com.scut.blockchain.controller.UserController.*(..))")
    public Object amplifyReturn(ProceedingJoinPoint joinPoint) throws Throwable {
        return createStandardResponse(joinPoint);
    }

    private void printStackTraceToLog(Exception e) {
        String exceptionType = e.toString();
        StackTraceElement[] stackTrace = e.getStackTrace();

        StringBuilder stringBuilder = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuilder.append(stackTraceElement.toString()).append("\n");
        }
        log.error("Exception: {}, {}", exceptionType, stringBuilder.toString());
    }
}
