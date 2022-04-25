//package kg.itschool.flightreservation.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Aspect
//@Component
//public class LoggingAdvice {
//
//    @Pointcut("within(kg.itschool.flightreservation.service.* ..*)")
//    private void createPointCut(){}
//
//    @Around("createPointCut()")
//    public Object createLogging(ProceedingJoinPoint pjp) {
//        log.info("-------------------------------------------------------------------------------");
//        log.info("Creating some object");
//        log.info("-------------------------------------------------------------------------------");
//        return pjp;
//    }
//
//}
