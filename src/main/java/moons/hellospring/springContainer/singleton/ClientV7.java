package moons.hellospring.springContainer.singleton;

import moons.hellospring.Payment;
import moons.hellospring.springContainer.ObjectFactoryV1;
import moons.hellospring.springContainer.ObjectFactoryV2;
import moons.hellospring.springContainer.PaymentServiceV6;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV7 {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactoryV1.class);
        PaymentServiceV6 paymentService = beanFactory.getBean(PaymentServiceV6.class);  //beanFactory에서 가지고 있는 Bean을 getBean을 통해 가져옴
        PaymentServiceV6 paymentService2 = beanFactory.getBean(PaymentServiceV6.class);

        //paymentService와 paymentService2가 같은 Object인지 확인
        System.out.println(paymentService);
        System.out.println(paymentService2);
        System.out.println(paymentService2 == paymentService);

        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
