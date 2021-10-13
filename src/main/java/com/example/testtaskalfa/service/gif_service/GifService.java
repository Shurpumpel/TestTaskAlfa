package com.example.testtaskalfa.service.gif_service;

import com.example.testtaskalfa.entity.giphy.Giphy;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GifService {
    Giphy getGifs(String tag);
}
