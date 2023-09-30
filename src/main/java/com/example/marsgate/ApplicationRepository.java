package com.example.marsgate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ApplicationRepository {

    @PersistenceContext
    EntityManager em;

    public Application createApplication(Application application) {
        return em.merge(application);
    }

    public Application addApplicationCV (Application application) {
        Query updateCV = em.createNamedQuery("updateCV");
        updateCV.setParameter("experience", application.getExperience());
        updateCV.setParameter("university", application.getUniversity());
        updateCV.setParameter("birthdate", application.getBirthdate());
        updateCV.setParameter("Id", application.getId());
        updateCV.executeUpdate();
        return getApplicationById(application.getId());
    }

    public void addApplicationEssay (Application application) {
        Query updateEssay = em.createNamedQuery("updateEssay");
        updateEssay.setParameter("essay", application.getEssay());
        updateEssay.setParameter("Id", application.getId());
        updateEssay.executeUpdate();
    }

    public Application getApplicationById(int id) {
        return em.find(Application.class, id);
    }

    public void deleteApplicationById(int id) {
        Application application = em.find(Application.class, id);
        em.remove(application);
    }

    public List<Application> getApplications(String firstname, String lastname) {
        TypedQuery<Application> getAppByFnLn = em.createNamedQuery("findapplications", Application.class);
        getAppByFnLn.setParameter("firstname", firstname);
        getAppByFnLn.setParameter("lastname", lastname);
        return getAppByFnLn.getResultList();
    }

}