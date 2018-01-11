package com.jim.yeung.networthtracker;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.jim.yeung.networthtracker.filter.RequestFilter;
import com.jim.yeung.networthtracker.filter.ResponseFilter;
import com.jim.yeung.networthtracker.resource.NetWorthResource;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(NetWorthResource.class);
		register(RequestFilter.class);
		register(ResponseFilter.class);
	}

}
