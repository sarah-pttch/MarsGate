package com.example.marsgate.requestdtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.crypto.Mac;
import java.sql.Date;

public class ApplicationRequestDTO {

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    private int experience;

    private String university;
    @Size(max = 25, min = 1)
    private String telephone;
    @NotNull
    @Email
    private String email;
    private Date birthdate;
    private String essay;

    public ApplicationRequestDTO(String firstname, String lastname, String telephone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getExperience() {
        return experience;
    }

    public String getUniversity() {
        return university;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getEssay() {
        return essay;
    }
}
