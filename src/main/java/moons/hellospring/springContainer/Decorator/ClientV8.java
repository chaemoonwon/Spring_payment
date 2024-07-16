package moons.hellospring.springContainer.Decorator;

import moons.hellospring.Payment;
import moons.hellospring.springContainer.ObjectFactoryV2;
import moons.hellospring.springContainer.PaymentServiceV6;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class ClientV8 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactoryV5.class);
        PaymentServiceV8 paymentService = beanFactory.getBean(PaymentServiceV8.class);  //beanFactory에서 가지고 있는 Bean을 getBean을 통해 가져옴

        Payment payment1 = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println("payment1: " +payment1);

        System.out.println("------------------------------------");

        TimeUnit.SECONDS.sleep(1);


        //CachedExRateProvider에 저장되어 있는 캐시 정보(환율 정보)를 가져옴.
        Payment payment2 = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println("payment2: " +payment2);

        System.out.println("------------------------------------");

        TimeUnit.SECONDS.sleep(2);

        Payment payment3 = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println("payment3: " +payment3);


    }
}
