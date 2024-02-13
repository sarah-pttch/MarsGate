package com.example.marsgate.service.mappers;

import com.example.marsgate.entity.Application;
import com.example.marsgate.requestdtos.ApplicationRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {

    public Application mapRequestToEntity(ApplicationRequestDTO applicationRequestDTO) {
        Application application = new Application();
        application.setEmail(applicationRequestDTO.getEmail());
        application.setTelephone(applicationRequestDTO.getTelephone());
        application.setFirstname(applicationRequestDTO.getFirstname());
        application.setLastname(applicationRequestDTO.getLastname());
        application.setUniversity(applicationRequestDTO.getUniversity());
        application.setEssay(applicationRequestDTO.getEssay());
        application.setExperience(applicationRequestDTO.getExperience());
        application.setBirthdate(applicationRequestDTO.getBirthdate());
        return application;
    }

}
