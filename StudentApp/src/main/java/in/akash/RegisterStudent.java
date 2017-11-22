package in.akash;

import org.apache.wicket.request.mapper.parameter.PageParameters;

public class RegisterStudent extends AbstractParent {
	private static final long serialVersionUID = 1L;

	public RegisterStudent(PageParameters pageParameters) {
		super(pageParameters);
		replace(new RegistrationPanel(AbstractParent.CONTENT_ID));
	}

}
