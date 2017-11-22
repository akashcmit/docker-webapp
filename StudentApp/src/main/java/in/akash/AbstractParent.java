package in.akash;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class AbstractParent extends WebPage {
	private static final long serialVersionUID = 1L;
	public static final String CONTENT_ID = "contentComponent";
	private Component headerPanel;
	private Component footerPanel;

	public AbstractParent(PageParameters pageParameters) {
		super(pageParameters);
		add(headerPanel = new HeaderPanel("headerPanel"));
		add(footerPanel = new FooterPanel("footerPanel"));
		add(new Label(CONTENT_ID, "Child Content"));
	}

	public Component getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel(Component headerPanel) {
		this.headerPanel = headerPanel;
	}

	public Component getFooterPanel() {
		return footerPanel;
	}

	public void setFooterPanel(Component footerPanel) {
		this.footerPanel = footerPanel;
	}

}
