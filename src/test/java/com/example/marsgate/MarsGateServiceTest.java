package com.example.marsgate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class MarsGateServiceTest {

    @Autowired
    Application application;

    @Test
    public void testCreateApplicationCorrect(){
        MarsGateService service = new MarsGateService();
        service.createApplication(application);

    }

}