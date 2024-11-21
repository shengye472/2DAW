package com.fpmislata.controller.admin;


import com.fpmislata.controller.admin.webModel.entity.book.BookCollection;
import com.fpmislata.controller.admin.webModel.mapper.bookMapper.BookMapper;
import com.fpmislata.controller.common.PaginatedResponse;
import com.fpmislata.domain.admin.entity.Author;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.entity.Genre;
import com.fpmislata.domain.admin.servise.BookAdminService;
import com.fpmislata.domain.admin.userCase.book.*;
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

    private final BookAdminGetAllUseCase bookGetAllUseCase;
    private final BookAdminCountUseCase bookAdminCountUseCase;
    private final BookAdminFindByIsbnUseCase bookAdminFindByIsbnUseCase;
    private final BookAdminInsertAuthorUseCase bookAdminInsertAuthorUseCase;
    private final BookAdminInsertGenreUseCase bookAdminInsertGenreUseCase;
    private final BookAdminInsertUseCase bookAdminInsertUseCase;

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
        int total = bookAdminCountUseCase.count();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, (int) total, page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> findByIsbn(@PathVariable String isbn) {
        Book book = bookAdminFindByIsbnUseCase.findByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/{id}/authors")
    public ResponseEntity<Void> insertAuthors(@PathVariable Integer id, @RequestBody List<Author> authors){
        bookAdminInsertAuthorUseCase.insertAuthors(id,authors);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/generes")
    public ResponseEntity<Void> insertGeneres(@PathVariable Integer id, @RequestBody List<Genre> genres){
        bookAdminInsertGenreUseCase.insertGenres(id,genres);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Void> insertBook(@RequestBody Book book){
        bookAdminInsertUseCase.insertBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
