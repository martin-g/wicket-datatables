package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table;

import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

public class ColumnView<T, S> extends Panel {

	public ColumnView(String id, List<? extends IColumn<T, S>> columns) {
		super(id);

		RepeatingView header = new RepeatingView("header");
		add(header);

		for (IColumn<T, S> column : columns) {
			WebMarkupContainer th = new WebMarkupContainer(header.newChildId());
			header.add(th);
			th.add(column.getHeader("columnName"));
		}

		RepeatingView footer = new RepeatingView("footer");
		add(footer);

		for (IColumn<T, S> column : columns) {
			WebMarkupContainer th = new WebMarkupContainer(footer.newChildId());
			footer.add(th);
			th.add(column.getHeader("columnName"));
		}
	}
}
