package com.example.marsgate.service;

import com.example.marsgate.entity.Application;
import com.example.marsgate.service.exceptions.EssayTooLongException;
import com.example.marsgate.service.exceptions.TelTooLongException;
import com.example.marsgate.service.exceptions.UniTooLongException;
import com.example.marsgate.requestdtos.ApplicationRequestDTO;

import java.util.Optional;

public interface ServiceInterface {

    Optional<Application> createApplication(ApplicationRequestDTO application) throws TelTooLongException;

    Optional<Application> addCV(Application application) throws UniTooLongException;

    Optional<Application> addEssay(Application application) throws EssayTooLongException;

    String findApplications(String email);

    String openApplication(int Id);

    void deleteApplication(int Id);
}
