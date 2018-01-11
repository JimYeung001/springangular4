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
public class LongTermDebt implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "longTermDebt_seq")
	@SequenceGenerator(sequenceName = "longTermDebt_seq", allocationSize = 1, name = "longTermDebt_seq")
	private Long id;

	private double mortgage1;
	private double mortgage2;
	private double lineOfCredit;
	private double investmentLoan;
	private double studentLoan;
	private double carLoan;

	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;

	public LongTermDebt() {

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

	public double getMortgage1() {
		return mortgage1;
	}

	public void setMortgage1(double mortgage1) {
		this.mortgage1 = mortgage1;
	}

	public double getMortgage2() {
		return mortgage2;
	}

	public void setMortgage2(double mortgage2) {
		this.mortgage2 = mortgage2;
	}

	public double getLineOfCredit() {
		return lineOfCredit;
	}

	public void setLineOfCredit(double lineOfCredit) {
		this.lineOfCredit = lineOfCredit;
	}

	public double getInvestmentLoan() {
		return investmentLoan;
	}

	public void setInvestmentLoan(double investmentLoan) {
		this.investmentLoan = investmentLoan;
	}

	public double getStudentLoan() {
		return studentLoan;
	}

	public void setStudentLoan(double studentLoan) {
		this.studentLoan = studentLoan;
	}

	public double getCarLoan() {
		return carLoan;
	}

	public void setCarLoan(double carLoan) {
		this.carLoan = carLoan;
	}

	public double getTotalAmount() {
		setTotalAmount(getMortgage1() + getMortgage2() + getLineOfCredit() + getInvestmentLoan() + getStudentLoan()
				+ getCarLoan());
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "LongTermDebt [id=" + id + ", mortgage1=" + mortgage1 + ", mortgage2=" + mortgage2 + ", lineOfCredit="
				+ lineOfCredit + ", investmentLoan=" + investmentLoan + ", studentLoan=" + studentLoan + ", carLoan="
				+ carLoan + "]";
	}

}
