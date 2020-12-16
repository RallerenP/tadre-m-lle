package com.mchg.tadremoelle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditPageDTO {
    private String title;
    private String content;
    private String url;

    private String author;

    private String[] tags;
    private String image;

    private int id;
}
