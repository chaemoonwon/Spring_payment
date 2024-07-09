package moons.hellospring.interfaced;

import com.fasterxml.jackson.databind.ObjectMapper;
import moons.hellospring.ExchangeRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class WebApiExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        System.out.println(response);

        ObjectMapper mapper = new ObjectMapper();
        ExchangeRate data = mapper.readValue(response, ExchangeRate.class);
        return data.rates().get("KRW");
    }
}
