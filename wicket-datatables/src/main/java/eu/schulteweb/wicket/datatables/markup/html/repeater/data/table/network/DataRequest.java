package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.network;

import org.apache.wicket.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataRequest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DataRequest.class);

	private Request request;

	public DataRequest(Request request) {
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

	public int getDraw() {
		return request.getRequestParameters().getParameterValue("draw").toInt();
	}

	public int getStart() {
		return request.getRequestParameters().getParameterValue("start")
				.toInt();
	}

	public int getLength() {
		return request.getRequestParameters().getParameterValue("length")
				.toInt();
	}
}
