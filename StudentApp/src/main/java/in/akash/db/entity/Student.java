package in.akash.db.entity;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String age;
	private String standard;
	private String section;

	public Student(String name, String age, String standard, String section) {
		super();
		this.name = name;
		this.age = age;
		this.standard = standard;
		this.section = section;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", standard=" + standard + ", section="
				+ section + "]";
	}
}
