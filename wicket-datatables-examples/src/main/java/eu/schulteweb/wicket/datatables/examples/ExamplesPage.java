package eu.schulteweb.wicket.datatables.examples;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCssReference;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeIconType;
import eu.schulteweb.wicket.datatables.examples.home.web.HomePage;
import eu.schulteweb.wicket.datatables.examples.scroller.web.ScrollerPage;

public class ExamplesPage extends WebPage {

	public ExamplesPage() {
		Navbar navbar = new Navbar("navbar");
		add(navbar);

		navbar.addComponents(NavbarComponents.transform(
				Navbar.ComponentPosition.LEFT, new NavbarButton<Void>(
						HomePage.class, Model.of("Home"))
						.setIconType(FontAwesomeIconType.home)));

		navbar.addComponents(NavbarComponents.transform(
				Navbar.ComponentPosition.LEFT, new NavbarButton<Void>(
						ScrollerPage.class, Model.of("Scroller"))
						.setIconType(FontAwesomeIconType.refresh)));

		navbar.addComponents(NavbarComponents.transform(
				Navbar.ComponentPosition.LEFT, new NavbarButton<Void>(
						HomePage.class, Model.of("Fixed Column"))
						.setIconType(FontAwesomeIconType.wrench)));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(FontAwesomeCssReference
				.instance()));
	}
}