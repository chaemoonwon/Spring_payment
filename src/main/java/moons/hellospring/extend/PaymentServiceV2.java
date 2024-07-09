package moons.hellospring.extend;

import com.fasterxml.jackson.databind.ObjectMapper;
import moons.hellospring.Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

//추상화를 통한 부모로써의 기능을 수행함
//장점 : 추상화를 통해서 getExRate 기능을 오버라이드 함으로써 재사용 할 수 있음
//단점 : getExRate 기능 외에 추가적으로 다른 기능이 추가될 때마다 서비스 기능이 복잡해짐.
abstract public class PaymentServiceV2 {
    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = getExRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

    //추상화
    abstract BigDecimal getExRate(String currency) throws IOException;

}
