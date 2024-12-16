//Ian Mwai Gachoki
//3132394
package griffith;

public class Address {

	// Private fields to store the location, eircode, street name, and town of the address
	private Location location;
	private String eircode;
	private String streetName;
	private String town;
	
	// Constructor to initialize the Address object with location, eircode, street name, and town
	public Address (Location location, String eircode, String streetName, String town) {
		this.location = location;
		this.eircode = eircode;
		this.streetName = streetName;
		this.town = town;
	}
	
	// Getter method to retrieve the town name
	public String getTown() {
		return town;
	}
	
	// Getter method to retrieve the street name
	public String getStreetName() {
		return streetName;
	}
	
	// Getter method to retrieve the eircode
	public String getEircode() {
		return eircode;
	}
	
	// Setter method to update the eircode, street name, and town fields
	public void setAddress (String eircode, String streetName, String town) {
		this.eircode = eircode;
		this.streetName = streetName;
		this.town = town;
	}
	
	// Method to return a formatted address string
	public String getAddress () {
		return eircode + "," + streetName + "," +town +".";
	}
	
	// Setter method to update the location field
	public void setLocation (Location location) {
		this.location = location;
	}
	
	// Getter method to retrieve the location
	public Location getLocation() {
		return location;
	}
	
}
