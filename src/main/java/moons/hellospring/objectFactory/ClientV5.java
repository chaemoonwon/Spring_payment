package moons.hellospring.objectFactory;

import moons.hellospring.Payment;
import moons.hellospring.seperatedV2.PaymentServiceV5;
import moons.hellospring.seperatedV2.WebApiExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class ClientV5 {
    public static void main(String[] args) throws IOException {
        ObjectFactory objectFactory = new ObjectFactory();
        PaymentServiceV6 paymentService = objectFactory.paymentService();

        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
