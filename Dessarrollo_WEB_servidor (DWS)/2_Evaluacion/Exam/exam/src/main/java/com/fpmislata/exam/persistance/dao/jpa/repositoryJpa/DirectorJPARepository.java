package com.fpmislata.exam.persistance.dao.jpa.repositoryJpa;

import com.fpmislata.exam.persistance.dao.jpa.model.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorJPARepository extends JpaRepository<DirectorEntity, Integer> {

}
