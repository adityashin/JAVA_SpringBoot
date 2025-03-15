package sp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sp.beans.Student;

public class tester {

	public static void main(String[] args) {
		
		String path="/sp/resources/ApplicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Student std = (Student)context.getBean("studid");
		std.display();
	}
}
