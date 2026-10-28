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

public class ManagementCompany {
	public static final int MAX_PROPERTIES = 5;
    public static final int FULL = -1;   // error code returned when the array is full

    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;
    
    // Parameterized constructor
    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = 0;
    }
    
    // Copy constructor (deep copy so every Property is copied too)
    public ManagementCompany(ManagementCompany other) {
        this.name = other.name;
        this.taxId = other.taxId;
        this.properties = new Property[MAX_PROPERTIES];
        this.propertyCount = other.propertyCount;
        for (int i = 0; i < other.propertyCount; i++) {
            this.properties[i] = new Property(other.properties[i]);
        }
    }
    
    /**
     * Adds a copy of p to the array.
     * Returns the index where it was stored, or FULL (-1) if there is no room.
     */
    public int addProperty(Property p) {
        if (propertyCount >= MAX_PROPERTIES) {
            return FULL;
        }
        properties[propertyCount] = new Property(p);
        propertyCount++;
        return propertyCount - 1;
    }

    public double totalRent() {
        double totalR = 0;
        for (int i = 0; i < propertyCount; i++) {
            totalR += properties[i].getRentAmount();
        }
        return totalR;
    }

    public int getPropertyCount() {
        return propertyCount;
    }
    
    public String getName() { 
    		return name; 
    }
    
    public String getTaxId() { 
    		return taxId; 
    }
    
    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append("Company: ").append(name).append(" (Tax ID: ").append(taxId).append(")\n");
        strb.append("Properties (").append(propertyCount).append(" of ")
          .append(MAX_PROPERTIES).append("):\n");
        
        for (int i = 0; i < propertyCount; i++) {
        	strb.append("  ").append(i + 1).append(". ").append(properties[i]).append("\n");
        }
        
        strb.append("Total rent: $").append(String.format("%.2f", totalRent()));
        return strb.toString();
    }
    
}
