package moons.hellospring.springContainer.DIP.exRate;

import moons.hellospring.springContainer.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CachedExRateProviderV2 implements ExRateProvider {

    private final ExRateProvider target;
    private LocalDateTime cacheExpiryTime;

    //캐시 정보를 보관 (환율 정보)
    private BigDecimal cachedExRate;

    public CachedExRateProviderV2(ExRateProvider target) {
        this.target = target;
    }

//    @Override
//    public BigDecimal getExRate(String currency) throws IOException {
//        return target.getExRate(currency);
//    }

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        if (cachedExRate == null || cacheExpiryTime.isBefore(LocalDateTime.now())) {
            cachedExRate = this.target.getExRate(currency);
            cacheExpiryTime = LocalDateTime.now().plusSeconds(3);

            System.out.println("Cache Update");
        }
        return cachedExRate;
    }
}
