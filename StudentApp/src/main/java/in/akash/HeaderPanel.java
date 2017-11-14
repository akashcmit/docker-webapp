package in.akash;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {
	private static final long serialVersionUID = 1L;

	public HeaderPanel(String id) {
		super(id);
		add(new Link<Void>("register") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(RegisterStudent.class);				
			}
		});
		add(new Link<Void>("view") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(ViewStudents.class);				
			}
		});
	}

}
