package com.fpmislata.exam.persistance.dao.jpa;

import com.fpmislata.exam.domain.model.Game;
import com.fpmislata.exam.persistance.dao.GameDao;
import com.fpmislata.exam.persistance.dao.jpa.mapper.GameJPAMapper;
import com.fpmislata.exam.persistance.dao.jpa.repositoryJpa.GameJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GameDaoImpl implements GameDao {

    private final GameJPARepository gameJPARepository;

    @Override
    public List<Game> findAll() {
        return gameJPARepository
                .findAll()
                .stream()
                .map(GameJPAMapper.INSTANCE::toGame)
                .toList();
    }

    @Override
    public Optional<Game> findByCode(String GameCode) {
        return Optional.ofNullable(gameJPARepository
                .findByGameCode(GameCode))
                .map(GameJPAMapper.INSTANCE::toGameDetail);
    }
}
