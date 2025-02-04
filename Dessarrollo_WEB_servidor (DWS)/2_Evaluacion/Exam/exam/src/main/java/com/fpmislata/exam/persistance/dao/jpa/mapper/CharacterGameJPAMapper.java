package com.fpmislata.exam.persistance.dao.jpa.mapper;

import com.fpmislata.exam.domain.model.CharacterGame;
import com.fpmislata.exam.persistance.dao.jpa.model.CharacterGameEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacterGameJPAMapper {
    CharacterGameJPAMapper INSTANCE = Mappers.getMapper(CharacterGameJPAMapper.class);

    CharacterGame toCharacterGame(CharacterGameEntity characterGameEntity);
}
