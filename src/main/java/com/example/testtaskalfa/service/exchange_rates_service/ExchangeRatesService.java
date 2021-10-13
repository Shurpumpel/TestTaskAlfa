package com.example.testtaskalfa.service.exchange_rates_service;

import com.example.testtaskalfa.entity.open_exchange_rates.OpenExchangeRates;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ExchangeRatesService {

    OpenExchangeRates getLatestExchangeRates();

    OpenExchangeRates getHistoricalExchangeRates(String date);

    ResponseEntity<Map> getCurrencies();

    Double getCoefficient(String charCode);
}
