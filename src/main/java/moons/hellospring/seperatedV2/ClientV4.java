package moons.hellospring.seperatedV2;

import moons.hellospring.Payment;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV4 {
    public static void main(String[] args) throws IOException {
//        PaymentServiceV5 paymentService = new PaymentServiceV5(new SimpleExRateProvider());
        PaymentServiceV5 paymentService = new PaymentServiceV5(new WebApiExRateProvider());
        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
