package sp.beans;

public class Address {

	// Because we are injecting this class in another we only need setters.

	private int houseNo;
	private String city;
	private int pincode;

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "HouseNo is "+this.houseNo+"\nCity is "+this.city+"\nPincode is "+this.pincode+"\n";
	}
}
