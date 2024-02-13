package com.example.marsgate.service.impl;

import com.example.marsgate.entity.Application;
import com.example.marsgate.repository.RepositoryInterface;
import com.example.marsgate.requestdtos.ApplicationRequestDTO;
import com.example.marsgate.service.ServiceInterface;
import com.example.marsgate.service.exceptions.EssayTooLongException;
import com.example.marsgate.service.exceptions.TelTooLongException;
import com.example.marsgate.service.exceptions.UniTooLongException;
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

    public Optional<Application> createApplication(ApplicationRequestDTO application) throws TelTooLongException {
        Application application1 = applicationMapper.mapRequestToEntity(application);
        return ar.createApplication(application1);
    }

    public Optional<Application> addCV(Application application) throws UniTooLongException {
        if(application.getUniversity().length() > 100) {
            throw new UniTooLongException();
        }
        if(application.getUniversity().equals("")) {
            application.setUniversity("no degree entered");
        }
        return ar.addCV(application);
    }

    public Optional<Application> addEssay(Application application) throws EssayTooLongException {
        if(application.getEssay().length() > 1000) {
            throw new EssayTooLongException();
        }
        if(application.getEssay().equals("")) {
            application.setEssay("no essay added");
        }
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
