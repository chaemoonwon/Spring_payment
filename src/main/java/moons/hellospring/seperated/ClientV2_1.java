package moons.hellospring.seperated;

import moons.hellospring.Payment;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV2_1 {
    public static void main(String[] args) throws IOException {
        PaymentServiceV3_1 paymentService = new PaymentServiceV3_1();
        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
