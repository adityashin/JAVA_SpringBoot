package sp.beans;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private String city;
	private int houseNo;
	private int pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "City is " + this.city + "\nHouse NO is " + this.houseNo + "\nPincode is " + this.pincode;
	}
}
