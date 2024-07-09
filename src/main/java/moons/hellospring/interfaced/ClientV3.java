package moons.hellospring.interfaced;

import moons.hellospring.Payment;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV3 {
    public static void main(String[] args) throws IOException {
        PaymentServiceV4 paymentService = new PaymentServiceV4();
        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
