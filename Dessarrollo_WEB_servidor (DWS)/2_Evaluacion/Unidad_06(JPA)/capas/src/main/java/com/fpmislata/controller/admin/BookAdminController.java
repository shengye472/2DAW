package com.fpmislata.controller.admin;


import com.fpmislata.controller.admin.webModel.entity.book.BookCollection;
import com.fpmislata.controller.admin.webModel.mapper.bookMapper.BookMapper;
import com.fpmislata.controller.common.PaginatedResponse;
import com.fpmislata.domain.entity.Author;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.entity.Genre;
import com.fpmislata.domain.useCase.book.admin.*;
import com.fpmislata.domain.useCase.book.common.BookCountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookAdminController.URL)
@RequiredArgsConstructor
public class BookAdminController {

    public static final String URL = "/api/admin/books";
    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final BookGetAllAdminUseCase bookGetAllUseCase;
    private final BookCountUseCase bookCountUseCase;
    private final BookFindByIsbnAdminUseCase bookFindByIsbnUseCase;
    private final BookInsertAuthorUseCase bookInsertAuthorUseCase;
    private final BookInsertGenreUseCase bookInsertGenreUseCase;
    private final BookInsertUseCase bookInsertUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        List<BookCollection> books = bookGetAllUseCase
                .getAll(page - 1, pageSize)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
        int total = bookCountUseCase.count();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, (int) total, page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> findByIsbn(@PathVariable String isbn) {
        Book book = bookFindByIsbnUseCase.findByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/{id}/authors")
    public ResponseEntity<Void> insertAuthors(@PathVariable Integer id, @RequestBody List<Author> authors){
        bookInsertAuthorUseCase.insertAuthors(id,authors);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/generes")
    public ResponseEntity<Void> insertGeneres(@PathVariable Integer id, @RequestBody List<Genre> genres){
        bookInsertGenreUseCase.insertGenres(id,genres);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Void> insertBook(@RequestBody Book book){
        bookInsertUseCase.insertBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
