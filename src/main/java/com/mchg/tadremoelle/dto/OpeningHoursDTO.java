package com.mchg.tadremoelle.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OpeningHoursDTO {

    private Date start;
    private Date end;
    private String text;
    private String time;

}
