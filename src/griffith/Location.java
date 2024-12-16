//Ian Mwai Gachoki
//3132394
package griffith;

public class Location {
	
	// Private fields to store the latitude and longitude of the location
	private double latitude;
	private double longitude;
	
	// Constructor to initialize the Location object with latitude and longitude values
	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude= longitude;
	}
	
	// Setter method to update the latitude value
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	// Getter method to retrieve the latitude value
	public double getLatitude(){
		return latitude;
	}
	
	// Setter method to update the longitude value
	public void setLongitude (double longitude) {
		this.longitude= longitude;
	}
	
	// Getter method to retrieve the longitude value
	public double getLongitude() {
		return longitude;
	}

}
