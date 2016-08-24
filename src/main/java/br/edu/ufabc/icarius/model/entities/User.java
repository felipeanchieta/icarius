package br.edu.ufabc.icarius.model.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    private String cpf;
    private String name;
    private String username;
    @Column(columnDefinition = "BINARY(32)")
    private byte[] password;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate")
    private Date birthDate;

    @OneToMany(mappedBy = "cpf")
    private List<Loan> loanBooks;

    @OneToMany(mappedBy = "cpf")
    private List<Reservation> reservations;

    public User() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Loan> getLoanBooks() {
        return loanBooks;
    }

    public void setLoanBooks(List<Loan> loanBooks) {
        this.loanBooks = loanBooks;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
