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
public class LongTermAssets implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "longTermAssets_seq")
	@SequenceGenerator(sequenceName = "longTermAssets_seq", allocationSize = 1, name = "longTermAssets_seq")
	private Long id;

	private double primaryHome;
	private double secondHome;
	private double otherLTA;

	@Column(name = "TOTAL_AMOUNT")
	private double totalAmount;

	public LongTermAssets() {

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

	public double getPrimaryHome() {
		return primaryHome;
	}

	public void setPrimaryHome(double primaryHome) {
		this.primaryHome = primaryHome;
	}

	public double getSecondHome() {
		return secondHome;
	}

	public void setSecondHome(double secondHome) {
		this.secondHome = secondHome;
	}

	public double getOtherLTA() {
		return otherLTA;
	}

	public void setOtherLTA(double other) {
		this.otherLTA = other;
	}

	public double getTotalAmount() {
		setTotalAmount(getPrimaryHome() + getSecondHome() + getOtherLTA());
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "LongTermAssets [id=" + id + ", primaryHome=" + primaryHome + ", secondHome=" + secondHome + ", other="
				+ otherLTA + "]";
	}

}
