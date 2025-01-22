package com.fpmislata.persistence.dao.impl.jpa.mapper;

import com.fpmislata.domain.entity.Publisher;
import com.fpmislata.persistence.dao.impl.jpa.entity.PublisherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherJpaMapper {

    PublisherJpaMapper INSTANCE = Mappers.getMapper(PublisherJpaMapper.class);

    Publisher toPublisher(PublisherEntity publisherEntity);
}
