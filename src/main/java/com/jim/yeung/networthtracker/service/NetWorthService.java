package com.jim.yeung.networthtracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jim.yeung.networthtracker.model.NetWorth;
import com.jim.yeung.networthtracker.repository.NetWorthRepository;

@Service
public class NetWorthService {

	@Autowired
	private NetWorthRepository netWorthRepository;

	@Autowired
	private CacheManager cacheManager;

	@Transactional
	public NetWorth saveNetWorth(NetWorth netWorth) {
		return getNetWorthRepository().save(netWorth);
	}

	@Transactional
	public NetWorth updateNetWorth(NetWorth netWorth) {
		freshTotal(netWorth);
		getCacheManager().getCacheNames().parallelStream().forEach(name -> getCacheManager().getCache(name).clear());
		return getNetWorthRepository().save(netWorth);
	}

	@Transactional
	@Cacheable("singleNetWorth")
	public NetWorth findOne(Long id) {
		return getNetWorthRepository().findOne(id);
	}

	@Transactional
	@Cacheable("allNetWorth")
	public List<NetWorth> findAll() {
		return getNetWorthRepository().findAll();
	}

	private void freshTotal(NetWorth netWorth) {
		netWorth.getLongTermAssets().updateTotal();
		netWorth.getLongTermDebt().updateTotal();
		netWorth.getShortTermLiab().updateTotal();
		netWorth.getCashAndInvestments().updateTotal();
		netWorth.updateTotal();
	}

	public NetWorthRepository getNetWorthRepository() {
		return netWorthRepository;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

}
