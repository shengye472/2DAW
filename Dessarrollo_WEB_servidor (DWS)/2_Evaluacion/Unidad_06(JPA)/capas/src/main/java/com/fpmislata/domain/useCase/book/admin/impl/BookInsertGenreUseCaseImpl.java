package com.fpmislata.domain.useCase.book.admin.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.entity.Genre;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.servise.GenreService;
import com.fpmislata.common.exception.ResourceNotFoundException;
import com.fpmislata.domain.useCase.book.admin.BookInsertGenreUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookInsertGenreUseCaseImpl implements BookInsertGenreUseCase {

    private final BookService bookService;
    private final GenreService genreService;

    @Override
    public void insertGenres(Integer id, List<Genre> genres) {
        Book book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("BookUser " + id + " not found"));
        genreService.findAllById(genres).forEach(genre -> bookService.addGenre(book,genre));
        bookService.save(book);
    }
}
