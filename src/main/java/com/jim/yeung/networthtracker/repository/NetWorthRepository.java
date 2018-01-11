package com.jim.yeung.networthtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jim.yeung.networthtracker.model.NetWorth;

public interface NetWorthRepository extends JpaRepository<NetWorth, Long> {

}
