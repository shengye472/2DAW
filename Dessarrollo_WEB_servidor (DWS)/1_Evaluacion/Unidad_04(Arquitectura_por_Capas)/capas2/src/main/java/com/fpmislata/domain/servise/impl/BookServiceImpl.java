package com.fpmislata.domain.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.entity.Author;
import com.fpmislata.domain.entity.Book;
import com.fpmislata.domain.entity.Genre;
import com.fpmislata.domain.repository.AuthorRepository;
import com.fpmislata.domain.repository.GenreRepository;
import com.fpmislata.domain.servise.BookService;
import com.fpmislata.domain.exception.ResourceAlreadyExistsException;
import com.fpmislata.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookAdminRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreAdminRepository;

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
    public Optional<Book> findByIsbn(String isbn) {
        return bookAdminRepository.findByIsbn(isbn);
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookAdminRepository.findById(id);
    }

//    @Override
//    public void insertAuthors(Integer id, List<Author> authors) {
////  ------------------------------------------------------------------------------
////        No entiendo esta parte, preguntar a marcos o cesar para explicarlo
//        List<Author> authorList = authorRepository.findAllById(
//                authors.stream()
//                        .map(Author::getId)
//                        .toArray(Long[]::new)
//        );
////  ------------------------------------------------------------------------------
//        if(authorList.size() != authors.size()) {
//            throw new ResourceNotFoundException("Some authors were not found");
//        }
//        authorList.forEach(book::addAuthor);
//        bookAdminRepository.save(book);
//    }

//    @Override
//    public void insertGenres(Integer id, List<Genre> genres) {
//            List<Genre> genreList = genreAdminRepository.findAllById(
//                    genres.stream()
//                            .map(Genre::getId)
//                            .toArray(Long[]::new)
//            );
//            if(genreList.size() != genres.size()) {
//                throw new ResourceNotFoundException("Some authors were not found");
//            }
//            genreList.forEach(book::addGenre);
//            bookAdminRepository.save(book);
//    }

    public void addAuthor (Book book, Author author){
        if (book.getAuthors() == null) {
            book.setAuthors(new ArrayList<>());
        }
        if (book.getAuthors().contains(author)) {
            throw new ResourceAlreadyExistsException("Author " + author.getName() + "already exists");
        }
        book.addAuthor(author);
    }

    public void addGenre(Book book, Genre genre){
        if (book.getGenres() == null) {
            book.setGenres(new ArrayList<>());
        }
        if (book.getGenres().contains(genre)) {
            throw new ResourceAlreadyExistsException("Genre " + genre.getSlug() + "already exists");
        }
        book.addGenre(genre);
    }

    @Override
    public void save(Book book) {
        bookAdminRepository.save(book);
    }
}
