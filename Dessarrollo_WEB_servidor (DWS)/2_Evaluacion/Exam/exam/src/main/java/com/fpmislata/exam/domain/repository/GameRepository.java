package com.fpmislata.exam.domain.repository;

import com.fpmislata.exam.domain.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository {
    List<Game> findAll();

    Optional<Game> findByCode(String GameCode);
}
