//Ian Mwai Gachoki
//3132394
package griffith;

public class Building {

	// Private fields to store the name of the building and its address
	private String name;
	private Address address;
	
	// Constructor to initialize the Building object with a name and an Address object
	public Building(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	// Setter method to update the building's name
	public void setName(String name) {
		this.name=name;
	}
	
	// Getter method to retrieve the building's name
	public String getName() {
		return name;
	}
	
	// Setter method to update the building's address
	public void setAddress(Address address) {
		this.address = address;
	}
	
	// Getter method to retrieve the building's address
	public Address getAddress() {
		return address;
	}
}
