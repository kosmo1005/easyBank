package com.cool_company.easy_bank;

import org.springframework.boot.SpringApplication;

public class TestEasyBankApplication {

	public static void main(String[] args) {
		SpringApplication.from(EasyBankApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
