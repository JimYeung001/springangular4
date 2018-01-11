package com.jim.yeung.networthtracker;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jim.yeung.networthtracker.model.NetWorth;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ResourceTest {

	private Client client = ClientBuilder.newClient();

	private String baseUrl = "http://localhost:8888/webapi/networth";
	private WebTarget baseTarget = client.target(baseUrl);
	private WebTarget netWorthTarget = baseTarget.path("{id}");

	@Autowired
	private TestRestTemplate restTemplate;
	
	 @Test
	public void fetchResourceById() {
//		WebTarget resolveTemplate = netWorthTarget.resolveTemplate("id", 1L);
//		NetWorth netWorth = resolveTemplate.request(MediaType.APPLICATION_JSON).get(NetWorth.class);
		// NetWorth netWorth = netWorthTarget.resolveTemplate("id",
		// 1L).request(MediaType.APPLICATION_JSON).get(NetWorth.class);
		 
		ResponseEntity<NetWorth> netWorth = this.restTemplate.getForEntity("/networth/1",NetWorth.class);
		System.out.println("Test new worth with id 1: \n");
		System.out.println(netWorth.toString());
		assertNotNull(netWorth);
	}

//	@Test
	public void templateTestGet() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
//		ResponseEntity<List<NetWorth>> response = testRestTemplate.getForEntity("/1", List.class);
//		System.out.println(response.getBody().toString());
//		assertTrue(response.getStatusCode().equals(HttpStatus.OK));

	}

}
