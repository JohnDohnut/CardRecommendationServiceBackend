package com.team7.aspect;

import com.team7.db.model.log.RequestLog;
import com.team7.db.repository.log.RequestLogRepository;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Request;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class AOPLogger {

    private final RequestLogRepository requestLogRepository;

    // 특정 패키지의 모든 메서드를 대상으로 설정
    @Pointcut("execution(* com.team7.controller..*(..))")
    public void controllerMethods() {}

    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        // 메서드 호출 전에 로그 출력
        log.info("Before: " + joinPoint.getSignature().getName());

        String username = SecurityContextHolder.getContext().getAuthentication().getName();


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        // IP 주소 가져오기
        String ipAddress = request.getRemoteAddr();

        // 요청 URL 가져오기
        String url = request.getRequestURL().toString();

        // 메서드 타입 가져오기
        String methodType = request.getMethod();
        // 로그에 기록
        System.out.println("Request from IP " + ipAddress + " to URL " + url + " with method " + methodType);



    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // 메서드 실행 후 로그 출력
        log.info("After: " + joinPoint.getSignature().getName() + ", Return: " + result);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String ipAddress = request.getRemoteAddr();
        String url = request.getRequestURL().toString();
        String methodType = request.getMethod();

        int status = response.getStatus();

        RequestLog requestLog = new RequestLog(0L, ipAddress, username, url, methodType, Integer.toString(status));

        System.out.println(username);
        System.out.println(ipAddress);
        System.out.println(url);
        System.out.println(methodType);
        System.out.println(status);
        // 데이터베이스에 저장 로직 구현
        // saveRequestInfo(joinPoint, result)
        System.out.println();
    }

    // 데이터베이스 저장 로직을 추가할 메서드
    private void saveRequestInfo(JoinPoint joinPoint, Object result) {
        // JPA 레포지토리를 사용하여 데이터베이스에 정보 저장
    }
}
