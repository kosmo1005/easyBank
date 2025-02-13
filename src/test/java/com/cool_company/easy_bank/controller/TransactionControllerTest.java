package com.cool_company.easy_bank.controller;

import com.cool_company.easy_bank.controller.data_providers.TransactionProvider;
import com.cool_company.easy_bank.controller.transaction.impl.TransactionControllerImpl;
import com.cool_company.easy_bank.dto.transaction.TransactionReqDto;
import com.cool_company.easy_bank.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionControllerImpl.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    TransactionService svc;

    private static String BASE_URL;

    @BeforeAll
    static void setUp() {
        BASE_URL = "/api/v1/transaction";
    }

    @Test
    void processTransaction_thenReturn200Status() throws Exception {
        doNothing().when(svc).processTransaction(any(TransactionReqDto.class));

        mockMvc.perform(post(BASE_URL)
                        .content(objectMapper.writeValueAsString(TransactionProvider.getReqDto_1()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
