package sp.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	// The name of the bean is student with starting letter in "Smallcase";
	
	@Value("Aditya")
	private String name;
	
	@Value("99")
	private int rollno;
	
	@Value("99")
	private float marks;
	
	@Value("adityashinde2at@gmail.com")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void display() {
		System.out.println("Name is " + this.name);
		System.out.println("Rollno is " + this.rollno);
		System.out.println("Marks is " + this.marks);
		System.out.println("Email is " + this.email);
	}

}
