package com.fpmislata.domain.userCase.book;

import com.fpmislata.domain.entity.Book;

public interface BookFindByIsbnUseCase {
    Book findByIsbn(String isbn);

}
