package sp.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sp.beans.Student;

public class tester {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Student.class);
		
		Student sted = (Student) context.getBean("student");
		sted.display();
	}
}
