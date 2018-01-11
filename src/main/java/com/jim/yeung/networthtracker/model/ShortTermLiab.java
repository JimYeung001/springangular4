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
public class ShortTermLiab implements Serializable {

	private static final long serialVersionUID = 1L;
	private double creditCard1;
	private double creditCard2;
	private double otherSTL;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shortTermLiab_seq")
	@SequenceGenerator(sequenceName = "shortTermLiab_seq", allocationSize = 1, name = "shortTermLiab_seq")
	private Long id;

	public ShortTermLiab() {

	}

	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;

	@PrePersist
	public void updateTotal() {
		setTotalAmount(getTotalAmount());
	}

	@Override
	public String toString() {
		return "ShortTermLiab [creditCard1=" + creditCard1 + ", creditCard2=" + creditCard2 + ", other=" + otherSTL
				+ ", id=" + id + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCreditCard1() {
		return creditCard1;
	}

	public void setCreditCard1(double creditCard1) {
		this.creditCard1 = creditCard1;
	}

	public double getCreditCard2() {
		return creditCard2;
	}

	public void setCreditCard2(double creditCard2) {
		this.creditCard2 = creditCard2;
	}

	public double getOtherSTL() {
		return otherSTL;
	}

	public void setOtherSTL(double other) {
		this.otherSTL = other;
	}

	public double getTotalAmount() {
		setTotalAmount(getCreditCard1() + getCreditCard2() + getOtherSTL());
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
