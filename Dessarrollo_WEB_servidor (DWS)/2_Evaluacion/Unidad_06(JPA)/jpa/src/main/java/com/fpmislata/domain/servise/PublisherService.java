package com.fpmislata.domain.servise;

import com.fpmislata.domain.entity.Publisher;

import java.util.Optional;

public interface PublisherService {
    Optional<Publisher> findById(long id);
}
