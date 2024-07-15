package moons.hellospring.objectFactory;


import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRateProvider implements ExRateProvider {

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        //환율 정보를 고정
        if (currency.equals("USD")) {
            return BigDecimal.valueOf(1000);
        }
        throw new IllegalArgumentException("지원되지 않는 통화입니다.");
    }
}