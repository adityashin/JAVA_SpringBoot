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
		Address adr = new Address();
		
		adr.setCity("Solapur");
		adr.setPincode(413005);
		adr.setHouseNo(06);
		
		return adr;
	}

	@Bean
	public Student stdid()
	{
		Student std = new Student();
		
		std.setName("aditya");
		std.setRollno(99);
		std.setAddress(addrid());
		
		return std;
	}

}
