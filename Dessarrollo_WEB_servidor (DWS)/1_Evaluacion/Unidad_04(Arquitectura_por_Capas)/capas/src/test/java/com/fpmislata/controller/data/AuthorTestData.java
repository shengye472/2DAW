package com.fpmislata.controller.data;

import com.fpmislata.domain.user.entity.Author;

import java.util.List;

public class AuthorTestData {

    public static List<Author> getAuthors(){
        return List.of(
                new Author(1, "Author 1", "spain", "biography author 1", 1900, 1970),
                new Author(2, "Author 2", "france", "biography author 2", 1910, 1980),
                new Author(3, "Author 3", "usa", "biography author 3", 1920, 1990)
        );
    }
}
