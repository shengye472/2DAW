package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.admin.entity.Author;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.servise.AuthorAdminService;
import com.fpmislata.domain.admin.servise.BookAdminService;
import com.fpmislata.domain.admin.userCase.book.BookAdminInsertAuthorUseCase;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminInsertAuthorUseCaseImpl implements BookAdminInsertAuthorUseCase {

    private final BookAdminService bookAdminService;
    private final AuthorAdminService authorAdminService;

    @Override
    public void insertAuthors(Integer id, List<Author> authors) {
        Book book = bookAdminService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));

        authorAdminService.findAllById(authors).forEach(author -> bookAdminService.addAuthor(book, author));
        bookAdminService.save(book);
    }
}
