package com.fpmislata.persistence.dao.impl.jpa.repository;

import com.fpmislata.persistence.dao.impl.jpa.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorJpaRepository extends JpaRepository<AuthorEntity, Long> {
//    @Query("""
//            SELECT a.* FROM authors a
//            JOIN books_authors ba ON a.id = ba.author_id
//            JOIN books b ON ba.book_id = b.id
//            AND b.isbn = :isbn
//            """)
//    List<AuthorEntity> findByIsbn(String isbn);
//
//
//    List<AuthorEntity> findByIdBook(long id);
}
