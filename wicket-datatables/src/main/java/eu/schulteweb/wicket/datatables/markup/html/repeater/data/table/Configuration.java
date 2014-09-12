package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONObject;

public class Configuration {

	private List<Parameter> parameter = new ArrayList<Parameter>();

	private List<Option> options = new ArrayList<Option>();

	private boolean sortEnabled = true;

	private boolean searchingEnabled = true;

	public Configuration() {

	}

	public void setSortEnabled(boolean sortEnabled) {
		this.sortEnabled = sortEnabled;
	}

	public void setSearchingEnabled(boolean searchingEnabled) {
		this.searchingEnabled = searchingEnabled;
	}

	public void add(Parameter parameter) {
		this.parameter.add(parameter);
	}

	public void add(Option option) {
		this.options.add(option);
	}

	public void addParameter(final String key, final Object value) {
		parameter.add(new Parameter() {

			@Override
			public String getValue() {
				return value.toString();
			}

			@Override
			public String getKey() {
				return key;
			}
		});
	}

	@Override
	public String toString() {
		addParameter("serverSide", true);
		addParameter("ordering", sortEnabled);
		addParameter("searching", searchingEnabled);

		try {
			JSONObject config = new JSONObject();

			for (Parameter option : parameter) {
				config.put(option.getKey(), option.getValue());
			}

			for (Option option : options) {
				config.put(option.getName(), option.getObject());
			}

			return config.toString(4);
		} catch (JSONException e) {
			throw new WicketRuntimeException(e);
		}
	}
}