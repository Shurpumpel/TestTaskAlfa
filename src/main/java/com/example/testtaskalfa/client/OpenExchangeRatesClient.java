package com.example.testtaskalfa.client;

import com.example.testtaskalfa.entity.open_exchange_rates.OpenExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(url = "${open.exchange.rates.url}", name = "openExchangeRatesClient")
public interface OpenExchangeRatesClient {

    @GetMapping("/latest.json")
    OpenExchangeRates getLatestExchangeRate(
            @RequestParam("app_id") String appId,
            @RequestParam("base") String base
    );

    @GetMapping("/historical/{date}.json")
    OpenExchangeRates getHistoricalExchangeRate(
            @PathVariable String date,
            @RequestParam("app_id") String appId,
            @RequestParam("base") String base
    );

    @GetMapping("/currencies.json")
    OpenExchangeRates getCurrencies();
}
