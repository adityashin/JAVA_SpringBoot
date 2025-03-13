package sp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sp.beans.Student;
import sp.configuration.SpringConfig;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//		Student std = (Student) context.getBean("StudentBeanOBJ");
//		std.display();
		
		Student std = context.getBean(Student.class);
		std.display();
		
		
		
	}

}
