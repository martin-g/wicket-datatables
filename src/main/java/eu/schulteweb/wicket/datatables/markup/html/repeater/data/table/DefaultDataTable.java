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

import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.repeater.data.IDataProvider;

public class DefaultDataTable<T> extends DataTable<T> {

	public DefaultDataTable(String id,
			List<? extends IColumn<T, String>> columns,
			IDataProvider<T> dataProvider, long rowsPerPage) {
		super(id, columns, dataProvider, rowsPerPage);
	}

}
