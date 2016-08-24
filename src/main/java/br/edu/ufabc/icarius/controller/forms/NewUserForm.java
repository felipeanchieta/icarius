package br.edu.ufabc.icarius.controller.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class NewUserForm {

    @NotNull
    @Pattern(regexp = "\\d{11}", message = "Invalid CPF")
    private String cpf;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String passwordRepeat;
    @NotNull
    @Pattern(regexp = "\\w{3,255}")
    private String name;
    @NotNull
    private String birthDate;

    public NewUserForm() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
