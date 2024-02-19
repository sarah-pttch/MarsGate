package com.example.marsgate.service.mappers;

import com.example.marsgate.entity.Application;
import com.example.marsgate.requestdtos.ApplicationRequestDTO;
import com.example.marsgate.requestdtos.CvRequestDTO;
import com.example.marsgate.requestdtos.EssayRequestDTO;
import com.example.marsgate.requestdtos.PersonalDetailsRequestDTO;
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

    public Application mapPersonalDetailsToEntity(PersonalDetailsRequestDTO personalDetailsRequestDTO) {
        Application application = new Application();
        application.setFirstname(personalDetailsRequestDTO.getFirstname());
        application.setLastname(personalDetailsRequestDTO.getLastname());
        application.setEmail(personalDetailsRequestDTO.getEmail());
        application.setTelephone(personalDetailsRequestDTO.getTelephone());
        return application;
    }

    public Application mapCvToEntity(CvRequestDTO cvRequestDTO) {
        Application application = new Application();
        application.setId(cvRequestDTO.getId());
        application.setBirthdate(cvRequestDTO.getBirthdate());
        application.setExperience(cvRequestDTO.getExperience());
        application.setUniversity(cvRequestDTO.getUniversity());
        return application;
    }

    public Application mapEssayToEntity(EssayRequestDTO essayRequestDTO) {
        Application application = new Application();
        application.setId(essayRequestDTO.getId());
        application.setEssay(essayRequestDTO.getEssay());
        return application;
    }

}
