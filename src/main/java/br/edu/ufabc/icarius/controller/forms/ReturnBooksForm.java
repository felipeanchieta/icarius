package br.edu.ufabc.icarius.controller.forms;

import br.edu.ufabc.icarius.model.entities.Book;
import br.edu.ufabc.icarius.model.entities.User;

import java.util.List;

/**
 * Created by fcosta on 15/07/16.
 */
class ReturnBooksForm {
    private List<Book> bookList;
    private User user;

    public ReturnBooksForm() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
