package com.example.testtaskalfa.service.exchange_rates_service;

import com.example.testtaskalfa.client.OpenExchangeRatesClient;
import com.example.testtaskalfa.entity.open_exchange_rates.OpenExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

    @Autowired
    private OpenExchangeRatesClient openExchangeRatesClient;
    @Value("${open.exchange.rates.app.id}")
    private String appId;
    @Value("${open.exchange.rates.base}")
    private String base;


    @Override
    public OpenExchangeRates getLatestExchangeRates() {
        return openExchangeRatesClient.getLatestExchangeRate(this.appId, this.base);
    }

    @Override
    public OpenExchangeRates getHistoricalExchangeRates(String date) {
        return openExchangeRatesClient.getHistoricalExchangeRate(date, this.appId, this.base);
    }

    @Override
    public ResponseEntity<Map> getCurrencies() {
        return openExchangeRatesClient.getCurrencies();
    }

    public Double getCoefficient(String charCode) {
        OpenExchangeRates openExchangeRates = getLatestExchangeRates();
        return openExchangeRates.getRates().get(charCode);
    }
}
