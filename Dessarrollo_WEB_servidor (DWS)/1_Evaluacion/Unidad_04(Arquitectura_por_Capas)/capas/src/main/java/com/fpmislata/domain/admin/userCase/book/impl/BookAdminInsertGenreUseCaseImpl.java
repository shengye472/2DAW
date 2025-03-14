package com.fpmislata.domain.admin.userCase.book.impl;

import com.fpmislata.common.annotation.DomainUseCase;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.entity.Genre;
import com.fpmislata.domain.admin.servise.BookAdminService;
import com.fpmislata.domain.admin.servise.GenreAdminService;
import com.fpmislata.domain.admin.userCase.book.BookAdminInsertGenreUseCase;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainUseCase
@RequiredArgsConstructor
public class BookAdminInsertGenreUseCaseImpl implements BookAdminInsertGenreUseCase {

    private final BookAdminService bookAdminService;
    private final GenreAdminService genreAdminService;

    @Override
    public void insertGenres(Integer id, List<Genre> genres) {
        Book book = bookAdminService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));
        genreAdminService.findAllById(genres).forEach(genre -> bookAdminService.addGenre(book,genre));
        bookAdminService.save(book);
    }
}
