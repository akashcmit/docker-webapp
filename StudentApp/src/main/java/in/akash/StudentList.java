package in.akash;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import in.akash.db.StudentDao;
import in.akash.db.entity.Student;

public class StudentList extends Panel {
	private static final long serialVersionUID = 1L;

	public StudentList(String id) {
		super(id);
		List<Student> students = StudentDao.getAllStudents();

		add(new ListView<Student>("students", students) {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("rawtypes")
			@Override
			protected void populateItem(ListItem<Student> item) {
				item.add(new Label("id", new PropertyModel(item.getModel(), "id")));
				item.add(new Label("name", new PropertyModel(item.getModel(), "name")));
				item.add(new Label("age", new PropertyModel(item.getModel(), "age")));
				item.add(new Label("standard", new PropertyModel(item.getModel(), "standard")));
				item.add(new Label("section", new PropertyModel(item.getModel(), "section")));
			}
		});
	}

}
