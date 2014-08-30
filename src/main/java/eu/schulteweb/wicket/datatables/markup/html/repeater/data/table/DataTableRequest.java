package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table;

import org.apache.wicket.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataTableRequest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DataTableRequest.class);

	private Request request;

	public DataTableRequest(Request request) {
		this.request = request;

		if (LOGGER.isDebugEnabled()) {

			LOGGER.debug("--- Parameter ---");

			for (String name : request.getRequestParameters()
					.getParameterNames()) {

				LOGGER.debug(String.format("%s -> %s", name, request
						.getRequestParameters().getParameterValue(name)));
			}
		}
	}

}
