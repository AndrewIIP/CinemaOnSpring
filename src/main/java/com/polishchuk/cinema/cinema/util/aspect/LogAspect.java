package com.polishchuk.cinema.cinema.util.aspect;

import com.polishchuk.cinema.cinema.data.dto.UserDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.polishchuk.cinema.cinema.service.UserService.addSimpleUserToRepo(" +
            "com.polishchuk.cinema.cinema.data.dto.UserDto))")
    public void callAtUserServiceAddSimpleUser() {}

    @Pointcut("execution(* com.polishchuk.cinema.cinema.service.UserService.getAllUsers()))")
    public void callAtUserServiceGetAllUsers() {}

    @After("callAtUserServiceGetAllUsers() || callAtUserServiceAddSimpleUser()")
    public void afterCallAtAddUserToDto(JoinPoint joinPoint){
        System.out.println("Aspect afterCall method LOGGING!!! Args => " +
                Arrays.stream(joinPoint.getArgs()).reduce("", (left, right) -> left + " " + right));
    }
}
