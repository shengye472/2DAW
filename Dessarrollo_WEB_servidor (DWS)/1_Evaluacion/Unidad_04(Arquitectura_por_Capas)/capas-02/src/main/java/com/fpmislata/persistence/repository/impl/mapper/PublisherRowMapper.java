package com.fpmislata.persistence.repository.impl.mapper;

import com.fpmislata.domain.entity.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherRowMapper implements CustomRowMapper<Publisher> {

    @Override
    public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setId(rs.getInt("publishers.id"));
        publisher.setName(rs.getString("publishers.name"));
        publisher.setSlug(rs.getString("publishers.slug"));
        return publisher;
    }
}
