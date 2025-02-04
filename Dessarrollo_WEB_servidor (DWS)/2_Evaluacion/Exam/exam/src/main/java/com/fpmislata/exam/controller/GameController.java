package com.fpmislata.exam.controller;

import com.fpmislata.exam.controller.webModel.GameCollection;
import com.fpmislata.exam.controller.webModel.mapper.GameMapper;
import com.fpmislata.exam.domain.model.Game;
import com.fpmislata.exam.domain.usecase.GameFindAllUseCase;
import com.fpmislata.exam.domain.usecase.GameFindByCodeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(GameController.URL)
public class GameController {
    public static final String URL = "/api/games";

    private final GameFindAllUseCase gameFindAllUseCase;
    private final GameFindByCodeUseCase gameFindByCodeUseCase;

    @GetMapping
    public ResponseEntity<List<GameCollection>> findAll() {
        List<GameCollection> gameList = gameFindAllUseCase
                .findAll()
                .stream()
                .map(GameMapper.INSTANCE::toGameCollection)
                .toList();
        return new ResponseEntity<>(gameList, HttpStatus.OK);
    }

    @GetMapping("/{GameCode}")
    public ResponseEntity<Game> findByCode(@PathVariable String GameCode) {
        Game game = gameFindByCodeUseCase.findByCode(GameCode);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    
}
