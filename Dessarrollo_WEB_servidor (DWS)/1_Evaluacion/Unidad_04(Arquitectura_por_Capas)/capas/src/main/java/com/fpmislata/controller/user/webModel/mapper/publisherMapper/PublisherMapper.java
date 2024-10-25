package com.fpmislata.controller.user.webModel.mapper.publisherMapper;

import com.fpmislata.controller.user.webModel.entity.publisher.PublisherCollection;
import com.fpmislata.domain.user.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);
    PublisherCollection toPublisherCollection(Publisher publisher);
}
