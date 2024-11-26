package com.fpmislata.domain.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.userCase.book.BookInsertUseCase;
import com.fpmislata.domain.exception.ResourceAlreadyExistsException;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import com.fpmislata.domain.servise.*;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookInsertUseCaseImpl implements BookInsertUseCase {
    private final BookService bookAdminService;
    private final AuthorService authorAdminService;
    private final GenreService genreAdminService;
    private final PublisherService publisherAdminService;
    private final CategoryService categoryAdminService;

    @Override
    public void insertBook(Book book) {
        if (bookAdminService.findByIsbn(book.getIsbn()).isPresent()) {
            throw new ResourceAlreadyExistsException("Book with ISBN " + book.getIsbn() + "already exists");
        }
        book.setPublisher(publisherAdminService
                .findById(book.getPublisher().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Publisher " + book.getPublisher().getName() + " not found")));
        book.setCategory(categoryAdminService
                .findById(book.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category " + book.getCategory().getSlug() + "not found")));
        book.setAuthors(authorAdminService
                .findAllById(book.getAuthors()));
        book.setGenres(genreAdminService
                .findAllById(book.getGenres()));
        bookAdminService.save(book);
    }
}
