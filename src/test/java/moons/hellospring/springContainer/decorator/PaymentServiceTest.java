package moons.hellospring.springContainer.decorator;

import moons.hellospring.Payment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    @DisplayName("prepare 메소드가 요구사항 3가지를 잘 충족했는지 검증")
    void prepare() throws IOException {
        // 준비
        PaymentServiceV8 paymentService = new PaymentServiceV8(new WebApiExRateProvider());

        // 실행
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);


        // 검증
        //1. 환율 정보
        assertThat(payment.getExRate()).isNotNull();

        //2. 원화 환산 금액 게산
        assertThat(payment.getConvertedAmount())
                .isEqualTo(payment.getExRate()
                        .multiply(payment.getForeignCurrencyAmount()));

        //3. 원환 환산 금액 유효 시간
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
        assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));

    }
}