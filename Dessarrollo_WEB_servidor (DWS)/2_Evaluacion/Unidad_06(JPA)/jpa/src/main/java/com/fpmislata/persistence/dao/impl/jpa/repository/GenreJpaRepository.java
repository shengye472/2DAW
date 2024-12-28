package com.fpmislata.persistence.dao.impl.jpa.repository;

import com.fpmislata.persistence.dao.impl.jpa.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface GenreJpaRepository extends JpaRepository<GenreEntity, Long> {

    @Query(value = """
            SELECT genres.* FROM genres
            JOIN books_genres ON genres.id = books_genres.genre_id
            JOIN books ON books_genres.book_id = books.id
            WHERE books.isbn = :isbn
            """, nativeQuery = true)
    List<GenreEntity> findByIsbn(String isbn);

    @Query(value = """
            SELECT genres.* FROM genres
            JOIN books_genres ON genres.id = books_genres.genre_id
            JOIN books ON books_genres.book_id = books.id
            WHERE books.id = :id
            """, nativeQuery = true)
    List<GenreEntity> findByIdBook(long id);
}
