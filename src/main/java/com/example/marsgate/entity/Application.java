package com.example.marsgate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.util.Objects;

@Entity
@NamedQuery(name = "findApplications", query = "select a from Application a where a.email=:email")
@NamedQuery(name = "updateCV", query = "update Application a set a.experience=:experience, a.university=:university, a.birthdate=:birthdate where a.Id=:Id")
@NamedQuery(name = "updateEssay", query = "update Application a set a.essay=:essay where a.Id=:Id")
public class Application {

    @Id
    @GeneratedValue
    private Integer Id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    @Email
    private String email;
    private String telephone;
    private Date birthdate;
    private int experience;
    private String university;
    private String essay;

    public Application(){}

    public Application(String firstname, String lastname, String email, String telephone) {
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

    public Integer getId() {
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

    public void setId(Integer Id) {
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
        if(university.equals("")) {
            this.university = "no degree entered";
        } else {
            this.university = university;
        }
    }

    public void setTelephone(String telephone) {
        if(telephone.equals("")) {
            this.telephone = "no phone number entered";
        } else {
            this.telephone = telephone;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setEssay(String essay) {
        if(essay.equals("")) {
            this.essay = "no essay added";
        } else {
            this.essay = essay;
        }
    }

    @Override
    public String toString() {
        return "Application{" +
                "Id=" + Id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthdate=" + birthdate +
                ", experience=" + experience +
                ", university='" + university + '\'' +
                ", essay='" + essay + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Id == that.Id && experience == that.experience && firstname.equals(that.firstname) && lastname.equals(that.lastname) && email.equals(that.email) && Objects.equals(telephone, that.telephone) && Objects.equals(birthdate, that.birthdate) && Objects.equals(university, that.university) && Objects.equals(essay, that.essay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstname, lastname, email, telephone, birthdate, experience, university, essay);
    }
}
