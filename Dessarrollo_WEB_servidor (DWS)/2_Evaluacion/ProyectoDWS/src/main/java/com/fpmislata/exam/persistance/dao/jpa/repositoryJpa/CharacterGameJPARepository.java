package com.fpmislata.exam.persistance.dao.jpa.repositoryJpa;

import com.fpmislata.exam.persistance.dao.jpa.model.CharacterGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterGameJPARepository extends JpaRepository<CharacterGameEntity,Integer> {
}
