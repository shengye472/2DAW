package com.fpmislata.domain.admin.servise;

import com.fpmislata.domain.admin.entity.Publisher;

import java.util.Optional;

public interface PublisherAdminService {
    Optional<Publisher> findById(long id);
}
