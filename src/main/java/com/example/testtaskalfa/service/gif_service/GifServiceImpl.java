package com.example.testtaskalfa.service.gif_service;

import com.example.testtaskalfa.client.GifClient;
import com.example.testtaskalfa.entity.giphy.Giphy;
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
    public Giphy getGifs(String tag) {
        ResponseEntity<Map> result = gifClient.getGif(this.apiKey, tag);
        Map<String, String> data = (Map<String, String>) result.getBody().get("data");
        String url = data.get("image_original_url");
        String title = data.get("title");
        return new Giphy(url, title, tag);
    }
}
