/*
 * Class: CMSC203 
 * Instructor: Professor Tarek
 * Description: Design and implement a Property Management application in Java that manages multiple properties owned or managed by a company. 
 * The application will maintain an array of Property objects inside a ManagementCompany object (aggregation), 
 * support adding and listing properties, calculate total rent, include copy constructors, 
 * and provide both a console-based driver and a JavaFX GUI. 
 * Due: 10/28/26
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nebiyou Daniel
*/

public class PropertyDriver {

	public static void main(String[] args) {
		
        ManagementCompany manageCompany = new ManagementCompany("Sunrise Management", "12-3456789");

     // Array of Property objects
        Property[] newProperties = { new Property("Oak Apartments", "Rockville", 1850.00, "Alice Chen"),
            new Property("Maple Townhouse", "Bethesda", 2400.50, "Bob Martin"),
            new Property("Pine Condo", "Silver Spring", 1600.75, "Carla Diaz")};
		
        for (Property p : newProperties) { // for each loop
            int index = manageCompany.addProperty(p);
            System.out.println("Added at index " + index + ": " + p.getPropertyName());
        }
		
        System.out.println();
        System.out.println(manageCompany);
        
        // Copy constructor demonstration
        Property original = newProperties[0];
        Property copy = new Property(original);
        copy.setRentAmount(2000.00);
        System.out.println("\nOriginal rent: $" + original.getRentAmount());
        System.out.println("Copy rent (changed): $" + copy.getRentAmount());

        // Copying the whole company (deep copy)
        ManagementCompany companyCopy = new ManagementCompany(manageCompany);
        companyCopy.addProperty(new Property("Elm House", "Gaithersburg", 2100.00, "Dan Lee"));
        System.out.println("\nOriginal company properties: " + manageCompany.getPropertyCount());
        System.out.println("Copied company properties: " + companyCopy.getPropertyCount());

        // Fill the array to show the full-array error code
        manageCompany.addProperty(new Property("Birch Flat", "Rockville", 1500.00, "Eve Park"));
        manageCompany.addProperty(new Property("Cedar Loft", "Bethesda", 1750.00, "Frank Wu"));
        int result = manageCompany.addProperty(new Property("Extra", "Nowhere", 1000.00, "Nobody"));
        System.out.println("\nAdding to a full company returns: " + result);
        
		// To terminate the background running thread
		System.exit(0);
	}

}
