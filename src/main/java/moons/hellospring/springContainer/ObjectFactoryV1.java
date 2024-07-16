package moons.hellospring.springContainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Bean 클래스가 서로 어떤 관계를 맺는지 알려주는 구성 정보 어노테이션
public class ObjectFactoryV1 {

    @Bean
    public PaymentServiceV6 paymentService() {
//        return new PaymentServiceV6(new WebApiExRateProvider());
        return new PaymentServiceV6(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new SimpleExRateProvider();
    }
}
