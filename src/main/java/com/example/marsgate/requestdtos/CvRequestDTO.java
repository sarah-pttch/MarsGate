package com.example.marsgate.requestdtos;

import java.sql.Date;

public class CvRequestDTO {

    private Integer Id;
    private Date birthdate;
    private Integer experience;
    private String university;

    public CvRequestDTO(Integer Id, Date birthdate, Integer experience, String university) {
        this.Id = Id;
        this.birthdate = birthdate;
        this.experience = experience;
        this.university = university;
    }

    public Integer getId() {
        return Id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Integer getExperience() {
        return experience;
    }

    public String getUniversity() {
        return university;
    }
}
