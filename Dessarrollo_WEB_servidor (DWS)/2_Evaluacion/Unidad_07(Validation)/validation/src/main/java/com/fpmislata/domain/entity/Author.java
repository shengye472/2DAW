package com.fpmislata.domain.entity;

import com.fpmislata.common.locale.LanguageUtils;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @NotNull
    private long id;
    @NotNull
    private String name;
    private String nationality;
    private String biographyEs;
    private String biographyEn;

    private int birthYear;
    private int deathYear;

    public String getBiography() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return biographyEn;
        }
        return biographyEs;
    }
}
