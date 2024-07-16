package moons.hellospring.springContainer.singleton;

import moons.hellospring.Payment;
import moons.hellospring.springContainer.ObjectFactoryV1;
import moons.hellospring.springContainer.PaymentServiceV6;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV7_1 {
    public static void main(String[] args) throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(ObjectFactoryV1.class);
        PaymentServiceV6 paymentService = beanFactory.getBean(PaymentServiceV6.class);  //beanFactory에서 가지고 있는 Bean을 getBean을 통해 가져옴

        ObjectFactoryV1 objectFactoryV1 = beanFactory.getBean(ObjectFactoryV1.class);
        PaymentServiceV6 paymentService1 = objectFactoryV1.paymentService();
        PaymentServiceV6 paymentService2 = objectFactoryV1.paymentService();

        System.out.println(paymentService1 == paymentService2);

        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
