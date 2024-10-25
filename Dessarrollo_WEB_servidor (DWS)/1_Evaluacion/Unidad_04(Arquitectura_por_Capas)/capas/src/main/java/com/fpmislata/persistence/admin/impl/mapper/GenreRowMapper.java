package com.fpmislata.persistence.admin.impl.mapper;

import com.fpmislata.domain.admin.entity.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getLong("id"));
        genre.setNameEs(rs.getString("name_es"));
        genre.setNameEn(rs.getString("name_en"));
        genre.setSlug(rs.getString("slug"));
        return genre;
    }
}
