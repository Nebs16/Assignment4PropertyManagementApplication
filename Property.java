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

public class Property {
	private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    // Default constructor
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.rentAmount = 0.0;
        this.owner = "";
    }
    
    // Parameterized constructor
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    // Copy constructor
    public Property(Property other) {
        this.propertyName = other.propertyName;
        this.city = other.city;
        this.rentAmount = other.rentAmount;
        this.owner = other.owner;
    }
    
    public String getPropertyName() { 
    		return propertyName; 
    }
    public String getCity() { 
    		return city; 
    }
    public double getRentAmount() { 
    		return rentAmount; 
    }
    public String getOwner() { 
    		return owner; 
    }
    
    public void setPropertyName(String propertyName) { 
    		this.propertyName = propertyName; 
    }
    public void setCity(String city) { 
    		this.city = city; 
    }
    public void setRentAmount(double rentAmount) { 
    		this.rentAmount = rentAmount; 
    }
    public void setOwner(String owner) { 
    		this.owner = owner; 
    }
    
    @Override
    public String toString() {
        return propertyName + ", " + city + ", Owner: " + owner + ", Rent: $" + String.format("%.2f", rentAmount);
    }
}
