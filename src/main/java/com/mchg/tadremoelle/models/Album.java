package com.mchg.tadremoelle.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String albumName;

    @OneToMany
    private List<Image> image;

    public boolean addToList(Image image) {
        this.image.add(image);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return albumName.equals(album.albumName) &&
                image.equals(album.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumName, image);
    }
}
