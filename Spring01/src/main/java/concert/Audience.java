package concert;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by wushuai3 on 2017/2/14.
 */
@Aspect
public class Audience {
    @Pointcut("execution(** concert.Performance.perform(..))")
    public void performance(){}
//    @Before("performance")
//    public void silenceCellPhones(){
//        System.out.println("Silence cell phones");
//    }
//    @Before("performance")
//    public void takeSeats(){
//        System.out.println("Taking seats");
//    }
//    @AfterReturning("performance")
//    public void applease(){
//        System.out.println("Clap Clap Clap!!!");
//    }
//    @AfterThrowing("performance")
//    public void demandRefund(){
//        System.out.println("Demand a refund");
//    }
    @Around("performance")
    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("Silence cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("Clap Clap Clap!!!");
        } catch (Throwable throwable) {
            System.out.println("Demand a refund");
        }


    }
}
