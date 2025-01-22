package com.fpmislata.persistence.dao.impl.jpa.repository;

import com.fpmislata.persistence.dao.impl.jpa.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Long> {
    @Query(value = """
            SELECT a.* FROM authors a
            JOIN books_authors ba ON a.id = ba.author_id
            JOIN books b ON ba.book_id = b.id
            AND b.isbn = :isbn
            """, nativeQuery = true)
    List<AuthorEntity> findByIsbn(String isbn);

    @Query(value = """
            SELECT a.* FROM authors a
            JOIN books_authors ba ON a.id = ba.author_id
            JOIN books b ON ba.book_id = b.id
            AND b.id = :id
            """, nativeQuery = true)
    List<AuthorEntity> findByIdBook(long id);
}
