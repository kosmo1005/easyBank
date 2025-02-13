package com.cool_company.easy_bank.controller;

import com.cool_company.easy_bank.controller.data_providers.WalletProvider;
import com.cool_company.easy_bank.controller.wallet.impl.WalletControllerImpl;
import com.cool_company.easy_bank.exceptions.WalletNotFoundException;
import com.cool_company.easy_bank.service.WalletService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WalletControllerImpl.class)
public class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    WalletService svc;

    private static String BASE_URL;
    private static String walletId;

    @BeforeAll
    static void setUp() {
        BASE_URL = "/api/v1/wallet";
        walletId = WalletProvider.WALLET_ID.toString();
    }

    @Test
    void addNewWallet_thenReturn200Status() throws Exception {
        when(svc.addNewWallet())
                .thenReturn(WalletProvider.getWalletRespDto_1());

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void addNewWallet_thenReturn500Status() throws Exception {
        when(svc.addNewWallet())
                .thenThrow(new RuntimeException("Internal server error occurred"));

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.errorMessage").value("Internal server error occurred"));
    }

    @Test
    void getTotalAmount_thenReturn200Status() throws Exception {
        when(svc.getTotalAmount(any(UUID.class)))
                .thenReturn(WalletProvider.getWalletRespDto_1());

        mockMvc.perform(get(BASE_URL + "/" + walletId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getTotalAmount_thenReturn404Status() throws Exception {
        when(svc.getTotalAmount(any(UUID.class)))
                .thenThrow(new WalletNotFoundException());

        mockMvc.perform(get(BASE_URL + "/" + walletId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorMessage").value("Wallet by given id not found"));
    }

    @Test
    void getTotalAmount_thenReturn500Status() throws Exception {
        when(svc.getTotalAmount(any(UUID.class)))
                .thenThrow(new RuntimeException("Internal server error occurred"));

        mockMvc.perform(get(BASE_URL + "/" + walletId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.errorMessage").value("Internal server error occurred"));
    }
}
