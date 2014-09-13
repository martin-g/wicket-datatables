package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.scroller;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.DataTable;

public class ScrollerResourcesBehavior<T> extends Behavior {

	public ScrollerResourcesBehavior(DataTable<T> dataTable) {
		dataTable.add(this);
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);

		response.render(CssHeaderItem.forReference(new CssResourceReference(
				ScrollerResourcesBehavior.class, "css/dataTables.scroller.css")));

		response.render(JavaScriptHeaderItem
				.forReference(new JavaScriptResourceReference(
						ScrollerResourcesBehavior.class, "js/dataTables.scroller.js")));
	}

	public static <T> void attachTo(DataTable<T> dataTable) {
		new ScrollerResourcesBehavior<T>(dataTable);
	}
}