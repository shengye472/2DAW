package com.fpmislata.controller.user;

import com.fpmislata.controller.common.PaginatedResponse;
import com.fpmislata.controller.user.webModel.entity.book.BookCollection;
import com.fpmislata.controller.user.webModel.entity.book.BookDetail;
import com.fpmislata.controller.user.webModel.mapper.bookMapper.BookMapper;
import com.fpmislata.domain.useCase.book.common.BookCountUseCase;
import com.fpmislata.domain.useCase.book.common.BookGetAllUseCase;
import com.fpmislata.domain.useCase.book.common.impl.BookFindByIdUseCaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookUserController.URL)
@RequiredArgsConstructor
public class BookUserController {

    public static final String URL = "/api/books";
    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final BookGetAllUseCase bookGetAllUseCase;
    private final BookCountUseCase bookCountUseCase;
    private final BookFindByIdUseCaseImpl bookFindByIdUseCase;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size){
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);
        List<BookCollection> bookCollections = bookGetAllUseCase
                .getAll(page - 1, pageSize)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
        int total = bookCountUseCase.count();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(bookCollections, total, page, pageSize, baseUrl + URL);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDetail> findByIsbn(@PathVariable String isbn){
        BookDetail bookDetail = BookMapper.INSTANCE.toBookDetail(bookFindByIdUseCase.findByIsbn(isbn));
        return new ResponseEntity<>(bookDetail,HttpStatus.OK);
    }
}