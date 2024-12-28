package com.fpmislata.persistence.dao.impl.jpa.repository;

import com.fpmislata.persistence.dao.impl.jpa.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherJpaRepository extends JpaRepository<PublisherEntity, Long> {
}
