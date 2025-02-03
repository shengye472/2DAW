package com.fpmislata.exam.persistance.dao.jpa.repository;

import com.fpmislata.exam.persistance.dao.jpa.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositoryJpa extends JpaRepository<BookEntity,Long> {
}
