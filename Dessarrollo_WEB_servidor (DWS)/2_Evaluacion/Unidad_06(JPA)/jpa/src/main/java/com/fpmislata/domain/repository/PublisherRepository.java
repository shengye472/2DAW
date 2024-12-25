package com.fpmislata.domain.repository;

import com.fpmislata.domain.entity.Publisher;

import java.util.Optional;

public interface PublisherRepository {
    Optional<Publisher> findById(long id);

}
