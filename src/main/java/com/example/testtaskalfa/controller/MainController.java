package com.example.testtaskalfa.controller;

import com.example.testtaskalfa.entity.open_exchange_rates.OpenExchangeRates;
import com.example.testtaskalfa.service.exchange_rates_service.ExchangeRatesService;
import com.example.testtaskalfa.service.gif_service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class MainController {

    @Autowired
    private GifService gifService;
    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @GetMapping("/gif")
    public ResponseEntity<Map> getGif() {
        ResponseEntity<Map> response = gifService.getGifs("broke");
        response.getBody().put("coefficient", exchangeRatesService.getCoefficient("RUB"));
        return response;
    }

    @GetMapping("/rates")
    public OpenExchangeRates getLatestExchangeRates() {
        return exchangeRatesService.getLatestExchangeRates();
    }

    @GetMapping("/currencies")
    public OpenExchangeRates getCurrencies(){
        return exchangeRatesService.getCurrencies();
    }
}
