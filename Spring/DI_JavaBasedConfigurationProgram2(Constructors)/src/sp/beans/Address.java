package sp.beans;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private String city;
	private int houseNo;
	private int pincode;

	public Address(String city,int houseNo,int pincode) {
		this.city = city;
		this.houseNo = houseNo;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "City is " + this.city + "\nHouse NO is " + this.houseNo + "\nPincode is " + this.pincode;
	}
}
