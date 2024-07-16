package moons.hellospring.springContainer.Decorator;

import moons.hellospring.springContainer.ExRateProvider;
import moons.hellospring.springContainer.PaymentServiceV6;
import moons.hellospring.springContainer.SimpleExRateProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Bean 클래스가 서로 어떤 관계를 맺는지 알려주는 구성 정보 어노테이션
public class ObjectFactoryV4 {

    @Bean
    public PaymentServiceV8 paymentService() {
//        return new PaymentServiceV6(new WebApiExRateProvider());
        return new PaymentServiceV8(cachedExRateProvider());
    }

    //WebApiExRateProvider를 통해서 CachedExRateProvider를 가져옴.
    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
