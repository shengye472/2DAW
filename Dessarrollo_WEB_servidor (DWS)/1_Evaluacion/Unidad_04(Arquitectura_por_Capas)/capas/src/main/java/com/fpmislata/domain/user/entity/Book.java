package com.fpmislata.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private String synopsis;
    private BigDecimal price;
    private float discount;
    private String cover;
    private Publisher publisher;
    private Category category;
    private List<Author> authors;
    private List<Genre> genres;


    public void setPrice(BigDecimal price) {
        if (price == null) {
            price = new BigDecimal(0);
        }
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }
}
