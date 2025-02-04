package com.fpmislata.exam.domain.usecase.impl;

import com.fpmislata.exam.common.annotation.DomainUseCase;
import com.fpmislata.exam.common.exception.ResourceNotFoundException;
import com.fpmislata.exam.domain.model.Game;
import com.fpmislata.exam.domain.service.GameService;
import com.fpmislata.exam.domain.usecase.GameFindByCodeUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class GameFindByCodeUseCaseImpl implements GameFindByCodeUseCase {
    private final GameService gameService;

    @Override
    public Game findByCode(String GameCode) {
        return gameService.findByCode(GameCode).orElseThrow(() -> new ResourceNotFoundException("Game with code " + GameCode + " not found"));
    }
}
