package in.akash;

import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ViewStudents extends AbstractParent {
	private static final long serialVersionUID = 1L;

	public ViewStudents(PageParameters pageParameters) {
		super(pageParameters);
		replace(new StudentList(AbstractParent.CONTENT_ID));
	}
}
