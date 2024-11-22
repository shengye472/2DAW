package com.fpmislata.domain.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    private long id;
    private String nameEs;
    private String nameEn;
    private String slug;
}
