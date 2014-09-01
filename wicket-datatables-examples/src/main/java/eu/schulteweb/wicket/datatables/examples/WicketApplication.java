package eu.schulteweb.wicket.datatables.examples;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import de.agilecoders.wicket.core.Bootstrap;
import eu.schulteweb.wicket.datatables.examples.home.web.HomePage;

public class WicketApplication extends WebApplication {

	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	@Override
	public void init() {
		super.init();
		getMarkupSettings().setStripWicketTags(true);

		Bootstrap.install(this);
	}
}