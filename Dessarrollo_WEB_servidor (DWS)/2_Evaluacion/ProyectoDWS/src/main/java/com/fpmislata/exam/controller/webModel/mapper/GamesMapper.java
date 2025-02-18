package com.fpmislata.exam.controller.webModel.mapper;

import com.fpmislata.exam.controller.webModel.GameCollection;
import com.fpmislata.exam.domain.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GamesMapper {
    GamesMapper INSTANCE = Mappers.getMapper(GamesMapper.class);

    GameCollection toGameCollection(Game game);
}
