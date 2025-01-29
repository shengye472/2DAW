package com.fpmislata.domain.entity;

import com.fpmislata.common.exception.ValidationException;
import com.fpmislata.common.locale.LanguageUtils;
import com.fpmislata.common.validation.annotation.ValidYear;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
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
    private String biographyEn;
    @Nullable
    @Min(value = 1880, message = "El año debe ser posterior a 1880")
    private Integer birthYear;
    @ValidYear
    private Integer deathYear;

    public String getBiography() {
        String language = LanguageUtils.getCurrentLanguage();
        if ("en".equals(language)) {
            return biographyEn;
        }
        return biographyEs;
    }

    public void setBirthYear(Integer birthYear) {
        if(birthYear != null && this.deathYear != null && birthYear > this.deathYear) {
            throw new ValidationException("El año de nacimiento no puede ser mayor que el año de muerte.");
        }
        this.birthYear = birthYear;
    }

    public void setDeathYear(Integer deathYear) {
        if (this.birthYear != null && deathYear != null && this.birthYear > deathYear) {
            throw new ValidationException("El año de muerte no puede ser menor que el año de nacimiento.");
        }
        this.deathYear = deathYear;
    }
}
