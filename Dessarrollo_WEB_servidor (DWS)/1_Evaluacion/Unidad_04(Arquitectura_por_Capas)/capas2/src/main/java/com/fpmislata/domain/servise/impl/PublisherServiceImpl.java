package com.fpmislata.domain.admin.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.entity.Publisher;
import com.fpmislata.domain.repository.PublisherRepository;
import com.fpmislata.domain.admin.servise.PublisherAdminService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class PublisherAdminServiceImpl implements PublisherAdminService {

    private final PublisherRepository publisherAdminRepository;


    @Override
    public Optional<Publisher> findById(long id) {
        return publisherAdminRepository.findById(id);
    }
}
