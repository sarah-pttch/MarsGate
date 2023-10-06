package com.example.marsgate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarsGateService {

    @Autowired
    ApplicationRepository ar;

    public Application createApplication(Application application) throws TelTooLongException{
        if(application.getTelephone().length()>25) {
            throw new TelTooLongException();
        }
        if(application.getTelephone().equals("")) {
            application.setTelephone("no telephone number entered");
        }
        return ar.createApplication(application);
    }

    public Application addCV(Application application) {
        if(application.getUniversity().equals("")) {
            application.setUniversity("no degree entered");
        }
        return ar.addApplicationCV(application);
    }

    public Application addEssay(Application application) throws EssayTooLongException {
        if(application.getEssay().length() > 10) {
            throw new EssayTooLongException();
        }
        if(application.getEssay().equals("")) {
            application.setEssay("no essay added");
        }
        ar.addApplicationEssay(application);
        return ar.getApplicationById(application.getId());
    }

    public List<Application> findApplications(String email) {
        return ar.getApplications(email);
//        List<Application> results = ar.getApplications(firstname, lastname);
//        String allApplications = "";
//        for(Application application : results) {
//            allApplications += application.toString();
//            allApplications += "\r\n";
//        }
//        return allApplications;
    }

    public void deleteApplication(int Id) {
        ar.deleteApplicationById(Id);
    }
}
