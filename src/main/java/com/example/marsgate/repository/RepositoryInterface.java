package com.example.marsgate.repository;

import com.example.marsgate.entity.Application;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface {

    Optional<Application> createApplication(Application application);

    Optional<Application> addCV(Application application);

    void addEssay(Application application);

    Optional<Application> getApplicationById(int Id);

    void deleteApplicationById(int Id);

    List<Application> getApplicationsByEmail(String email);
}
