package com.example.marsgate.repository.impl;

import Logs.Log;
import com.example.marsgate.entity.Application;
import com.example.marsgate.repository.RepositoryInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ApplicationRepository implements RepositoryInterface {

    @PersistenceContext
    EntityManager em;

    public Optional<Application> createApplication(Application application) {
        try {
        return Optional.of(em.merge(application));
        } catch (Exception e) {
            Log.error("Failed to create application");
            return Optional.empty();
        }
    }

    public Optional<Application> addCV (Application application) {
        Query updateCV = em.createNamedQuery("updateCV");
        updateCV.setParameter("experience", application.getExperience());
        updateCV.setParameter("university", application.getUniversity());
        updateCV.setParameter("birthdate", application.getBirthdate());
        updateCV.setParameter("Id", application.getId());
        updateCV.executeUpdate();
        return getApplicationById(application.getId());
    }

    public void addEssay (Application application) {
        Query updateEssay = em.createNamedQuery("updateEssay");
        updateEssay.setParameter("essay", application.getEssay());
        updateEssay.setParameter("Id", application.getId());
        updateEssay.executeUpdate();
    }

    public Optional<Application> getApplicationById(int id) {
        return Optional.of(em.find(Application.class, id));
    }

    public void deleteApplicationById(int id) {
        Application application = em.find(Application.class, id);
        em.remove(application);
    }

    public List<Application> getApplicationsByEmail(String email) {
        TypedQuery<Application> getAppByEmail = em.createNamedQuery("findapplications", Application.class);
        getAppByEmail.setParameter("email", email);
        return getAppByEmail.getResultList();
    }

}
