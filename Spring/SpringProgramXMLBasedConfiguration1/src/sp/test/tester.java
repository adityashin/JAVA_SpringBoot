package sp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sp.beans.Student;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String config = "/sp/resources/applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		Student sd = (Student) context.getBean("stdid");
		sd.display();
	}

}
