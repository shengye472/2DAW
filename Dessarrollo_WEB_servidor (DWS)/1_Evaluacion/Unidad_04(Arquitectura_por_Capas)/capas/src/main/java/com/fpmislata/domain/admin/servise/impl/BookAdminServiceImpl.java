package com.fpmislata.domain.admin.servise.impl;

import com.fpmislata.domain.admin.entity.Book;
import com.fpmislata.domain.admin.servise.BookAdminService;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import com.fpmislata.persistence.admin.repository.BookAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookAdminServiceImpl implements BookAdminService {
    private final BookAdminRepository bookAdminRepository;

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
        System.out.println("Servicio");
        return bookAdminRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("book isbn " + isbn + " not found"));
    }
}
