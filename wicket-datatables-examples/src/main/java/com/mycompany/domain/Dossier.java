package com.mycompany.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Dossier {

	private String position;

	private BigDecimal salary;

	private Date startDate;

	private int age;

	public Dossier(String position, BigDecimal salary, Date startDate, int age) {
		super();
		this.position = position;
		this.salary = salary;
		this.startDate = startDate;
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public int getAge() {
		return age;
	}

}