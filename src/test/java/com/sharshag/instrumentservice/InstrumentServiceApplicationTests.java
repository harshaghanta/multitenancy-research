package com.sharshag.instrumentservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestContainerConfig.class)
class InstrumentServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
