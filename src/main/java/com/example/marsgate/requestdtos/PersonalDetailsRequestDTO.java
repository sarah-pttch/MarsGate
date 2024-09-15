package com.example.marsgate.requestdtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class PersonalDetailsRequestDTO {

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    @Email
    private String email;
    private String telephone;

    public PersonalDetailsRequestDTO(String firstname, String lastname, String email, String telephone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }
}
