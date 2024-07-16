package moons.hellospring.springContainer.singleton;

import moons.hellospring.Payment;
import moons.hellospring.springContainer.ObjectFactoryV1;
import moons.hellospring.springContainer.PaymentServiceV6;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV7_2 {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactoryV3.class);
        PaymentServiceV7 paymentService = beanFactory.getBean(PaymentServiceV7.class);
        OrderService orderService = beanFactory.getBean(OrderService.class);

        //true
        System.out.println(paymentService.exRateProvider == orderService.exRateProvider);

        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
