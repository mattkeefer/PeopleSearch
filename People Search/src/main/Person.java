package main;

public class Person {

	private String name;
	private int age;
	private int index;
	
	public Person(String n, int a) throws FormatException {
		if(n.trim().equals("")) {
			throw new FormatException("Name cannot be blank.");
		}
		else {
			name = n;
		}
		if(a<0) {
			throw new FormatException("Age must be a positive integer.");
		}
		else {
			age = a;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) throws FormatException {
		if(n.trim().equals("")) {
			throw new FormatException("Name cannot be blank.");
		}
		name = n;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int a) throws FormatException {
		if(a<0) {
			throw new FormatException("Age must be a positive integer.");
		}
		age = a;
	}
	
	public int compareTo(Object obj) {
		return name.toLowerCase().compareTo(((Person)obj).getName().toLowerCase());
	}
}