package com.example.marsgate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarsGateService implements ServiceInterface {

    private final RepositoryInterface ar;

    @Autowired
    public MarsGateService(RepositoryInterface ar) {
        this.ar = ar;
    }

    public Optional<Application> createApplication(Application application) throws TelTooLongException{
        if(application.getTelephone().length()>25) {
            throw new TelTooLongException();
        }
        if(application.getTelephone().equals("")) {
            application.setTelephone("no telephone number");
        }
        return ar.createApplication(application);
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

//    public Optional<Application> findApplicationById(int Id) {
//        return ar.getApplicationById(Id);
//    }

    public void deleteApplication(int Id) {
        ar.deleteApplicationById(Id);
    }
}
