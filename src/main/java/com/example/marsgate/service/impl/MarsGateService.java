package com.example.marsgate.service.impl;

import com.example.marsgate.entity.Application;
import com.example.marsgate.repository.RepositoryInterface;
import com.example.marsgate.requestdtos.CvRequestDTO;
import com.example.marsgate.requestdtos.EssayRequestDTO;
import com.example.marsgate.requestdtos.PersonalDetailsRequestDTO;
import com.example.marsgate.service.ServiceInterface;
import com.example.marsgate.service.mappers.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarsGateService implements ServiceInterface {

    private final RepositoryInterface ar;
    private final ApplicationMapper applicationMapper;

    @Autowired
    public MarsGateService(RepositoryInterface ar, ApplicationMapper applicationMapper) {
        this.ar = ar;
        this.applicationMapper = applicationMapper;
    }

    public Optional<Application> createApplication(PersonalDetailsRequestDTO personalDetailsRequestDTO) {
        Application application = applicationMapper.mapPersonalDetailsToEntity(personalDetailsRequestDTO);
        return ar.createApplication(application);
    }

    public Optional<Application> addCV(CvRequestDTO cvRequestDTO) {
        Application application = applicationMapper.mapCvToEntity(cvRequestDTO);
        return ar.addCV(application);
    }

    public Optional<Application> addEssay(EssayRequestDTO essayRequestDTO) {
        Application application = applicationMapper.mapEssayToEntity(essayRequestDTO);
        ar.addEssay(application);
        return ar.getApplicationById(application.getId());
    }

    public String findApplications(String email) {
        return ar.getApplicationsByEmail(email).toString();
    }

    public String openApplication(int Id) {
        Optional<Application> application = ar.getApplicationById(Id);
        if(application.get().getUniversity() == null){
            return "ApplicationCV";
        } else if(application.get().getEssay() == null) {
            return "ApplicationEssay";
        } else {
            return "ApplicationNotModifiable";
        }
    }

    public void deleteApplication(int Id) {
        ar.deleteApplicationById(Id);
    }
}
