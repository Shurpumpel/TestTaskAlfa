package com.example.testtaskalfa.controller;

import com.example.testtaskalfa.dto.OutDTO;
import com.example.testtaskalfa.entity.giphy.Giphy;
import com.example.testtaskalfa.entity.open_exchange_rates.OpenExchangeRates;
import com.example.testtaskalfa.service.exchange_rates_service.ExchangeRatesService;
import com.example.testtaskalfa.service.gif_service.GifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;


@RestController
public class MainController {

    @Autowired
    private GifService gifService;
    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @GetMapping("/gif/{currency}")
    public OutDTO getGif(@PathVariable String currency) {
        Giphy gif = null;
        if (isTodayCoefficientBetter(currency))
            gif = gifService.getGifs("rich");
        else
            gif = gifService.getGifs("broke");
        return OutDTO.fromModel(gif, exchangeRatesService.getCoefficient(currency));
    }

    private boolean isTodayCoefficientBetter(String currency) {
        OpenExchangeRates yesterday = getYesterdayExchangeRates();
        OpenExchangeRates today = getLatestExchangeRates();
        return today.getRates().get(currency) > yesterday.getRates().get(currency);
    }

    @GetMapping("/rates")
    public OpenExchangeRates getLatestExchangeRates() {
        return exchangeRatesService.getLatestExchangeRates();
    }

    @GetMapping("/currencies")
    public ResponseEntity<Map> getCurrencies() {
        return exchangeRatesService.getCurrencies();
    }

    @GetMapping("/yesterday")
    public OpenExchangeRates getYesterdayExchangeRates() {
        Calendar calendar = Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return exchangeRatesService.getHistoricalExchangeRates(dateFormat.format(calendar.getTime()));
    }
}
