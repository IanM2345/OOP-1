//Ian Mwai Gachoki
//3132394

package griffith;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
	
	//Arrays to store residential and commercial buildings
	private List<ResidentialBuilding>ResidentialList = new ArrayList<>();
	private List<CommercialBuilding>CommercialList = new ArrayList <> ();
	
	public static void main (String [] args) {
		
		// Create an instance of the Map class.
		Map map = new Map ();
		
		// Latitude and longitude are created for a few location objects.
		Location firstLocation = new Location (53.2903,-6.2853);
		Location secondLocation = new Location (53.2870,-6.3556);
		Location thirdLocation = new Location (53.3261,-6.2249);
		Location fourthLocation = new Location(53.2930, -6.2790);
	    Location fifthLocation = new Location(53.2940, -6.3800);
	    Location sixthLocation = new Location(53.3335, -6.2274);
	    
	    // Putting addresses and address details together to create address objects
		Address firstAddress = new Address (firstLocation, "D16 H878", "Grange Road, Rathfarnham","Dublin");
		Address secondAddress = new Address (secondLocation, "D24 Y6J8", "Main Street, Tallaght", "Dublin");
		Address thirdAddress = new Address ( thirdLocation,"D04 D3R5", "Merrion Road, Bansbridge", "Dublin");
		Address fourthAddress = new Address(fourthLocation, "D16 K234", "Lodge Park, Woodtown", "Dublin 16");
	    Address fifthAddress = new Address(fifthLocation, "D24 P456", "Lakeside Park, Kingswood", "Dublin 24");
	    Address sixthAddress = new Address(sixthLocation, "D04 C789", "Sandycove House, Sandymount", "Dublin 4");

	    // Creating residential buildings with their names and addresses
		ResidentialBuilding firstResidential = new ResidentialBuilding("Grange Hall Apartments", firstAddress, "A23");
		ResidentialBuilding secondResidential = new ResidentialBuilding( fourthAddress, "N45");
		ResidentialBuilding thirdResidential = new ResidentialBuilding("Merrion Village Apartments", thirdAddress, "XIX");
		
		// Creating commercial buildings with their names, addresses, opening hours and url.
		CommercialBuilding firstCommercial = new CommercialBuilding ("Rathfarnham Shopping Centre", fifthAddress);
		CommercialBuilding secondCommercial = new CommercialBuilding ("The Square Tallaght Shopping Centre", secondAddress, "9am-7pm","https://www.thesquare.ie");
		CommercialBuilding thirdCommercial = new CommercialBuilding ("Merrion Shopping Centre", sixthAddress, "8am-6am","https://themerrioncentre.ie");
		
		// Adding the residential buildings to the ResidentialList
		map.ResidentialList.add(firstResidential);
		map.ResidentialList.add(secondResidential);
		map.ResidentialList.add(thirdResidential);
		
		// Adding the commercial buildings to the CommercialList
		map.CommercialList.add(firstCommercial);
		map.CommercialList.add(secondCommercial);
		map.CommercialList.add(thirdCommercial);
		
		// Showing the menu so the user can interact
		map.menu();
		
	}
	
	// Method to provide a menu and carry out actions in response to user input
	public void menu() {
		
		// Create a Scanner object to take in user input
		Scanner scan = new Scanner(System.in);
		
		// Infinite loop to continue the menu till the user decides to end it
		while (true) {
			
			// Bring up the menu options
			System.out.println("Welcome To The Eircode Map.");
			System.out.println("Please choose one of the options:");
			System.out.println(" 1. Find a Building by its Eircode.");
			System.out.println(" 2. Get a Building's Eircode by coordinates.");
			System.out.println(" 3. Get a distance between two buildings.");
			System.out.println(" 4. Quit");
			System.out.println(" Enter your choice:");
			
			// Get the user's choice
			int Choice = scan.nextInt();
			// Clear the buffer
			scan.nextLine();
			
			// Take action in response to the user's selection
			if (Choice == 1) {
				// Use the building's Eircode to find it.
				System.out.print("Enter Eircode:");
				String eircode = scan.nextLine();
				findBuildingByEircode(eircode);
			}else if(Choice == 2) {
				// Using coordinates, determine a building's Eircode
				System.out.print("Enter Latitude:");
				double latitude = scan.nextDouble();
				System.out.print("Enter Longitude;");
				double longitude = scan.nextDouble();
				getEircodeByCoordinates(latitude, longitude);
			}else if (Choice == 3) {
				// Get the distance between two buildings based on Eircodes
				System.out.print("Enter Eircode of first building");
				String buildingEircode1 = scan.nextLine();
				System.out.print("Enter Eircode of second building");
				String buildingEircode2 = scan.nextLine();
				getDistanceBetweenBuildings(buildingEircode1, buildingEircode2);
			}else if(Choice == 4) {
				// Exit the program
				System.out.println("BYE...");
				scan.close();
			}
			else {
				// Handle invalid input
				System.out.println("Invalid choice: Please Enter a valid input.");
			}
		}
	}
	
	// Method to find a building by its Eircode
	public void findBuildingByEircode(String eircode) {
	    Building building = findBuilding(eircode);
	    String description = "";

	    // Check if building is found
	    if (building != null) {
	    	// Determine if the building is residential or commercial
	        if (building instanceof ResidentialBuilding) {
	            description = "Residential Building";
	        } else if (building instanceof CommercialBuilding) {
	            description = "Commercial Building";
	        }

	     // Display building details
	        System.out.println("Building Located:");
	        System.out.println("Location: " + building.getName());
	        System.out.println("Address: " + building.getAddress().getAddress());
	        System.out.println("Description: " + description);

	     // Additional information if the building is commercial
	        if (description.equals("Commercial Building")) {
	            CommercialBuilding commercialBuilding = (CommercialBuilding) building;
	            System.out.println("Opening Hours: " + commercialBuilding.getOpeningHours());
	            System.out.println("Website: " + commercialBuilding.getUrl());
	        } else {
	            System.out.println("Opening Hours: N/A");
	            System.out.println("Website: N/A");
	        }

	    } else {
	    	// Show an error if the building cannot be located.
	        System.out.println("Error: No building found with Eircode: " + eircode);
	    }
	}

	
	 // Helper method to find a building by Eircode from both residential and commercial lists
	private Building findBuilding (String eircode) {
		// Search in ResidentialList
		for(ResidentialBuilding res : ResidentialList) {
			if (res.getAddress().getEircode().equals(eircode)) {
				return res;
			}
		}
		// Search in CommercialList
		for (CommercialBuilding com : CommercialList) {
			if (com.getAddress().getEircode().equals(eircode)) {
				return com;
			}
		}
		return null; // Return null if no building is found
	}
	
	// Method to determine a building's Eircode based on its coordinates
	public void getEircodeByCoordinates(double latitude, double longitude) {
        Building building = findBuildingByCoordinates(latitude, longitude);
        if (building != null) {
            System.out.println("Eircode : " + building.getAddress().getEircode());
        } else {
            System.out.println("Error: No building found at the coordinates.");
        }
    }
	
	// Helper method to find a building by its coordinates from both lists
	private Building findBuildingByCoordinates(double latitude, double longitude) {
        for (ResidentialBuilding residential : ResidentialList) {
            Location residentialLocation = residential.getAddress().getLocation();
            if (residentialLocation.getLatitude() == latitude && residentialLocation.getLongitude() == longitude) {
                return residential;
            }
        }
        for (CommercialBuilding commercial : CommercialList) {
            Location commercialLocation = commercial.getAddress().getLocation();
            if (commercialLocation.getLatitude() == latitude && commercialLocation.getLongitude() == longitude) {
                return commercial;
            }
        }
        return null; // Return null if no building is found at the coordinates
    }
	
	// Method to calculate the distance between two buildings given their Eircodes
	public void getDistanceBetweenBuildings(String eircode1, String eircode2) {
        Building building1 = findBuilding(eircode1);
        Building building2 = findBuilding(eircode2);

     // Handle cases where one or both buildings are not found
        if (building1 == null ) {
            System.out.println("Error. Building 1's Eircode not found.");
        }else if(building2 == null){
        	System.out.println("Error. Building 2's Eircode not found.");
        }else {
        	// Calculate distance between the two buildings
            Location location1 = building1.getAddress().getLocation();
            Location location2 = building2.getAddress().getLocation();
            double distance = distance(location1, location2); 
            System.out.println("Distance between buildings: " + distance + " km");
        }
    }
	
	// Helper method to calculate the distance between two locations using the Haversine formula
	public double distance(Location location1, Location loccation2) {
		// Radius of the Earth in kilometers
        final double R = 6371.0; 
        
     // Convert degrees to radians for latitude and longitude
        double latitude1 = Math.toRadians(location1.getLatitude());
        double longitude1 = Math.toRadians(location1.getLongitude());
        double latitude2 = Math.toRadians(loccation2.getLatitude());
        double longitude2 = Math.toRadians(loccation2.getLongitude());
        
     // Determine the variations in the coordinates.
        double deltaLatitude = latitude2 - latitude1;
        double deltaLongitude = longitude2 - longitude1;
        
     // Use the formula for Haversine.
        double a = Math.sin(deltaLatitude / 2) * Math.sin(deltaLatitude / 2) +
                   Math.cos(latitude1) * Math.cos(latitude1) *
                   Math.sin(deltaLongitude  / 2) * Math.sin(deltaLongitude  / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
     // Return the calculated distance
        return R * c;
    }
	

}
