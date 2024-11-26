package com.fpmislata.domain.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.entity.Genre;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.servise.GenreService;
import com.fpmislata.domain.userCase.book.BookInsertGenreUseCase;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookInsertGenreUseCaseImpl implements BookInsertGenreUseCase {

    private final BookService bookAdminService;
    private final GenreService genreAdminService;

    @Override
    public void insertGenres(Integer id, List<Genre> genres) {
        Book book = bookAdminService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));
        genreAdminService.findAllById(genres).forEach(genre -> bookAdminService.addGenre(book,genre));
        bookAdminService.save(book);
    }
}
