package com.example.marsgate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//TODO: If you want to run an e2e test then you need to start a in memory db when running these tests.
//Types of tests. Unit, integration and e2e tests.
@ExtendWith(MockitoExtension.class)
public class MarsGateServiceTest {

    @Mock
    RepositoryInterface ar;
    @InjectMocks
    MarsGateService marsGateService;

//    @BeforeEach
//    void setUp() {
//        marsGateService = new MarsGateService(ar);
//    }

    @Test
    public void testCreateApplication_Correct() throws TelTooLongException {
        Application application = new Application("Sarah", "W", "", "sw@gmail.com");
        when(ar.createApplication(application)).thenReturn(Optional.of(application));
        Optional<Application> optionalApplication = marsGateService.createApplication(application);
        assertTrue(optionalApplication.isPresent());
        assertEquals("no telephone number", optionalApplication.get().getTelephone());
    }

    @Test
    public void testAddCV_Correct() throws UniTooLongException {
        Application application = new Application(new Date(1988-02-12), 9, "");
        when(ar.addCV(application)).thenReturn(Optional.of(application));
        Optional<Application> optionalApplication = marsGateService.addCV(application);
        assertTrue(optionalApplication.isPresent());
        assertEquals("no degree entered", optionalApplication.get().getUniversity());
    }

    @Test
    public void testAddEssay_Correct() throws EssayTooLongException {
        Application application = new Application("");
        when(ar.getApplicationById(application.getId())).thenReturn(Optional.of(application));
        Optional<Application> optionalApplication = marsGateService.addEssay(application);
        assertTrue(optionalApplication.isPresent());
        assertEquals("no essay added", optionalApplication.get().getEssay());
    }

    @Test
    public void testFindApplications_Correct() {
        when(ar.getApplicationsByEmail("sw@gmail.com")).thenReturn(Collections.emptyList());
        assertEquals("[]", marsGateService.findApplications("sw@gmail.com"));
    }

    @Test
    public void testOpenApplication_Correct() {
        Application application = new Application(new Date(1988-02-12), 9, null);
        when(ar.getApplicationById(1)).thenReturn(Optional.of(application));
        assertEquals("ApplicationCV", marsGateService.openApplication(1));
    }
}