package com.mchg.tadremoelle.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adult;

    private String groupx;

    private String teen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(adult, price.adult) &&
                Objects.equals(groupx, price.groupx) &&
                Objects.equals(teen, price.teen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adult, groupx, teen);
    }
}

