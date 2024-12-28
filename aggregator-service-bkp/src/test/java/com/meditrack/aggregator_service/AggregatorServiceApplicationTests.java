package com.meditrack.aggregator_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.meditrack.aggregator_service.service.RedshiftService;

@SpringBootTest
class AggregatorServiceApplicationTests {

    @SuppressWarnings("removal")
	@MockBean
    private MongoTemplate mongoTemplate;

	@SuppressWarnings("removal")
    @MockBean
    private RedshiftService redshiftService;

	@Test
	void contextLoads() {
	}

}
