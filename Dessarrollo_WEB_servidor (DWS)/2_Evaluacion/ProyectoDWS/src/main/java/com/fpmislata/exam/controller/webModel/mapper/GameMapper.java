package com.fpmislata.exam.controller.webModel.mapper;

import com.fpmislata.exam.controller.webModel.GameCollection;
import com.fpmislata.exam.domain.model.Game;
import org.springframework.beans.factory.annotation.Value;

public class GameMapper {
    @Value("${app.base.url}")
    private String baseUrl;
    public static final GameMapper INSTANCE = new GameMapper();
    public GameCollection toGameCollection(Game game){
        GameCollection gameCollection = new GameCollection();
        gameCollection.setGameCode(game.getGameCode());
        gameCollection.setTitle(game.getTitle());
        return gameCollection;
    }
}
