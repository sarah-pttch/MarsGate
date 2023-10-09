package com.example.marsgate;

public interface ServiceInterface {

    Application createApplication(Application application) throws TelTooLongException;

    Application addCV(Application application) throws UniTooLongException;

    Application addEssay(Application application) throws EssayTooLongException;

    String findApplications(String email);

    String findApplications(int Id);

    void deleteApplication(int Id);
}
