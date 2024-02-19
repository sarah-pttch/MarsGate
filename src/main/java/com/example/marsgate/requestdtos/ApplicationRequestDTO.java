package com.example.marsgate.requestdtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public class ApplicationRequestDTO {

    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    private int experience;

    @Size(max = 100)
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
//
//    public ApplicationRequestDTO(Date birthdate, int experience, String university) {
//        this.birthdate = birthdate;
//        this.experience = experience;
//        this.university = university;
//    }

//    public ApplicationRequestDTO(String firstname, String lastname, String telephone, String email, Date birthdate, int experience, String university, String essay){
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.telephone = telephone;
//        this.email = email;
//        this.birthdate = birthdate;
//        this.experience = experience;
//        this.university = university;
//        this.essay = essay;
//    }

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
