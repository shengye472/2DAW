package com.fpmislata.domain.entity;

import com.fpmislata.common.locale.LanguageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private long id;
    private String name;
    private String nationality;
    private String biographyEs;
    private String BiographyEn;
    private int birthYear;
    private int deathYear;

    public String getBiography() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return BiographyEn;
        }
        return biographyEs;
    }
}
