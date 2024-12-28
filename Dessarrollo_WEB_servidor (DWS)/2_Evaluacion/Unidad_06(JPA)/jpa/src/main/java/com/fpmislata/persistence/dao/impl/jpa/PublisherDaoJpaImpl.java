package com.fpmislata.persistence.dao.impl.jpa;

import com.fpmislata.domain.entity.Publisher;
import com.fpmislata.persistence.dao.PublisherDao;
import com.fpmislata.persistence.dao.impl.jpa.mapper.PublisherJpaMapper;
import com.fpmislata.persistence.dao.impl.jpa.repository.PublisherJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Primary
@Component
@RequiredArgsConstructor
public class PublisherDaoJpaImpl implements PublisherDao {

    private final PublisherJpaRepository publisherJpaRepository;

    @Override
    public Optional<Publisher> findById(long id) {
        return publisherJpaRepository
                .findById(id)
                .map(PublisherJpaMapper.INSTANCE::toPublisher);
    }
}
