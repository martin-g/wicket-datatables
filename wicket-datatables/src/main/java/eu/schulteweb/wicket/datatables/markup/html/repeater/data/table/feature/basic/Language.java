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
package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.feature.basic;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONObject;

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.Option;

public class Language implements Option {

	private Component component;

	public Language(Component component) {
		this.component = component;
	}

	@Override
	public String getName() {
		return "language";
	}

	@Override
	public JSONObject getObject() throws JSONException {
		JSONObject lang = new JSONObject();
		lang.put("decimal", getValue("decimal"));
		lang.put("lengthMenu", getValue("lengthMenu"));
		lang.put("zeroRecords", getValue("zeroRecords"));
		lang.put("info", getValue("info"));
		lang.put("infoEmpty", getValue("infoEmpty"));
		lang.put("infoFiltered", getValue("infoFiltered"));

		JSONObject paginate = new JSONObject();
		paginate.put("first", getValue("first"));
		paginate.put("last", getValue("last"));
		paginate.put("next", getValue("next"));
		paginate.put("previous", getValue("previous"));
		lang.put("paginate", paginate);

		return lang;
	}

	protected String getValue(String key) {
		return component.getString(key, null, key);
	}
}