package com.example.testtaskalfa.service.gif_service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GifService {
    ResponseEntity<Map> getGifs(String tag);
}
