package moons.hellospring.springContainer.singleton;

import moons.hellospring.springContainer.ExRateProvider;
import moons.hellospring.springContainer.SimpleExRateProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Bean 클래스가 서로 어떤 관계를 맺는지 알려주는 구성 정보 어노테이션
public class ObjectFactoryV3 {

    @Bean
    public PaymentServiceV7 paymentService() {
//        return new PaymentServiceV6(new WebApiExRateProvider());
//        return new PaymentServiceV6(exRateProvider());
        return new PaymentServiceV7(exRateProvider());
    }

    @Bean
    public OrderService orderService() {
//        return new PaymentServiceV6(new WebApiExRateProvider());
        return new OrderService(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new SimpleExRateProvider();
    }
}

class OrderService {
    ExRateProvider exRateProvider;

    public OrderService(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }
}
