package eu.schulteweb.wicket.datatables.markup.html.repeater.data.table;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.wicket.util.template.PackageTextTemplate;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Assert;
import org.junit.Test;

public class ScrollerTableTest {

	@Test
	public void testConfiguration() throws IOException {

		@SuppressWarnings("unused")
		WicketTester tester = new WicketTester();

		ScrollerTable<Object> table = new ScrollerTable<Object>("scroller",
				new ArrayList<DataTableColumn<Object>>(), null, 0);

		PackageTextTemplate expected = null;
		try {
			expected = new PackageTextTemplate(ScrollerTableTest.class,
					"scroller.config");

			Assert.assertEquals(expected.asString(), table.getConfiguration()
					.toString());
		} catch (Exception e) {
			Assert.fail();
		} finally {
			if (expected != null) {
				expected.close();
			}
		}
	}
}
