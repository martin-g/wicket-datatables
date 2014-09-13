package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.basic;

import java.util.List;

import org.apache.wicket.ajax.json.JSONArray;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONObject;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.DataTableColumn;
import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.Option;

public class ColumnDefinition<T> implements Option {

	private List<? extends DataTableColumn<T>> columns;

	public ColumnDefinition(List<? extends DataTableColumn<T>> columns) {
		this.columns = columns;
	}

	@Override
	public String getName() {
		return "columns";
	}

	@Override
	public Object getObject() throws JSONException {
		JSONArray columns = new JSONArray();

		for (DataTableColumn<T> column : this.columns) {
			columns.put(new JSONObject().put("data",
					column.getPropertyExpression()));
		}

		return columns;
	}
}
