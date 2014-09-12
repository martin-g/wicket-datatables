package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table;

import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.basic.Dom;
import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.basic.Dom.Control;
import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.basic.Height;
import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.scroller.Scroller;

public class ScrollerTable<T> extends DataTable<T> {

	public ScrollerTable(String id, List<? extends DataTableColumn<T>> columns,
			ISortableDataProvider<T, String> dataProvider, long rowsPerPage) {
		super(id, columns, dataProvider, rowsPerPage);
	}

	@Override
	protected Configuration getConfiguration() {
		Configuration configuration = new Configuration();

		configuration.add(new Dom(Control.PROCESSING_DISPLAY_ELEMENT,
				Control.TABLE, Control.INFO_SUMMARY, Control.S));

		configuration.add(getHeight());

		configuration.setSearchingEnabled(false);
		configuration.setSortEnabled(false);

		configuration.add(new Scroller(true));

		return configuration;
	}

	protected Height getHeight() {
		return new Height(200);
	}
}