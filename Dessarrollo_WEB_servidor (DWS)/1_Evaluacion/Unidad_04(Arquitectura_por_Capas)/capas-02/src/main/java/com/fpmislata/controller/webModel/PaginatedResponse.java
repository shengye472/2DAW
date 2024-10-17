package com.fpmislata.controller.webModel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginatedResponse<T> {
    private List<T> data;
    private int total;
    private int currentPage;
    private int pageSize;
    private String next;
    private String previous;

    public PaginatedResponse(List<T> data, int total,int currentPage,int pageSize, String baseURL){
        this.data = data;
        this.total = total;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.next = createNextLink(baseURL);
        this.previous = createPreviousLink(baseURL);
    }

    private String createNextLink(String baseURL) {
        if (currentPage * pageSize < total) {
            return baseURL + "?page=" + (currentPage+1) + "&size=" + pageSize;
        }
        return null;
    }

    private String createPreviousLink(String baseURL) {
        if (currentPage > 1){
            return baseURL + "?page=" + (currentPage - 1) + "&size=" + pageSize;
        }
        return null;
    }
}
