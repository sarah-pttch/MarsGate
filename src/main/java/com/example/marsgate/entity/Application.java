package com.example.marsgate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

@Entity
@NamedQuery(name = "findapplications", query = "select a from Application a where a.email=:email")
@NamedQuery(name = "updateCV", query = "update Application a set a.experience=:experience, a.university=:university, a.birthdate=:birthdate where a.Id=:Id")
@NamedQuery(name = "updateEssay", query = "update Application a set a.essay=:essay where a.Id=:Id")
public class Application {

    @Id
    @GeneratedValue
    private int Id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
//    @Column(columnDefinition = "integer default 0")
    private int experience;
    @Column(columnDefinition = "varchar(100) default 'no degree entered'")
    private String university;
    @Column(columnDefinition = "varchar(25) default 'no telephone number entered'")
    private String telephone;
    @NotNull
    @Email
    private String email;
//    @Column(columnDefinition = "date default '1900-01-01'")
    private Date birthdate;
    @Column(columnDefinition = "varchar(1000) default 'no essay added'")
    private String essay;

    public Application(){}

    public Application(String firstname, String lastname, String telephone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.email = email;
    }

    public Application(Date birthdate, int experience, String university) {
        this.birthdate = birthdate;
        this.experience = experience;
        this.university = university;
    }

    public Application(String essay) {
        this.essay = essay;
    }

    public int getId() {
        return Id;
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

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setEssay(String essay) {
        this.essay = essay;
    }

    @Override
    public String toString() {
        return "Application{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", experience=" + experience +
                ", university='" + university + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", essay='" + essay + '\'' +
                "}";
    }
}
