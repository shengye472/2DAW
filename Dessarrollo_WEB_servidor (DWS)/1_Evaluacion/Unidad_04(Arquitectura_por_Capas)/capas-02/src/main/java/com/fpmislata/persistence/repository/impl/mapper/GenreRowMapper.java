package com.fpmislata.persistence.repository.impl.mapper;

import com.fpmislata.common.locale.LanguageUtils;
import com.fpmislata.domain.entity.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        String language = LanguageUtils.getCurrentLanguage();
        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setName(rs.getString("name_" + language));
        genre.setSlug(rs.getString("slug"));
        return genre;
    }
}
