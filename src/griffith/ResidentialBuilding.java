//Ian Mwai Gachoki
//3132394
package griffith;

public class ResidentialBuilding extends Building {
	
	// Private field to store the building number of the residential building
	private String buildingNumber;

	// Constructor to initialize the ResidentialBuilding with name, address, and building number
	public ResidentialBuilding(String name, Address address, String buildingNumber) {
		// Call the superclass (Building) constructor to initialize name and address
		super(name, address);
		this.buildingNumber = buildingNumber;
	}
	
	// Overloaded constructor to initialize ResidentialBuilding with address and building number, but without a name
	public ResidentialBuilding( Address address, String buildingNumber) {
		// Call the superclass constructor with an empty name and the address
		super("", address);
		this.buildingNumber = buildingNumber;
	}
	
	// Setter method to update the building number
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	
	// Getter method to retrieve the building number
	public String getBuildingNumber() {
		return buildingNumber;
	}

}
