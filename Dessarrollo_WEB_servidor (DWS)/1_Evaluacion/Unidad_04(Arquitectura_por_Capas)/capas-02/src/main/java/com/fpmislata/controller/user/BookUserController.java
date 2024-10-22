package com.fpmislata.controller.user;

import com.fpmislata.controller.common.PaginatedResponse;
import com.fpmislata.controller.user.webModel.entity.book.BookCollection;
import com.fpmislata.controller.user.webModel.entity.book.BookDetail;
import com.fpmislata.controller.user.webModel.mapper.bookMapper.BookMapper;
import com.fpmislata.domain.user.service.BookUserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookUserController {
    private final BookUserService bookUserService;

    @GetMapping
//    public ResponseEntity<List<BookCollection>> getAll(){
//        List<BookCollection> bookCollections = bookService
//                .getAll()
//                .stream()
//                .map(BookMapper.INSTANCE::toBookCollection)
//                .toList();
//        return new ResponseEntity<>(bookCollections, HttpStatus.OK);
//    }
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            HttpServletRequest request){
        List<BookCollection> bookCollections = bookUserService
                .getAll(page - 1, size)
                .stream()
                .map(BookMapper.INSTANCE::toBookCollection)
                .toList();
        int total = bookUserService.count();
        String baseUrl = request.getRequestURL().toString();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(bookCollections, (int) total, page, size, baseUrl);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDetail> findByIsbn(@PathVariable String isbn){
        BookDetail bookDetail = BookMapper.INSTANCE.toBookDetail(bookUserService.findByIsbn(isbn));
        return new ResponseEntity<>(bookDetail,HttpStatus.OK);
    }
}