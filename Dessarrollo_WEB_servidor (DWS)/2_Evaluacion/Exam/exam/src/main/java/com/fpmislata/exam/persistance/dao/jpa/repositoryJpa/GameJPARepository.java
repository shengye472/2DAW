package com.fpmislata.exam.persistance.dao.jpa.repositoryJpa;

import com.fpmislata.exam.persistance.dao.jpa.model.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameJPARepository extends JpaRepository<GameEntity, Integer> {
    
    GameEntity findByGameCode(String code);

}
