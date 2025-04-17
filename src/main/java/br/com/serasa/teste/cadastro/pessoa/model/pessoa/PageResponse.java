package br.com.serasa.teste.cadastro.pessoa.model.pessoa;

import lombok.Getter;

import java.util.List;

@Getter
public class PageResponse<T> {
    private List<T> content;
    private int currentPage;
    private int totalPages;
    private long totalElements;

    public PageResponse(List<T> content, int currentPage, int totalPages, int totalElements) {
        this.content = content;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalElements = totalElements;

    }
}