package com.example.testtaskalfa.dto;

import com.example.testtaskalfa.entity.giphy.Giphy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutDTO {

    private String urlGif;
    private String title;
    private String searchTag;
    private String coefficient;

    public static OutDTO fromModel(Giphy gif, String coefficient){
        OutDTO outDTO = new OutDTO();
        outDTO.setUrlGif(gif.getUrlGif());
        outDTO.setTitle(gif.getTitle());
        outDTO.setSearchTag(gif.getSearchTag());
        outDTO.setCoefficient(coefficient);
        return outDTO;
    }
}
