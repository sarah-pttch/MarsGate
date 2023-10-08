package com.example.marsgate;

import java.util.List;

public interface RepositoryInterface {

    Application createApplication(Application application);

    Application addCV(Application application);

    void addEssay(Application application);

    Application getApplicationById(int Id);

    void deleteApplicationById(int Id);

    List<Application> getApplicationsByEmail(String email);
}
