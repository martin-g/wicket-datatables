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

import eu.schulteweb.wicket.datatables.markup.html.repeater.data.table.Parameter;

/**
 * Defines control elements and its orders around the data table.
 * 
 * @author Stefan Schulte
 * 
 */
public class Dom implements Parameter {

	public enum Control {
		LENGTH_SELECTOR("l"), FILTER("f"), TABLE("t"), INFO_SUMMARY("i"), PAGINATION(
				"p"), PROCESSING_DISPLAY_ELEMENT("r"), S("S");

		private String key;

		private Control(String key) {
			this.key = key;
		}

		public String getKey() {
			return key;
		}
	}

	private Control[] controls;

	public Dom(Control... controls) {
		this.controls = controls;
	}

	@Override
	public String getKey() {
		return "dom";
	}

	@Override
	public String getValue() {
		String value = "";

		for (Control c : controls) {
			value += c.getKey();
		}

		return value;
	}
}