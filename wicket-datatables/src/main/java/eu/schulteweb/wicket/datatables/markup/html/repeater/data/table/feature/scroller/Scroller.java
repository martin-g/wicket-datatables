package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.scroller;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONObject;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.Option;

public class Scroller implements Option {

	private boolean showLoadingIndicator;

	public Scroller(boolean showLoadingIndicator) {
		this.showLoadingIndicator = showLoadingIndicator;
	}

	@Override
	public String getName() {
		return "scroller";
	}

	@Override
	public JSONObject getObject() throws JSONException {
		JSONObject scroller = new JSONObject();
		scroller.put("loadingIndicator", showLoadingIndicator);
		return scroller;
	}
}