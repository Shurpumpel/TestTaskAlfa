package com.example.testtaskalfa.controller;

import com.example.testtaskalfa.dto.OutDTO;
import com.example.testtaskalfa.entity.giphy.Giphy;
import com.example.testtaskalfa.entity.open_exchange_rates.OpenExchangeRates;
import com.example.testtaskalfa.service.exchange_rates_service.ExchangeRatesService;
import com.example.testtaskalfa.service.gif_service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class MainController {

    @Autowired
    private GifService gifService;
    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @GetMapping("/gif/{currency}")
    public OutDTO getGif(@PathVariable String currency) {
        Giphy gif = gifService.getGifs("rich");
        return OutDTO.fromModel(gif, exchangeRatesService.getCoefficient(currency));
    }

    @GetMapping("/rates")
    public OpenExchangeRates getLatestExchangeRates() {
        return exchangeRatesService.getLatestExchangeRates();
    }

    @GetMapping("/currencies")
    public ResponseEntity<Map> getCurrencies(){
        return exchangeRatesService.getCurrencies();
    }
}
