package com.example.marsgate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarsGateService implements ServiceInterface {

    @Autowired
    RepositoryInterface ar;

    public Application createApplication(Application application) throws TelTooLongException{
        if(application.getTelephone().length()>25) {
            throw new TelTooLongException();
        }
        if(application.getTelephone().equals("")) {
            application.setTelephone("no telephone number");
        }
        return ar.createApplication(application);
    }

    public Application addCV(Application application) throws UniTooLongException {
        if(application.getUniversity().length() > 100) {
            throw new UniTooLongException();
        }
        if(application.getUniversity().equals("")) {
            application.setUniversity("no degree entered");
        }
        return ar.addCV(application);
    }

    public Application addEssay(Application application) throws EssayTooLongException {
        if(application.getEssay().length() > 10) {
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
//        List<Application> results = ar.getApplications(firstname, lastname);
//        String allApplications = "";
//        for(Application application : results) {
//            allApplications += application.toString();
//            allApplications += "\r\n";
//        }
//        return allApplications;
    }

    public String findApplications(int Id) {
        Application application = ar.getApplicationById(Id);
        if(application.getUniversity() == null){
            return "ApplicationCV";
        } else if(application.getEssay() == null) {
            return "ApplicationEssay";
        } else {
            return "ApplicationNotModifiable";
        }
    }

    public Application findApplicationById(int Id) {
        return ar.getApplicationById(Id);
    }

    public void deleteApplication(int Id) {
        ar.deleteApplicationById(Id);
    }
}
