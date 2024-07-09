package moons.hellospring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class PaymentServiceV1 {
    public Payment prepare(Long orderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        ExchangeRate data = getExRate(currency);

        BigDecimal exRate = data.rates().get("KRW");
        System.out.println(exRate);
        // https://open.er-api.com/v6/latest/USD

        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(orderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

    //메서드 추출
    private ExchangeRate getExRate(String currency) throws IOException {
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        System.out.println(response);

        ObjectMapper mapper = new ObjectMapper();
        ExchangeRate data = mapper.readValue(response, ExchangeRate.class);
        System.out.println(data);
        return data;
    }

    public static void main(String[] args) throws IOException {
        PaymentServiceV1 paymentService = new PaymentServiceV1();
        Payment payment = paymentService.prepare(100L,"USD",BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }

}
