package moons.hellospring.extend;

import com.fasterxml.jackson.databind.ObjectMapper;
import moons.hellospring.ExchangeRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

//상속을 통한 구현
public class WebApiExRatePaymentService extends PaymentServiceV2 {

    @Override
    BigDecimal getExRate(String currency) throws IOException {
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        System.out.println(response);

        ObjectMapper mapper = new ObjectMapper();
        ExchangeRate data = mapper.readValue(response, ExchangeRate.class);
        BigDecimal exRate = data.rates().get("KRW");
        System.out.println(exRate);
        return exRate;
    }
}
