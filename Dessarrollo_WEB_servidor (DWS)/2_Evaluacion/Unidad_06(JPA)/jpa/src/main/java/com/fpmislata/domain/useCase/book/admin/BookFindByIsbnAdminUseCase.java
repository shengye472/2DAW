package com.fpmislata.domain.useCase.book.admin;

import com.fpmislata.domain.entity.Book;

public interface BookFindByIsbnAdminUseCase {
    Book findByIsbn(String isbn);

}
