package sp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sp.beans.Student;

@Configuration
public class SpringConfig {

	@Bean("StudentBeanOBJ")
	public Student stdid() {
		
		Student std = new Student();
		std.setName("Aditya");
		std.setRollno(99);
		std.setEmail("adityashinde@gmail.com");
		
		return std;
	}
}
