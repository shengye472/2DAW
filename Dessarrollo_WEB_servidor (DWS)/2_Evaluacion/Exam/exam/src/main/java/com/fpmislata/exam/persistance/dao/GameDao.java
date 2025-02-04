package com.fpmislata.exam.persistance.dao;

import com.fpmislata.exam.domain.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameDao {
    List<Game> findAll();

    Optional<Game> findByCode(String GameCode);
}
