package com.example.marsgate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

@Entity
@NamedQuery(name = "findapplications", query = "select a from Application a where a.firstname=:firstname AND a.lastname=:lastname")
@NamedQuery(name = "updatePersonalDetails", query = "update Application a set a.telephone=:telephone, a.email=:email, a.birthdate=:birthdate where a.Id=:Id")
@NamedQuery(name = "updateEssay", query = "update Application a set a.essay=:essay where a.Id=:Id")
public class Application {

    @Id
    @GeneratedValue
    private int Id;
    private String firstname;
    private String lastname;
    private int experience;
    private String university;
    private String telephone;
    private String email;
    private Date birthdate;
    private String essay;

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
                '}';
    }
}
