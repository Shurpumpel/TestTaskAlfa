package com.example.testtaskalfa.entity.giphy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Giphy {
    private String urlGif;
    private String title;
    private String searchTag;
}
