/*******************************************************************************
 * Copyright 2014 Stefan Schulte
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package eu.schulteweb.wicket.datatables.markup.html.repeater.util;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.model.IModel;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.network.DataRequest;
import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.network.DataResponse;

public class JSONProvider<T> implements ISortableDataProvider<T, String> {

	private ISortableDataProvider<T, String> dataProvider;

	public JSONProvider(ISortableDataProvider<T, String> dataProvider) {
		this.dataProvider = dataProvider;
	}

	public void getJSONResponse(DataRequest request,
			OutputStream outputStream) {
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {

			@Override
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});

		xstream.toXML(
				new DataResponse<T>(iterator(request.getStart(),
						request.getLength()), size(), size(), request.getDraw()),
				outputStream);
	}

	@Override
	public Iterator<? extends T> iterator(long first, long count) {
		return dataProvider.iterator(first, count);
	}

	@Override
	public long size() {
		return dataProvider.size();
	}

	@Override
	public IModel<T> model(T object) {
		return dataProvider.model(object);
	}

	@Override
	public void detach() {
		dataProvider.detach();
	}

	@Override
	public ISortState<String> getSortState() {
		return dataProvider.getSortState();
	}
}