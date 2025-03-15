package sp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sp.beans.Student;
import sp.resources.SpringConfiguration;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		Student std = context.getBean(Student.class);
		std.display();
	}

}
