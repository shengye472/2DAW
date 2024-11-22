package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Author;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.servise.AuthorService;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.admin.userCase.book.BookAdminInsertAuthorUseCase;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminInsertAuthorUseCaseImpl implements BookAdminInsertAuthorUseCase {

    private final BookService bookAdminService;
    private final AuthorService authorAdminService;

    @Override
    public void insertAuthors(Integer id, List<Author> authors) {
        Book book = bookAdminService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));

        authorAdminService.findAllById(authors).forEach(author -> bookAdminService.addAuthor(book, author));
        bookAdminService.save(book);
    }
}
