package com.example.testtaskalfa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(url = "${giphy.url}", name = "giphyClient")
public interface GifClient {

    @GetMapping("/random")
    public ResponseEntity<Map> getGif(
            @RequestParam ("api_key") String apiKey,
            @RequestParam ("tag") String tag
    );

}
