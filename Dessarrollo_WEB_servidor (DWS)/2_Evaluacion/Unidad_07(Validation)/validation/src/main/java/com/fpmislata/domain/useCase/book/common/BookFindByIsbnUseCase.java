package com.fpmislata.domain.useCase.book.common;

import com.fpmislata.domain.entity.Book;

public interface BookFindByIsbnUseCase {
    Book findByIsbn(String isbn);
}
