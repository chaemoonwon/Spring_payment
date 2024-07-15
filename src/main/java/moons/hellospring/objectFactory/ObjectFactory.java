package moons.hellospring.objectFactory;


public class ObjectFactory {

    public PaymentServiceV6 paymentService() {
//        return new PaymentServiceV6(new WebApiExRateProvider());
        return new PaymentServiceV6(exRateProvider());
    }

    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
