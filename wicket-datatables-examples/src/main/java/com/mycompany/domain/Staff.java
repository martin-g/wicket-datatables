package com.mycompany.domain;

import java.io.Serializable;

public class Staff implements Serializable {

	private String firstname;

	private String lastname;

	private Dossier hr;

	private String office;

	private String email;

	public Staff(String firstname, String lastname, Dossier hr) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.hr = hr;
	}

	public Staff(String firstName, String lastName, Dossier dossier,
			String office, String email) {
		this.firstname = firstName;
		this.lastname = lastName;
		this.hr = dossier;
		this.office = office;
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Dossier getHr() {
		return hr;
	}

	public String getOffice() {
		return office;
	}

	public String getEmail() {
		return email;
	}
}