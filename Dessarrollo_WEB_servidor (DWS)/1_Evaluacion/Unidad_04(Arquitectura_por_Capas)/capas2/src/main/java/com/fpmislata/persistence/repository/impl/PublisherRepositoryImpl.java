package com.fpmislata.persistence.repository.impl;

import com.fpmislata.domain.entity.Publisher;
import com.fpmislata.domain.repository.PublisherRepository;
import com.fpmislata.persistence.dao.PublisherDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PublisherRepositoryImpl implements PublisherRepository {

    private final PublisherDao publisherDao;

    @Override
    public Optional<Publisher> findById(long id) {
        return publisherDao.findById(id);
    }
}
