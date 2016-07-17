package br.edu.ufabc.icarius.model.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by fcosta on 15/07/16.
 */
@Entity
public class User {
    @Id
    private Long cpf;

    private String name;

    private String username;

    private String password;

    @Temporal(TemporalType.DATE)
    private Calendar birthDate;

    @OneToMany
    private List<Book> loanBooks;

    @OneToMany
    private List<Book> reserves;

    public User() {
    }

    public User(Long cpf, String name, String username, String password) {
        this.cpf = cpf;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public List<Book> getLoanBooks() {
        return loanBooks;
    }

    public void setLoanBooks(List<Book> loanBooks) {
        this.loanBooks = loanBooks;
    }

    public List<Book> getReserves() {
        return reserves;
    }

    public void setReserves(List<Book> reserves) {
        this.reserves = reserves;
    }
}
