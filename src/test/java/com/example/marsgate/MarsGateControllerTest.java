package com.example.marsgate;

import com.example.marsgate.controller.MarsGateController;
import com.example.marsgate.service.ServiceInterface;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MarsGateController.class)
class MarsGateControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ServiceInterface service;

//    @Test
//    public void openApplicationPD_whenCalled_thenVerifyControllerReturnsOk() throws Exception {
//        mvc.perform(
//                MockMvcRequestBuilders.get("/ApplicationPersonalDetails")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }

}