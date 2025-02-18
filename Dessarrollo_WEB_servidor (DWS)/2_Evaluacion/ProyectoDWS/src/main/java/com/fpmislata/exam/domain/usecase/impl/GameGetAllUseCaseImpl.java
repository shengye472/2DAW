package com.fpmislata.exam.domain.usecase.impl;

import com.fpmislata.exam.common.annotation.DomainUseCase;
import com.fpmislata.exam.domain.model.Game;
import com.fpmislata.exam.domain.service.GameService;
import com.fpmislata.exam.domain.usecase.GameFindAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class GameGetAllUseCaseImpl implements GameFindAllUseCase {
    private final GameService gameService;
    @Override
    public List<Game> findAll() {
        return gameService.findAll();
    }
}
