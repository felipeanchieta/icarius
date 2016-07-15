package br.edu.ufabc.icarius.controller.forms;

import java.util.List;

/**
 * Created by fcosta on 15/07/16.
 */
public class SearchForm {

    private List<String> searchExpression;

    public SearchForm() {
    }

    public List<String> getSearchExpression() {
        return searchExpression;
    }

    public void setSearchExpression(List<String> searchExpression) {
        this.searchExpression = searchExpression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchForm that = (SearchForm) o;

        return searchExpression != null ? searchExpression.equals(that.searchExpression) : that.searchExpression == null;

    }

    @Override
    public String toString() {
        return "SearchForm{" +
            "searchExpression=" + searchExpression +
            '}';
    }
}
