package com.fpmislata.domain.useCase.book.admin.impl;

import com.fpmislata.common.annotation.DomainTransactional;
import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.useCase.book.admin.BookDeleteByIdUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookDeleteByIdUseCaseImpl implements BookDeleteByIdUseCase {

    private final BookService bookService;

    @Override
    public void deleteBook(Long id) {
        bookService.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookService.deleteById(id);
    }
}
