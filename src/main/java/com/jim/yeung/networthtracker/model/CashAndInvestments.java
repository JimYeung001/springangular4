package com.jim.yeung.networthtracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;

@Entity
public class CashAndInvestments implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cashAndInvestAssets_seq")
	@SequenceGenerator(sequenceName = "cashAndInvestAssets_seq", allocationSize = 1, name = "cashAndInvestAssets_seq")
	private Long id;

	private double chequing;
	private double savingsForTaxes;
	private double rainyDayFund;
	private double savingsForFun;
	private double savingsForTravel;
	private double savingsForPD;
	private double Investment1;
	private double Investment2;
	private double Investment3;
	private double Investment4;
	private double Investment5;

	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;

	public CashAndInvestments() {

	}

	@PrePersist
	public void updateTotal() {
		setTotalAmount(getTotalAmount());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getChequing() {
		return chequing;
	}

	public void setChequing(double chequing) {
		this.chequing = chequing;
	}

	public double getSavingsForTaxes() {
		return savingsForTaxes;
	}

	public void setSavingsForTaxes(double savingsForTaxes) {
		this.savingsForTaxes = savingsForTaxes;
	}

	public double getRainyDayFund() {
		return rainyDayFund;
	}

	public void setRainyDayFund(double rainyDayFund) {
		this.rainyDayFund = rainyDayFund;
	}

	public double getSavingsForFun() {
		return savingsForFun;
	}

	public void setSavingsForFun(double savingsForFun) {
		this.savingsForFun = savingsForFun;
	}

	public double getSavingsForTravel() {
		return savingsForTravel;
	}

	public void setSavingsForTravel(double savingsForTravel) {
		this.savingsForTravel = savingsForTravel;
	}

	public double getInvestment1() {
		return Investment1;
	}

	public void setInvestment1(double investment1) {
		Investment1 = investment1;
	}

	public double getInvestment2() {
		return Investment2;
	}

	public void setInvestment2(double investment2) {
		Investment2 = investment2;
	}

	public double getInvestment3() {
		return Investment3;
	}

	public void setInvestment3(double investment3) {
		Investment3 = investment3;
	}

	public double getInvestment4() {
		return Investment4;
	}

	public void setInvestment4(double investment4) {
		Investment4 = investment4;
	}

	public double getInvestment5() {
		return Investment5;
	}

	public void setInvestment5(double investment5) {
		Investment5 = investment5;
	}

	public double getSavingsForPD() {
		return savingsForPD;
	}

	public void setSavingsForPD(double savingsForPD) {
		this.savingsForPD = savingsForPD;
	}

	public double getTotalAmount() {
		setTotalAmount(getChequing() + getSavingsForTaxes() + getRainyDayFund() + getSavingsForFun()
				+ getSavingsForTravel() + getSavingsForPD() + getInvestment1() + getInvestment2() + getInvestment3()
				+ getInvestment4() + getInvestment5());
		return this.totalAmount;

	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "CashAndInvestments [id=" + id + ", chequing=" + chequing + ", savingsForTaxes=" + savingsForTaxes
				+ ", rainyDayFund=" + rainyDayFund + ", savingsForFun=" + savingsForFun + ", savingsForTravel="
				+ savingsForTravel + ", savingsForPD=" + savingsForPD + ", Investment1=" + Investment1
				+ ", Investment2=" + Investment2 + ", Investment3=" + Investment3 + ", Investment4=" + Investment4
				+ ", Investment5=" + Investment5 + "]";
	}

}
