package com.jim.yeung.networthtracker.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

@Entity
public class NetWorth implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "netWorth_seq")
	@SequenceGenerator(sequenceName = "netWorth_seq", allocationSize = 1, name = "netWorth_seq")
	private Long id;

	private double totalAssets;
	private double totalLiabilities;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CashAndInvestments cashAndInvestments;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private LongTermAssets longTermAssets;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ShortTermLiab shortTermLiab;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private LongTermDebt longTermDebt;

	private double netWorth;

	/**
	 * Default constructor
	 */
	public NetWorth() {

	}

	@PrePersist
	public void updateTotal() {
		setTotalAssets(getCashAndInvestments().getTotalAmount() + getLongTermAssets().getTotalAmount());
		setTotalLiabilities(getShortTermLiab().getTotalAmount() + getLongTermDebt().getTotalAmount());
		setNetWorth(getTotalAssets() - getTotalLiabilities());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotalLiabilities() {
		return totalLiabilities;
	}

	public void setTotalLiabilities(double totalLiabilities) {
		this.totalLiabilities = totalLiabilities;
	}

	public double getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(double totalAssets) {
		this.totalAssets = totalAssets;
	}

	public LongTermAssets getLongTermAssets() {
		return longTermAssets;
	}

	public void setLongTermAssets(LongTermAssets longTermAssets) {
		this.longTermAssets = longTermAssets;
	}

	public CashAndInvestments getCashAndInvestments() {
		return cashAndInvestments;
	}

	public void setCashAndInvestments(CashAndInvestments cashAndInvestments) {
		this.cashAndInvestments = cashAndInvestments;
	}

	public ShortTermLiab getShortTermLiab() {
		return shortTermLiab;
	}

	public void setShortTermLiab(ShortTermLiab shortTermLiab) {
		this.shortTermLiab = shortTermLiab;
	}

	public LongTermDebt getLongTermDebt() {
		return longTermDebt;
	}

	public void setLongTermDebt(LongTermDebt longTermDebt) {
		this.longTermDebt = longTermDebt;
	}

	public double getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(double netWorth) {
		this.netWorth = netWorth;
	}

	@Override
	public String toString() {
		return "NetWorth [id=" + id + ", totalAssets=" + totalAssets + ", totalLiabilities=" + totalLiabilities
				+ ", cashAndInvestments=" + cashAndInvestments + ", longTermAssets=" + longTermAssets
				+ ", shortTermLiab=" + shortTermLiab + ", longTermDebt=" + longTermDebt + ", netWorth=" + netWorth
				+ "]";
	}

}
