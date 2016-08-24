package br.edu.ufabc.icarius.controller.forms;

import javax.validation.constraints.NotNull;

public class SearchForm {

    @NotNull
    private String searchExpression;

    public SearchForm() {
    }

    public String getSearchExpression() {
        return searchExpression;
    }

    public void setSearchExpression(String searchExpression) {
        this.searchExpression = searchExpression;
    }

    @Override
    public String toString() {
        return "SearchForm{" +
            "searchExpression=" + searchExpression +
            '}';
    }
}
