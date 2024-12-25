package com.fpmislata.domain.useCase.book.admin.impl;

import com.fpmislata.common.annotation.DomainTransactional;
import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.common.exception.ResourceAlreadyExistsException;
import com.fpmislata.common.exception.ResourceNotFoundException;
import com.fpmislata.domain.servise.*;
import com.fpmislata.domain.useCase.book.admin.BookInsertUseCase;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertUseCaseImpl implements BookInsertUseCase {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;

    @Override
    public void insertBook(Book book) {
        if (bookService.findByIsbn(book.getIsbn()).isPresent()) {
            throw new ResourceAlreadyExistsException("BookUser with ISBN " + book.getIsbn() + "already exists");
        }
        book.setPublisher(publisherService
                .findById(book.getPublisher().getId())
                .orElseThrow(() -> new ResourceNotFoundException("PublisherUser " + book.getPublisher().getName() + " not found")));
        book.setCategory(categoryService
                .findById(book.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryUser " + book.getCategory().getSlug() + "not found")));
        book.setAuthors(authorService
                .findAllById(book.getAuthors()));
        book.setGenres(genreService
                .findAllById(book.getGenres()));
        bookService.save(book);
    }
}
