package sp.beans;

public class Address {

	private int houseNo;
	private String city;
	private int pincode;

	public Address(int houseNo,String city, int pincode) {
		this.houseNo = houseNo;
		this.city = city;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "House NO is "+this.houseNo+"\nCity is "+this.city+"\nPincode is "+this.pincode;
	}
}
