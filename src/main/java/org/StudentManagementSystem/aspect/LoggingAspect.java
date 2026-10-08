package org.StudentManagementSystem.aspect;

import org.StudentManagementSystem.dto.CreateStudentResponseDTO;
import org.StudentManagementSystem.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger
            = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("execution(* org.StudentManagementSystem.service.StudentServiceImpl.createStudent(..))")
//    public void logBeforeMethod(JoinPoint joinPoint) {
//        //to read the argument of createStudent
//        //it will print our CreateStudentRequestDTO
//        Object arr[] = joinPoint.getArgs();
//        Arrays.stream(arr).forEach(System.out::println);
//        logger.info("Student is going to save");
//    }
//
//    //if there is any exception occur in createStudent this will not get executed
//    @AfterReturning("execution(* org.StudentManagementSystem.service.StudentServiceImpl.createStudent(..))")
//    public void logAfterReturningMethod() {
//        //here we can modify our upcoming details also
//        logger.info("After returning method get called");
//    }
//
//    //it works as finally it will execute always even though exception occur
//    //lock release,cache clear
//    @After("execution(* org.StudentManagementSystem.service.StudentServiceImpl.createStudent(..))")
//    public void logAfterMethod() {
//        logger.info("createStudent method get called successfully ");
//    }

    @Around("execution(* org.StudentManagementSystem.service.StudentServiceImpl.createStudent(..))")
    public CreateStudentResponseDTO logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("New student details are going to added in db");
        long start = System.currentTimeMillis();
        CreateStudentResponseDTO student = (CreateStudentResponseDTO) proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;
        logger.info("New student details save into db and it took {}s",duration);
        return student;
    }


}
