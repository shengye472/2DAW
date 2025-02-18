package com.fpmislata.exam.domain.service.impl;

import com.fpmislata.exam.common.annotation.DomainService;
import com.fpmislata.exam.domain.model.Game;
import com.fpmislata.exam.domain.repository.GameRepository;
import com.fpmislata.exam.domain.service.GameService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Game> findByCode(String GameCode) {
        return gameRepository.findByCode(GameCode);
    }
}
