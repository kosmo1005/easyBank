package com.cool_company.easy_bank.exceptions;


public class WalletNotFoundException extends RuntimeException {
    private static final String NOT_FOUND_MESSAGE = "Wallet by given id not found";

    public WalletNotFoundException() {
        super(NOT_FOUND_MESSAGE);
    }
}
