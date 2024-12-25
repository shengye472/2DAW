package com.fpmislata.persistence.dao;

import com.fpmislata.domain.entity.Publisher;

import java.util.Optional;

public interface PublisherDao {
    Optional<Publisher> findById(long id);
}
