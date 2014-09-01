package eu.schulteweb.wicket.datatables.examples.general.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mycompany.domain.Dossier;
import com.mycompany.domain.Staff;

public class StaffService {

	private static final StaffService instance;

	static {
		instance = new StaffService();
	}

	private StaffService() {

	}

	public List<Staff> findStaff() {
		List<Staff> staff = new ArrayList<Staff>();

		staff.add(newStaff("Tiger", "Nixon", "System Architect",
				new BigDecimal("320800"), new Date(), "Edinburgh", 31,
				"info@datatables.net"));
		staff.add(newStaff("Garrett", "Winters", "Accountant", new BigDecimal(
				"220800"), new Date(), "Tokyo", 32, "info@datatables.net"));
		staff.add(newStaff("Ashton", "Cox", "Junior Technical Author",
				new BigDecimal("86000"), new Date(), "San Francisco", 31,
				"info@datatables.net"));
		staff.add(newStaff("Kelly", "Cedric", "Senior Javascript Developer",
				new BigDecimal("433800"), new Date(), "Edinburgh", 31,
				"info@datatables.net"));
		staff.add(newStaff("Satou", "Airi", "Accountant", new BigDecimal(
				"162800"), new Date(), "Tokyo", 31, "info@datatables.net"));
		staff.add(newStaff("Brielle", "Williamson", "Integration Specialist",
				new BigDecimal("372800"), new Date(), "New York", 31,
				"info@datatables.net"));
		staff.add(newStaff("Herrod", "Chandler", "Sales Assistant",
				new BigDecimal("137000"), new Date(), "San Francisco", 31,
				"info@datatables.net"));
		staff.add(newStaff("Rhona", "Davidson", "Integration Specialist",
				new BigDecimal("327800"), new Date(), "Tokyo", 31,
				"info@datatables.net"));
		staff.add(newStaff("Colleen", "Hurst", "Javascript Developer",
				new BigDecimal("205000"), new Date(), "San Francisco", 31,
				"info@datatables.net"));
		staff.add(newStaff("Sonya", "Frost", "Software Engineer",
				new BigDecimal("103000"), new Date(), "Edinburgh", 31,
				"info@datatables.net"));
		staff.add(newStaff("Jena", "Gaines", "Office Manager", new BigDecimal(
				"90000"), new Date(), "London", 31, "info@datatables.net"));
		staff.add(newStaff("Flynn", "Quinn", "Support Lead", new BigDecimal(
				"342000"), new Date(), "Edinburgh", 31, "info@datatables.net"));
		staff.add(newStaff("Charde", "Marshall", "Regional Director",
				new BigDecimal("470800"), new Date(), "San Francisco", 31,
				"info@datatables.net"));
		staff.add(newStaff("Haley", "Kennedy", "Senior Marketing Designer",
				new BigDecimal("313000"), new Date(), "London", 31,
				"info@datatables.net"));
		staff.add(newStaff("Tatyana", "Fitzpatrick", "Regional Director",
				new BigDecimal("385800"), new Date(), "London", 31,
				"info@datatables.net"));
		staff.add(newStaff("Michael", "Silva", "Marketing Designer",
				new BigDecimal("198000"), new Date(), "London", 31,
				"info@datatables.net"));
		staff.add(newStaff("Paul", "Byrd", "Chief Financial Officer (CFO)",
				new BigDecimal("725"), new Date(), "New York", 31,
				"info@datatables.net"));
		staff.add(newStaff("Gloria", "Little", "Systems Administrator",
				new BigDecimal("237800"), new Date(), "New York", 31,
				"info@datatables.net"));
		staff.add(newStaff("Bradley", "Greer", "Software Engineer",
				new BigDecimal("132800"), new Date(), "London", 31,
				"info@datatables.net"));
		staff.add(newStaff("Dai", "Rios", "Personnel Lead", new BigDecimal(
				"217800"), new Date(), "Edinburgh", 31, "info@datatables.net"));
		staff.add(newStaff("Jenette", "Caldwell", "Development Lead",
				new BigDecimal("345800"), new Date(), "New York", 31,
				"info@datatables.net"));
		staff.add(newStaff("Yuri", "Berry", "Chief Marketing Officer (CMO)",
				new BigDecimal("675800"), new Date(), "New York", 31,
				"info@datatables.net"));
		staff.add(newStaff("Caesar", "Vance", "Pre-Sales Support",
				new BigDecimal("106800"), new Date(), "New York", 31,
				"info@datatables.net"));
		staff.add(newStaff("Doris", "Wilder", "Sales Assistant",
				new BigDecimal("85800"), new Date(), "Sidney", 31,
				"info@datatables.net"));
		staff.add(newStaff("Angelica", "Ramos",
				"Chief Executive Officer (CEO)", new BigDecimal("1200000"),
				new Date(), "London", 31, "info@datatables.net"));

		return staff;
	}

	private Staff newStaff(String firstName, String lastName, String position,
			BigDecimal salary, Date startDate, String office, int age,
			String email) {
		return new Staff(firstName, lastName, new Dossier(position, salary,
				startDate, age), office, email);
	}

	public static StaffService getInstance() {
		return instance;
	}
}