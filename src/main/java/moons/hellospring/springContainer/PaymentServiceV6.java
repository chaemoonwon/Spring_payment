package moons.hellospring.springContainer;



import moons.hellospring.Payment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component  //BeanFactory가 해당 정보를 참고함
public class PaymentServiceV6 {
    ExRateProvider exRateProvider;

    public PaymentServiceV6(ExRateProvider exRateProvider) {
        this.exRateProvider = exRateProvider;
    }

    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = exRateProvider.getExRate(currency);         //적용 환율
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);        //원화 환산 금액
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30); //원화 환산 금액 유효시간

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

}
