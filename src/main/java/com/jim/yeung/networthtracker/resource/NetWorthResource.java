package com.jim.yeung.networthtracker.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jim.yeung.networthtracker.model.NetWorth;
import com.jim.yeung.networthtracker.service.NetWorthService;

@RestController
@Path("/networths")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NetWorthResource {

	@Autowired
	private NetWorthService netWorthService;

	@GET
	@Path("/{id}")
	@RolesAllowed("ADMIN")	
	public NetWorth getNetWorthById(@PathParam("id") long id) {
		return getNetWorthService().findOne(id);
	}

	@GET
	@RolesAllowed("ADMIN")
	public List<NetWorth> getFindAll() {
		return getNetWorthService().findAll();
	}

	@POST
	@RolesAllowed("ADMIN")
	public NetWorth addNetWorth(NetWorth netWorth) {
		return getNetWorthService().saveNetWorth(netWorth);
	}
	
	@PUT
	@Path("/{id}")
	@RolesAllowed("ADMIN")
	public NetWorth updateNetWorth(NetWorth netWorth) {
		return getNetWorthService().updateNetWorth(netWorth);
	}

	public NetWorthService getNetWorthService() {
		return netWorthService;
	}

}
