package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataResponse<T> {

	private int draw;

	private long recordsTotal;

	private long recordsFiltered;

	private List<T> data = new ArrayList<T>();

	public DataResponse(Iterator<? extends T> iterator, long recordsTotal,
			long recordsFiltered, int draw) {
		while (iterator.hasNext()) {
			data.add(iterator.next());
		}

		this.recordsFiltered = recordsTotal;
		this.recordsTotal = recordsTotal;
		this.draw = draw;
	}

	public int getDraw() {
		return draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}
}