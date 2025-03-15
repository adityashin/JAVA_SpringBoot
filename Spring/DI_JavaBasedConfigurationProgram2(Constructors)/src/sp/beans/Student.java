package sp.beans;

public class Student {

	private String name;
	private int rollno;
	private Address address;

	public Student(String name,int rollno,Address address) {
		this.name = name;
		this.rollno = rollno;
		this.address = address;
	}

	public void display() {
		System.out.println("Name is " + this.name);
		System.out.println("Rollno is " + this.rollno);
		System.out.println("Address is " + this.address.toString());
	}
}
