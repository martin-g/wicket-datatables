package eu.schulteweb.wicket.datatables.examples.home.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.Model;

import com.mycompany.domain.Staff;

import eu.schulteweb.wicket.datatables.examples.ExamplesPage;
import eu.schulteweb.wicket.datatables.examples.general.service.StaffService;
import eu.schulteweb.wicket.datatables.markup.html.repeater.PropertyColumn;
import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.DataTableColumn;
import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.DefaultDataTable;
import eu.schulteweb.wicket.datatables.markup.html.repeater.util.SortableListDataProvider;

public class HomePage extends ExamplesPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		SortableListDataProvider<Staff> dataProvider = new SortableListDataProvider<Staff>(
				StaffService.getInstance().findStaff());

		DefaultDataTable<Staff> defaultDataTable = new DefaultDataTable<Staff>(
				"datatable", newColumns(), dataProvider, 10);
		add(defaultDataTable);
	}

	private List<DataTableColumn<Staff>> newColumns() {
		List<DataTableColumn<Staff>> columns = new ArrayList<DataTableColumn<Staff>>();
		columns.add(new PropertyColumn<Staff>(Model.of("Firstname"),
				"firstname"));
		columns.add(new PropertyColumn<Staff>(Model.of("Lastname"), "lastname"));
		columns.add(new PropertyColumn<Staff>(Model.of("Position"),
				"hr.position"));
		columns.add(new PropertyColumn<Staff>(Model.of("Salary"), "hr.salary"));
		columns.add(new PropertyColumn<Staff>(Model.of("Start date"),
				"hr.startDate"));
		columns.add(new PropertyColumn<Staff>(Model.of("Age"), "hr.age"));
		columns.add(new PropertyColumn<Staff>(Model.of("Office"), "hr.age"));
		columns.add(new PropertyColumn<Staff>(Model.of("Email"), "email"));
		return columns;
	}
}