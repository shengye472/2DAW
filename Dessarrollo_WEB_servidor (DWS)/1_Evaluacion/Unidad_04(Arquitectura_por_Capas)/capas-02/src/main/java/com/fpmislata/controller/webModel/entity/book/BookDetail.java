package com.fpmislata.controller.webModel.entity.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpmislata.controller.webModel.entity.author.AuthorCollection;
import com.fpmislata.controller.webModel.entity.publisher.PublisherCollection;

import java.math.BigDecimal;
import java.util.List;

public record BookDetail(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String cover,
        String synopsis,
        List<String> genres,
        String category,
        @JsonProperty("publisher") PublisherCollection publisherCollection,
        @JsonProperty("authors") List<AuthorCollection> authorsCollection
) {
}
