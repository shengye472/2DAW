package com.fpmislata.exam.persistance.dao.jpa.mapper;

import com.fpmislata.exam.domain.model.Director;
import com.fpmislata.exam.persistance.dao.jpa.model.DirectorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectorJPAMapper {
    DirectorJPAMapper INSTANCE = Mappers.getMapper(DirectorJPAMapper.class);

    Director toDirector(DirectorEntity directorEntity);
}
