package com.fpmislata.domain.admin.userCase.book;

import com.fpmislata.domain.admin.entity.Book;

import java.util.List;

public interface BookAdminGetAllUseCase {
    List<Book> getAll(int page, int size);
}
