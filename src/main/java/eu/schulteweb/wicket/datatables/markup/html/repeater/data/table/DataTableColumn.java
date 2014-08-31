package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;

public interface DataTableColumn<T> extends IColumn<T, String> {

	public String getPropertyExpression();

}
