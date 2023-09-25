package com.example.marsgate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
