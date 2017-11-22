package in.akash;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import in.akash.dao.StudentDao;
import in.akash.dao.StudentDaoImpl;
import in.akash.db.entity.StudentEntity;

public class RegistrationPanel extends Panel {
	private static final long serialVersionUID = 1L;
	private TextField<String> name;
	private TextField<String> age;
	private TextField<String> standard;
	private TextField<String> section;

	public RegistrationPanel(String id) {
		super(id);
		name = new TextField<String>("name", Model.of(""));
		age = new TextField<String>("age", Model.of(""));
		standard = new TextField<String>("standard", Model.of(""));
		section = new TextField<String>("section", Model.of(""));

		Form<?> form = new Form<Void>("userForm") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				final String studentName = name.getModelObject();
				final String studentAge = age.getModelObject();
				final String studentStandard = standard.getModelObject();
				final String studentSection = section.getModelObject();
				StudentEntity student = new StudentEntity(studentName, studentAge, studentStandard, studentSection);
				StudentDao dao = new StudentDaoImpl();
				dao.saveStudent(student);
			}
		};

		add(form);
		form.add(name);
		form.add(age);
		form.add(standard);
		form.add(section);
	}
}
