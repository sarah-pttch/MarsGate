package com.example.marsgate.service;

import com.example.marsgate.Application;
import com.example.marsgate.EssayTooLongException;
import com.example.marsgate.TelTooLongException;
import com.example.marsgate.UniTooLongException;
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
