package com.jim.yeung.networthtracker;

import static org.junit.Assert.assertTrue;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jim.yeung.networthtracker.model.NetWorth;

public class ResourceTestMain {

	public static void main(String[] args) {

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<NetWorth> response = testRestTemplate.getForEntity("http://localhost:8888/webapi/networth/1",
				NetWorth.class);
		System.out.println(response.getBody().toString());
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));

	}

}
