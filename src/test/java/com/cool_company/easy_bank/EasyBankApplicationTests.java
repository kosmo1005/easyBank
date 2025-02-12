package com.cool_company.easy_bank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class EasyBankApplicationTests {

	@Test
	void contextLoads() {
	}

}
