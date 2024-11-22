package com.fpmislata.domain.admin.userCase.book;

import com.fpmislata.domain.entity.Book;

public interface BookAdminFindByIsbnUseCase {
    Book findByIsbn(String isbn);

}
