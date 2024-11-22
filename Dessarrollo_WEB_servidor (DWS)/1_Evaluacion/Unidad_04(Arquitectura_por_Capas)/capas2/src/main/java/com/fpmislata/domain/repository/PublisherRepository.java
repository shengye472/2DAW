package com.fpmislata.domain.admin.repository;

import com.fpmislata.domain.entity.Publisher;

import java.util.Optional;

public interface PublisherAdminRepository {
    Optional<Publisher> findById(long id);

}
