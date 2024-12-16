//Ian Mwai Gachoki
//3132394
package griffith;

public class CommercialBuilding extends Building{
	
	// Fields specific to commercial buildings
	private String openingHours;
	private String Url;

	// Constructor to initialize a CommercialBuilding without opening hours or URL
	public CommercialBuilding(String name, Address address) {
		// Call the superclass (Building) constructor to initialize name and address
		super(name, address);
		this.setOpeningHours(null);
		this.setUrl(null);
		
	}
	
	// Overloaded constructor to initialize a CommercialBuilding with name, address, opening hours, and URL
	public CommercialBuilding(String name, Address address, String openingHours, String Url) {
		// Call the superclass (Building) constructor to initialize name and address
		super(name, address);
		this.setOpeningHours(openingHours);
		this.setUrl(Url);
		
	}

	// Getter method to retrieve the opening hours of the commercial building
	public String getOpeningHours() {
		return openingHours;
	}

	// Setter method to update the opening hours of the commercial building
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	// Getter method to retrieve the URL of the commercial building
	public String getUrl() {
		return Url;
	}

	// Setter method to update the URL of the commercial building
	public void setUrl(String url) {
		Url = url;
	}

}
