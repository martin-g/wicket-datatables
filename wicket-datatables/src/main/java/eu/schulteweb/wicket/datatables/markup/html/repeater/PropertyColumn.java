package eu.schulteweb.wicket.datatables.markup.html.repeater;

import org.apache.wicket.model.IModel;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.DataTableColumn;

public class PropertyColumn<T>
		extends
		org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn<T, String>
		implements DataTableColumn<T> {

	public PropertyColumn(IModel<String> displayModel, String propertyExpression) {
		super(displayModel, propertyExpression);
	}

}