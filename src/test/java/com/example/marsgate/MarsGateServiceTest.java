package com.example.marsgate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarsGateServiceTest {

    @Autowired
    RepositoryInterface ar;

    Application testApplication = new Application("Sarah", "W", "0151", "sw@gmail.com");

    @Test
    public void testCreateApplicationCorrect() throws TelTooLongException {
        MarsGateService service = new MarsGateService();
        service.createApplication(testApplication);
        Application checkApplication = service.findApplicationById(1);
        assertEquals("W", checkApplication.getLastname());
    }

}