package com.example.marsgate.service;

import com.example.marsgate.entity.Application;
import com.example.marsgate.service.exceptions.EssayTooLongException;
import com.example.marsgate.service.exceptions.TelTooLongException;
import com.example.marsgate.service.exceptions.UniTooLongException;
import com.example.marsgate.requestdtos.ApplicationRequestDTO;

import java.util.Optional;

public interface ServiceInterface {

    Optional<Application> createApplication(ApplicationRequestDTO applicationRequestDTO) throws TelTooLongException;

    Optional<Application> addCV(ApplicationRequestDTO applicationRequestDTO) throws UniTooLongException;

    Optional<Application> addEssay(ApplicationRequestDTO applicationRequestDTO) throws EssayTooLongException;

    String findApplications(String email);

    String openApplication(int Id);

    void deleteApplication(int Id);
}
