package com.jim.yeung.networthtracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import org.springframework.test.context.junit4.SpringRunner;

import com.jim.yeung.networthtracker.model.CashAndInvestments;
import com.jim.yeung.networthtracker.model.LongTermAssets;
import com.jim.yeung.networthtracker.model.LongTermDebt;
import com.jim.yeung.networthtracker.model.NetWorth;
import com.jim.yeung.networthtracker.model.ShortTermLiab;
import com.jim.yeung.networthtracker.resource.NetWorthResource;
import com.jim.yeung.networthtracker.service.NetWorthService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class NetworthtrackerApplicationTests {

	@Autowired
	private NetWorthResource netWorthResource;

	@Autowired
	private NetWorthService netWorthService;

		
//	@Test
	public void contextLoads() {
		/*
		 * Message message = messageTarget.resolveTemplate("messageId",
		 * "1").request(MediaType.APPLICATION_JSON) .get(Message.class);
		 * 
		 * Message newMsg = new Message(3, "This is message number 3", "Jim Yeungjj");
		 * 
		 * Response postRs = messagesTarget.request().post(Entity.json(newMsg)); if
		 * (postRs.getStatus() != 201) { System.out.println("Error: Post failled"); }
		 * else { Message readEntity = postRs.readEntity(Message.class);
		 * System.out.println(readEntity.getMessage()); }
		 */
	}

	 @Test
	public void saveTest() {
		for (int i = 0; i < 3; i++) {
			NetWorth netWorth = new NetWorth();
			CashAndInvestments cai = new CashAndInvestments();
			LongTermAssets lta = new LongTermAssets();

			cai.setInvestment1(2000.00 + i * 20.00);
			cai.setInvestment2(5020.00);
			cai.setInvestment3(5030.00);
			cai.setInvestment4(50400.00 + i * 20.00);
			cai.setInvestment5(5050.00);
			cai.setChequing(190.00);
			cai.setRainyDayFund(20.01);
			cai.setSavingsForFun(22.01);
			cai.setSavingsForPD(2300.44 + i * 10.00);
			cai.setSavingsForTaxes(12.11);
			cai.setSavingsForTravel(13.44);

			lta.setOtherLTA(00.00);
			lta.setPrimaryHome(123.33 + i * 120.00);
			lta.setSecondHome(123400.99 + i * 20.00);

			netWorth.setCashAndInvestments(cai);
			netWorth.setLongTermAssets(lta);

			LongTermDebt longTermDebt = new LongTermDebt();
			ShortTermLiab shortTermLiab = new ShortTermLiab();

			longTermDebt.setCarLoan(12322.00);
			longTermDebt.setInvestmentLoan(12340.99 + i * 26.00);
			longTermDebt.setLineOfCredit(122.99);
			longTermDebt.setMortgage1(123.00);
			longTermDebt.setMortgage2(0);
			longTermDebt.setStudentLoan(0);

			shortTermLiab.setCreditCard1(44320.00 + i * 70.00);
			shortTermLiab.setCreditCard2(230.34 + i * 20.00);
			shortTermLiab.setOtherSTL(0);

			netWorth.setLongTermDebt(longTermDebt);
			netWorth.setShortTermLiab(shortTermLiab);

			getNetWorthService().saveNetWorth(netWorth);
		}
	}

	// @Test
	public void testGetALL() {
		List<NetWorth> allNetWorth = getNetWorthService().findAll();
		System.out.println("TESTOUT\n");
		System.out.println(allNetWorth.get(0).toString());
		assertEquals(5, allNetWorth.size());
	}
	
//	@Test
	public void testFindOne() {
		NetWorth netWorth = getNetWorthService().findOne(1L);
		System.out.println("TESTOUT find one: \n");
		System.out.println(netWorth.toString());
		assertNotNull(netWorth);
	}
	
//	@Test
	public void updateOne() {
		NetWorth netWorth = getNetWorthService().findOne(7L);
		netWorth.getLongTermDebt().setStudentLoan(3000L);
		NetWorth saveNetWorth = getNetWorthService().updateNetWorth(netWorth);
		System.out.println("TESTOUT student loan: \n");
		System.out.println(saveNetWorth.getLongTermDebt().getStudentLoan());
		assertNotNull(saveNetWorth);
	}
	
	
	
	

	public NetWorthResource getNetWorthResource() {
		return netWorthResource;
	}

	public NetWorthService getNetWorthService() {
		return netWorthService;
	}

}
