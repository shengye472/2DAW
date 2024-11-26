package com.fpmislata.domain.user.useCase.book;

import com.fpmislata.domain.user.entity.Book;

public interface BookUseFindByIdUseCase {
    Book findByIsbn(String isbn);
}
