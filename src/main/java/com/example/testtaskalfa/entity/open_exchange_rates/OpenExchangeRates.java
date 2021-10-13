package com.example.testtaskalfa.entity.open_exchange_rates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpenExchangeRates {

    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Map<String, Double> rates;

}
