package sp.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sp.beans.Address;
import sp.beans.Student;

@Configuration
public class SpringConfiguration {

	@Bean
	public Address addrid()
	{
		Address adr = new Address("solapur",6,413005);
		
		return adr;
	}

	@Bean
	public Student stdid()
	{
		Student std = new Student("aditya",99,addrid());
		
		return std;
	}

}
