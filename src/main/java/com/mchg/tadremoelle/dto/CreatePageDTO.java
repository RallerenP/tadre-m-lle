package com.mchg.tadremoelle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePageDTO {
    private String title;
    private String content;
    private String url;
}
