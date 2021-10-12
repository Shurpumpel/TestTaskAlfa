package com.example.testtaskalfa.service.gif_service;

import com.example.testtaskalfa.client.GifClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GifServiceImpl implements GifService {

    @Autowired
    private GifClient gifClient;
    @Value("${giphy.api.key}")
    private String apiKey;


    @Override
    public ResponseEntity<Map> getGifs(String tag) {
        ResponseEntity<Map> result = gifClient.getGif(this.apiKey, tag);
        result.getBody().put("typegif", tag);
        return result;
    }
}
