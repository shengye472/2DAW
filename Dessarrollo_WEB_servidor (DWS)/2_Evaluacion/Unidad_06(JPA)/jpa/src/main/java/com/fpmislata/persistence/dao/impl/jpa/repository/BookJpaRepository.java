package com.fpmislata.persistence.dao.impl.jpa.repository;

import com.fpmislata.persistence.dao.impl.jpa.entity.BookEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

//    @Query("""
//            SELECT * FROM books
//            INNER JOIN categories ON books.category_id = categories.id
//            INNER JOIN publishers ON books.publisher_id = publishers.id
//            WHERE books.isbn = :isbn
//            """)
    @EntityGraph(attributePaths = {"publisher", "category"})
    BookEntity findByIsbn(String isbn);

    @EntityGraph(attributePaths = {"publisher", "category"})
    Optional<BookEntity> findById(int id);
}
