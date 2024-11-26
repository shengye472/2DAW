package com.fpmislata.domain.admin.entity;

import com.fpmislata.common.locale.LanguageUtils;
import com.fpmislata.domain.exception.ResourceAlreadyExistsException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String isbn;
    private String titleEs;
    private String titleEn;
    private String synopsisEs;
    private String synopsisEn;
    private BigDecimal price;
    private float discount;
    private String cover;
    private Publisher publisher;
    private Category category;
    private List<Genre> genres;
    private List<Author> authors;

    public String getTitle(){
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return titleEn;
        }
        return titleEs;
    }

    public void addAuthor (Author author){
//        if (authors == null) {
//            authors = new ArrayList<>();
//        }
//        if (authors.contains(author)) {
//            throw new ResourceAlreadyExistsException("Author " + author.getName() + "already exists");
//        }
        authors.add(author);
    }

    public void addGenre(Genre genre){
//        if (genres == null) {
//            genres = new ArrayList<>();
//        }
//        if (genres.contains(genre)) {
//            throw new ResourceAlreadyExistsException("Genre " + genre.getSlug() + "already exists");
//        }
        genres.add(genre);
    }
}
