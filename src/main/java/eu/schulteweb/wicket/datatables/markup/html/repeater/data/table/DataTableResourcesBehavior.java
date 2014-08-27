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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.util.template.PackageTextTemplate;

public class DataTableResourcesBehavior<T> extends Behavior {

	private DataTable<T> dataTable;

	private DataTableResourcesBehavior(DataTable<T> dataTable) {
		this.dataTable = dataTable;
		dataTable.add(this);
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);

		response.render(CssHeaderItem.forReference(new CssResourceReference(
				DataTableResourcesBehavior.class, "css/jquery.dataTables.css")));

		response.render(JavaScriptHeaderItem
				.forReference(new JavaScriptResourceReference(
						DataTableResourcesBehavior.class,
						"js/jquery.dataTables.js") {

					@Override
					public Iterable<? extends HeaderItem> getDependencies() {
						List<HeaderItem> dependencies = new ArrayList<HeaderItem>();
						dependencies.add(JavaScriptHeaderItem
								.forReference(Application.get()
										.getJavaScriptLibrarySettings()
										.getJQueryReference()));
						return dependencies;
					}
				}));

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("tableId", dataTable.getTableMarkupId());

		PackageTextTemplate initScript = null;
		try {
			initScript = new PackageTextTemplate(
					DataTableResourcesBehavior.class, "js/initScript.js");

			response.render(OnLoadHeaderItem.forScript(initScript
					.asString(variables)));
		} finally {
			if (initScript != null) {
				try {
					initScript.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static <T> void attachTo(DataTable<T> dataTable) {
		new DataTableResourcesBehavior<T>(dataTable);
	}

}