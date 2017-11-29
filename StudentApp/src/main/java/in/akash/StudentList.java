package in.akash;

import java.util.List;

import javax.ejb.EJB;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import in.akash.dao.StudentDao;
import in.akash.db.entity.StudentEntity;

public class StudentList extends Panel {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private StudentDao dao;

	public StudentList(String id) {
		super(id);
		List<StudentEntity> students = dao.getAllStudents();

		add(new ListView<StudentEntity>("students", students) {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings("rawtypes")
			@Override
			protected void populateItem(ListItem<StudentEntity> item) {
				item.add(new Label("id", new PropertyModel(item.getModel(), "id")));
				item.add(new Label("name", new PropertyModel(item.getModel(), "name")));
				item.add(new Label("age", new PropertyModel(item.getModel(), "age")));
				item.add(new Label("standard", new PropertyModel(item.getModel(), "standard")));
				item.add(new Label("section", new PropertyModel(item.getModel(), "section")));
			}
		});
	}

}
