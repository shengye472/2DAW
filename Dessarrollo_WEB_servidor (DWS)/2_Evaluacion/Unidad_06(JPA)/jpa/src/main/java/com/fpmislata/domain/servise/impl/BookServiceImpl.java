package com.fpmislata.domain.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.entity.Author;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.entity.Genre;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.common.exception.ResourceAlreadyExistsException;
import com.fpmislata.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public List<Book> getAll(int page, int size) {
        return bookRepository.getAll(page,size);
    }

    @Override
    public int count() {
        return bookRepository.count();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    public void addAuthor (Book book, Author author){
        if (book.getAuthors() == null) {
            book.setAuthors(new ArrayList<>());
        }
        if (book.getAuthors().contains(author)) {
            throw new ResourceAlreadyExistsException("AuthorUser " + author.getName() + "already exists");
        }
        book.addAuthor(author);
    }

    public void addGenre(Book book, Genre genre){
        if (book.getGenres() == null) {
            book.setGenres(new ArrayList<>());
        }
        if (book.getGenres().contains(genre)) {
            throw new ResourceAlreadyExistsException("GenreUser " + genre.getSlug() + "already exists");
        }
        book.addGenre(genre);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
