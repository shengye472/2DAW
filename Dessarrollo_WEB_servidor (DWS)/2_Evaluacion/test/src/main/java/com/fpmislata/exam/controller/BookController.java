package com.fpmislata.exam.controller;

import com.fpmislata.exam.controller.webModel.BookCollection;
import com.fpmislata.exam.controller.webModel.mapper.Mapper;
import com.fpmislata.exam.domain.usecase.BookFindAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BookController.URL)
@RequiredArgsConstructor
public class BookController {

    public static final String URL = "/api/books";

    private final BookFindAllUseCase bookFindAllUseCase;

    @GetMapping
    public List<BookCollection> findAll() {
        return bookFindAllUseCase.findAll()
                .stream()
                .map(Mapper.INSTANCE::toBookCollection)
                .toList();
    }


}

