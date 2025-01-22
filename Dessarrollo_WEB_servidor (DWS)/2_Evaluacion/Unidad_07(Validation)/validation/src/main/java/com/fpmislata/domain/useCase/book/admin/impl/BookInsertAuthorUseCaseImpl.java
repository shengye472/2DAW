package com.fpmislata.domain.useCase.book.admin.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Author;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.servise.AuthorService;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.common.exception.ResourceNotFoundException;
import com.fpmislata.domain.useCase.book.admin.BookInsertAuthorUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookInsertAuthorUseCaseImpl implements BookInsertAuthorUseCase {

    private final BookService bookService;
    private final AuthorService authorService;

    @Override
    public void insertAuthors(Integer id, List<Author> authors) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("BookUser " + id + " not found"));

        authorService.findAllById(authors).forEach(author -> bookService.addAuthor(book, author));
        bookService.save(book);
    }
}
