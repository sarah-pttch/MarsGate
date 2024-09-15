package com.example.marsgate.service;

import com.example.marsgate.entity.Application;
import com.example.marsgate.requestdtos.CvRequestDTO;
import com.example.marsgate.requestdtos.EssayRequestDTO;
import com.example.marsgate.requestdtos.PersonalDetailsRequestDTO;

import java.util.Optional;

public interface ServiceInterface {

    Optional<Application> createApplication(PersonalDetailsRequestDTO personalDetailsRequestDTO);

    Optional<Application> addCV(CvRequestDTO cvRequestDTO);

    Optional<Application> addEssay(EssayRequestDTO essayRequestDTO);

    String findApplications(String email);

    String openApplication(int Id);

    void deleteApplication(int Id);
}
