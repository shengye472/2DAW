package com.fpmislata.persistence.dao.impl.jdbc.mapper;

import com.fpmislata.domain.entity.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setName(rs.getString("name"));
        author.setNationality(rs.getString("nationality"));
        author.setBiographyEs(rs.getString("biography_es"));
        author.setBiographyEn(rs.getString("biography_en"));
        author.setBirthYear(rs.getInt("birth_year"));
        author.setDeathYear(rs.getInt("death_year"));
        return author;
    }
}
