package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.basic;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.Parameter;

public class Height implements Parameter {

	private int pixelHeight;

	public Height(int pixelHeight) {
		this.pixelHeight = pixelHeight;
	}

	@Override
	public String getKey() {
		return "scrollY";
	}

	@Override
	public String getValue() {
		return pixelHeight + "";
	}

}
