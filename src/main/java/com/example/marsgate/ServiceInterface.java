package com.example.marsgate;

import java.util.Optional;

public interface ServiceInterface {

    Optional<Application> createApplication(Application application) throws TelTooLongException;

    Optional<Application> addCV(Application application) throws UniTooLongException;

    Optional<Application> addEssay(Application application) throws EssayTooLongException;

    String findApplications(String email);

    String openApplication(int Id);

    void deleteApplication(int Id);
}
