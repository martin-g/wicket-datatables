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
package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.IResourceListener;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.data.IDataProvider;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.extension.Extension;

public class DataTable<T> extends Panel implements IResourceListener {

	private List<Extension> extensions = new ArrayList<Extension>();

	private List<? extends IColumn<T, String>> columns;

	private WebMarkupContainer table;

	public DataTable(String id,
			final List<? extends IColumn<T, String>> columns,
			final IDataProvider<T> dataProvider, final long rowsPerPage) {
		super(id);
		this.columns = columns;

		table = new WebMarkupContainer("table");
		table.setOutputMarkupId(true);
		add(table);

		ColumnView<T, String> columnView = new ColumnView<T, String>("columns",
				columns);
		table.add(columnView);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		DataTableResourcesBehavior.attachTo(this);
	}

	public void add(Extension extension) {
		extensions.add(extension);
	}

	@Override
	public void onResourceRequested() {

	}

	public CharSequence getCallbackUrl() {
		return urlFor(IResourceListener.INTERFACE, null);
	}

	public String getTableMarkupId() {
		return table.getMarkupId();
	}
}