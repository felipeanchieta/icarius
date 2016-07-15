package br.edu.ufabc.icarius.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

/**
 * Created by fcosta on 15/07/16.
 */
@Entity
public class Book {

    @Id
    private String isbn;
    private String title;
    @OneToMany
    private List<Author> authorList;
    private String press;
    private String location;
    private Integer year;

    public Book() {
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) &&
            Objects.equals(title, book.title) &&
            Objects.equals(authorList, book.authorList) &&
            Objects.equals(press, book.press) &&
            Objects.equals(location, book.location) &&
            Objects.equals(year, book.year);
    }

    @Override
    public String toString() {
        return "Book{" +
            "isbn='" + isbn + '\'' +
            ", title='" + title + '\'' +
            ", authorList=" + authorList +
            ", press='" + press + '\'' +
            ", location='" + location + '\'' +
            ", year=" + year +
            '}';
    }
}
