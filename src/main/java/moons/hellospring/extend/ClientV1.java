package moons.hellospring.extend;

import moons.hellospring.Payment;
import moons.hellospring.extend.PaymentServiceV2;
import moons.hellospring.extend.SimpleExRatePaymentService;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV1 {
    public static void main(String[] args) throws IOException {
        PaymentServiceV2 paymentService = new SimpleExRatePaymentService();
        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
