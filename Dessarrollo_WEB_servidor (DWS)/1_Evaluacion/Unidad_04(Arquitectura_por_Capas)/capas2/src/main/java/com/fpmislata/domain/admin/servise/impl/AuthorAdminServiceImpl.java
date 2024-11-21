package com.fpmislata.domain.admin.servise.impl;

import com.fpmislata.common.annotation.DomainService;
import com.fpmislata.domain.admin.entity.Author;
import com.fpmislata.domain.admin.repository.AuthorAdminRepository;
import com.fpmislata.domain.admin.servise.AuthorAdminService;
import com.fpmislata.domain.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class AuthorAdminServiceImpl implements AuthorAdminService {

    private final AuthorAdminRepository authorAdminRepository;

    @Override
    public List<Author> findAllById(List<Author> authors) {
        List<Author> authorList = authorAdminRepository.findAllById(
                authors.stream()
                        .map(Author::getId)
                        .toArray(Long[]::new)
        );
        if(authorList.size() != authors.size()) {
            throw new ResourceNotFoundException("Some authors were not found");
        }

        return authorList;
    }
}
