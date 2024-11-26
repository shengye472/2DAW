package com.fpmislata.domain.user.useCase.book;

import com.fpmislata.domain.user.entity.Book;

import java.util.List;

public interface BookUserGetAllUseCase {

    List<Book> getAll(int i, int pageSize);
}
