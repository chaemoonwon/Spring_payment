package moons.hellospring.springContainer.Decorator;

import moons.hellospring.springContainer.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class CachedExRateProvider implements ExRateProvider {

    private final ExRateProvider target;

    //캐시 정보를 보관 (환율 정보)
    private BigDecimal cachedExRate;

    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

//    @Override
//    public BigDecimal getExRate(String currency) throws IOException {
//        return target.getExRate(currency);
//    }

    @Override
    public BigDecimal getExRate(String currency) throws IOException {
        if (cachedExRate == null) {
            cachedExRate = this.target.getExRate(currency);

            System.out.println("Cache Update");
        }
        return cachedExRate;
    }
}
