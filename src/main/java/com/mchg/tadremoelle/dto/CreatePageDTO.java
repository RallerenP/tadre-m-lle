package com.mchg.tadremoelle.dto;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.List;

@Getter
@Setter
public class CreatePageDTO {
    private String title;
    private String content;
    private String url;
    private String[] tags;
    private String image;

}
