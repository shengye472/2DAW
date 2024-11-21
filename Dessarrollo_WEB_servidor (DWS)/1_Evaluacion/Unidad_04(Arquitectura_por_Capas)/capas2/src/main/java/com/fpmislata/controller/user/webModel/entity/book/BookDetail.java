package com.fpmislata.controller.user.webModel.entity.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpmislata.controller.user.webModel.entity.author.AuthorCollection;
import com.fpmislata.controller.user.webModel.entity.publisher.PublisherCollection;

import java.math.BigDecimal;
import java.util.List;

public record BookDetail(
        String isbn,
        String title,
        String synopsis,
        BigDecimal price,
        float discount,
        String cover,
        List<String> genres,
        String category,
        @JsonProperty("publisher") PublisherCollection publisherCollection,
        @JsonProperty("authors") List<AuthorCollection> authorsCollection
) {
}
