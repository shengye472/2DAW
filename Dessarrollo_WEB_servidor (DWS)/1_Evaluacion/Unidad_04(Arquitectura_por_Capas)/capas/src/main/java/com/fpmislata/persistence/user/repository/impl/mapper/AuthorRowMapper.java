package com.fpmislata.persistence.user.repository.impl.mapper;

import com.fpmislata.common.locale.LanguageUtils;
import com.fpmislata.domain.user.entity.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setName(rs.getString("name"));
        author.setNationality(rs.getString("nationality"));
        author.setBiography(rs.getString("biography_" + language));
        author.setBirthYear(rs.getInt("birth_year"));
        author.setDeathYear(rs.getInt("death_year"));
        return author;
    }
}
