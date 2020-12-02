package com.mchg.tadremoelle.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition="LONGTEXT")
    private String content;

    private String url;

    @ManyToMany
    private List<Tag> tags;

    private String image;
}
