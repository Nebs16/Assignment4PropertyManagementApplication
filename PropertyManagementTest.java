import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PropertyManagementTest {

	    @Test
	    public void testDefaultConstructor() {
	        Property p = new Property();
	        assertEquals("", p.getPropertyName());
	        assertEquals(0.0, p.getRentAmount(), 0.001);
	    }

	    @Test
	    public void testParameterizedConstructor() {
	        Property p = new Property("Oak Apartments", "Rockville", 1850.00, "Alice Chen");
	        assertEquals("Oak Apartments", p.getPropertyName());
	        assertEquals("Rockville", p.getCity());
	        assertEquals(1850.00, p.getRentAmount(), 0.001);
	        assertEquals("Alice Chen", p.getOwner());
	    }

	    @Test
	    public void testPropertyCopyConstructor() {
	        Property original = new Property("Oak Apartments", "Rockville", 1850.00, "Alice Chen");
	        Property copy = new Property(original);
	        assertNotSame(original, copy);
	        assertEquals(original.getPropertyName(), copy.getPropertyName());
	        assertEquals(original.getRentAmount(), copy.getRentAmount(), 0.001);

	        copy.setRentAmount(999.99);   // changing the copy must not affect the original
	        assertEquals(1850.00, original.getRentAmount(), 0.001);
	    }

	    @Test
	    public void testAddProperty() {
	        ManagementCompany company = new ManagementCompany("Test Co", "11-1111111");
	        assertEquals(0, company.addProperty(new Property("A", "X", 1000, "Owner1")));
	        assertEquals(1, company.addProperty(new Property("B", "Y", 1500, "Owner2")));
	        assertEquals(2, company.getPropertyCount());
	    }

	    @Test
	    public void testAddPropertyWhenFull() {
	        ManagementCompany company = new ManagementCompany("Test Co", "11-1111111");
	        for (int i = 0; i < ManagementCompany.MAX_PROPERTIES; i++) {
	            company.addProperty(new Property("P" + i, "City", 1000, "Owner"));
	        }
	        assertEquals(ManagementCompany.FULL,
	                company.addProperty(new Property("Extra", "City", 1000, "Owner")));
	        assertEquals(ManagementCompany.MAX_PROPERTIES, company.getPropertyCount());
	    }

	    @Test
	    public void testTotalRent() {
	        ManagementCompany company = new ManagementCompany("Test Co", "11-1111111");
	        assertEquals(0.0, company.totalRent(), 0.001);
	        company.addProperty(new Property("A", "X", 1200.50, "Owner1"));
	        company.addProperty(new Property("B", "Y", 1799.50, "Owner2"));
	        assertEquals(3000.00, company.totalRent(), 0.001);
	    }

	    @Test
	    public void testCompanyCopyConstructorIsDeep() {
	        ManagementCompany company = new ManagementCompany("Test Co", "11-1111111");
	        company.addProperty(new Property("A", "X", 1000, "Owner1"));
	        ManagementCompany copy = new ManagementCompany(company);

	        copy.addProperty(new Property("B", "Y", 2000, "Owner2"));
	        assertEquals(1, company.getPropertyCount());
	        assertEquals(2, copy.getPropertyCount());
	        assertEquals(1000.00, company.totalRent(), 0.001);
	        assertEquals(3000.00, copy.totalRent(), 0.001);
	    }

}
