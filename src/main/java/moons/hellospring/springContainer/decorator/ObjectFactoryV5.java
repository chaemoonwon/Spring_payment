package moons.hellospring.springContainer.decorator;

import moons.hellospring.springContainer.ExRateProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Bean 클래스가 서로 어떤 관계를 맺는지 알려주는 구성 정보 어노테이션
public class ObjectFactoryV5 {

    @Bean
    public PaymentServiceV8 paymentService() {
//        return new PaymentServiceV6(new WebApiExRateProvider());
        return new PaymentServiceV8(cachedExRateProviderV2());
    }

    //WebApiExRateProvider를 통해서 CachedExRateProvider를 가져옴.
    @Bean
    public ExRateProvider cachedExRateProviderV2() {
        return new CachedExRateProviderV2(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
