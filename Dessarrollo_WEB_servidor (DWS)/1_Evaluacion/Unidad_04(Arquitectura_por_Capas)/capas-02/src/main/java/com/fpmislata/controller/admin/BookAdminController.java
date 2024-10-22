package com.fpmislata.controller.admin;


import com.fpmislata.controller.admin.webModel.entity.book.BookCollection;
import com.fpmislata.controller.admin.webModel.mapper.bookMapper.BookMapper;
import com.fpmislata.controller.common.PaginatedResponse;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.servise.BookAdminService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/books")
@RequiredArgsConstructor
public class BookAdminController {
    private final BookAdminService bookAdminService;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest request) {
        List<BookCollection> books = bookAdminService
                .getAll(page - 1, size)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
        int total = bookAdminService.count();
        String baseUrl = request.getRequestURL().toString();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, (int) total, page, size, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> findByIsbn(@PathVariable String isbn) {
        Book book = bookAdminService.findByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
