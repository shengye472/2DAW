package com.fpmislata.domain.admin.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.admin.entity.Publisher;
import com.fpmislata.domain.admin.repository.PublisherAdminRepository;
import com.fpmislata.domain.admin.servise.PublisherAdminService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class PublisherAdminServiceImpl implements PublisherAdminService {

    private final PublisherAdminRepository publisherAdminRepository;


    @Override
    public Optional<Publisher> findById(long id) {
        return publisherAdminRepository.findById(id);
    }
}
