package com.fpmislata.exam.persistance.dao.jpa.mapper;

import com.fpmislata.exam.domain.model.Game;
import com.fpmislata.exam.persistance.dao.jpa.model.GameEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CharacterGameJPAMapper.class, DirectorJPAMapper.class})
public interface GameJPAMapper {

    GameJPAMapper INSTANCE = Mappers.getMapper(GameJPAMapper.class);

    @Mapping(target = "characterGames", ignore = true)
    @Mapping(target = "director", ignore = true)
    Game toGame(GameEntity gameEntity);

    Game toGameDetail(GameEntity gameEntity);
}
