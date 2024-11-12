package com.fpmislata.domain.admin.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.admin.entity.Author;
import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.entity.Genre;
import com.fpmislata.domain.admin.repository.AuthorAdminRepository;
import com.fpmislata.domain.admin.repository.GenreAdminRepository;
import com.fpmislata.domain.admin.servise.BookAdminService;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import com.fpmislata.domain.admin.repository.BookAdminRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class BookAdminServiceImpl implements BookAdminService {
    private final BookAdminRepository bookAdminRepository;
    private final AuthorAdminRepository authorAdminRepository;
    private final GenreAdminRepository genreAdminRepository;

    @Override
    public List<Book> getAll() {
        return bookAdminRepository.getAll();
    }

    @Override
    public List<Book> getAll(int page, int size) {
        return bookAdminRepository.getAll(page,size);
    }

    @Override
    public int count() {
        return bookAdminRepository.count();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookAdminRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("book isbn " + isbn + " not found"));
    }

    @Override
    public Book findById(int id) {
        return bookAdminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));
    }

    @Override
    public void insertAuthors(Integer id, List<Author> authors) {
        Book book = findById(id);
//  ------------------------------------------------------------------------------
//        No entiendo esta parte, preguntar a marcos o cesar para explicarlo
        List<Author> authorList = authorAdminRepository.findAllById(
                authors.stream()
                        .map(Author::getId)
                        .toArray(Long[]::new)
        );
//  ------------------------------------------------------------------------------
        if(authorList.size() != authors.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }
        authorList.forEach(book::addAuthor);
        bookAdminRepository.save(book);
    }

    @Override
    public void insertGenres(Integer id, List<Genre> genres) {
            Book book = findById(id);
            List<Genre> genreList = genreAdminRepository.findAllById(
                    genres.stream()
                            .map(Genre::getId)
                            .toArray(Long[]::new)
            );
            if(genreList.size() != genres.size()) {
                throw new ResourceNotFoundException("Some authors were not found");
            }
            genreList.forEach(book::addGenre);
            bookAdminRepository.save(book);
    }
}
