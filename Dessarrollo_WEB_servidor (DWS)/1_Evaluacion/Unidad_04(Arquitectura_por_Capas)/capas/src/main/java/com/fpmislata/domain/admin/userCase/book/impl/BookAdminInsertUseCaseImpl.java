package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.servise.*;
import com.fpmislata.domain.admin.userCase.book.BookAdminInsertUseCase;
import com.fpmislata.domain.exception.ResourceAlreadyExistsException;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminInsertUseCaseImpl implements BookAdminInsertUseCase {
    private final BookAdminService bookAdminService;
    private final AuthorAdminService authorAdminService;
    private final GenreAdminService genreAdminService;
    private final PublisherAdminService publisherAdminService;
    private final CategoryAdminService categoryAdminService;

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
