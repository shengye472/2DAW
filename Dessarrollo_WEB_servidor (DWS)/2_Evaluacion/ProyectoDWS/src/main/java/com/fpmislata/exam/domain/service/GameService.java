package com.fpmislata.exam.domain.service;

import com.fpmislata.exam.domain.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<Game> findAll();

    Optional<Game> findByCode(String GameCode);
}
