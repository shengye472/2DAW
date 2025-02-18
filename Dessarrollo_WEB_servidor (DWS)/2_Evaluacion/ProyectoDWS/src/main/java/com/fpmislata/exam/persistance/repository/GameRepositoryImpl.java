package com.fpmislata.exam.persistance.repository;

import com.fpmislata.exam.domain.model.Game;
import com.fpmislata.exam.domain.repository.GameRepository;
import com.fpmislata.exam.persistance.dao.GameDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GameRepositoryImpl implements GameRepository {

    private final GameDao gameDao;

    @Override
    public List<Game> findAll() {
        return gameDao.findAll();
    }

    @Override
    public Optional<Game> findByCode(String GameCode) {
        return gameDao.findByCode(GameCode);
    }
}
