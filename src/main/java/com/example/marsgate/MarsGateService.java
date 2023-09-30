package com.example.marsgate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarsGateService {

    @Autowired
    ApplicationRepository ar;

    public Application createApplication(Application application) {
        return ar.createApplication(application);
    }

    public Application addPersonalDetails(Application application) {
        return ar.addApplicationPersonalDetails(application);
    }

    public Application addEssay(Application application) {
        ar.addApplicationEssay(application);
        return ar.getApplicationById(application.getId());
    }

    public String findApplications(String firstname, String lastname) {
//        return ar.getApplications(firstname, lastname);
        List<Application> results = ar.getApplications(firstname, lastname);
        String allApplications = "";
        for(Application application : results) {
            allApplications += application.toString();
            allApplications += "\r\n";
        }
        return allApplications;
    }

    public void deleteApplication(int Id) {
        ar.deleteApplicationById(Id);
    }
}
