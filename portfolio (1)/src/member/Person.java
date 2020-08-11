package member;

import java.util.ArrayList;

public class Person {
	
	private String name;
	private double height;
	private double weight;
	
//	ArrayList<Person> personList = new ArrayList<>();
	
	
	public Person(String name, double height, double weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "이름=" + name + ", 키=" + height + ", 몸무게=" + weight + "";
	}

	
	
//	public void setPersonList(ArrayList<Person> personList) {
//		this.personList = personList;
//	}

	//회원 추가 메서드
//	public void addPerson(Person person) {
//		Person.add(person);
//	}
//	

	
	
}
