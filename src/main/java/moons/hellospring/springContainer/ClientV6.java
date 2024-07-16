package moons.hellospring.springContainer;

import moons.hellospring.Payment;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV6 {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactoryV2.class);
        PaymentServiceV6 paymentService = beanFactory.getBean(PaymentServiceV6.class);  //beanFactory에서 가지고 있는 Bean을 getBean을 통해 가져옴

        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
