package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table;

import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.repeater.data.IDataProvider;

public class DefaultDataTable<T> extends DataTable<T> {

	public DefaultDataTable(String id,
			List<? extends IColumn<T, String>> columns,
			IDataProvider<T> dataProvider, long rowsPerPage) {
		super(id, columns, dataProvider, rowsPerPage);
	}

}
