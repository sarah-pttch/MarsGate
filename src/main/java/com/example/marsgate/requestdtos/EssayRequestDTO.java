package com.example.marsgate.requestdtos;

public class EssayRequestDTO {

    private Integer Id;
    private String essay;

    public EssayRequestDTO(Integer Id, String essay) {
        this.Id = Id;
        this.essay = essay;
    }

    public Integer getId() {
        return Id;
    }

    public String getEssay() {
        return essay;
    }
}
