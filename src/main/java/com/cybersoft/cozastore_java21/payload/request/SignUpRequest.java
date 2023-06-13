package com.cybersoft.cozastore_java21.payload.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SignUpRequest {
    @NotEmpty(message = "Username is not empty!")
    private String username;
    @NotNull(message = "Password is not null!")
    @NotEmpty(message = "Password is not empty!")
    @Length(min = 4, message = "Min Password is 4")
    private String password;
    @NotEmpty(message = "rePassword is not empty!")
    private String rePassword;
    @NotEmpty(message = "Email is not null!")
    @NotEmpty(message = "Email is not empty!")
    @Email(message = "Email is valid!")
    private String emailAddress;

    public SignUpRequest() {
    }

    public SignUpRequest(String username, String password, String rePassword, String emailAddress) {

        this.username = username;
        this.password = password;
        this.rePassword = rePassword;
        this.emailAddress = emailAddress;
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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
