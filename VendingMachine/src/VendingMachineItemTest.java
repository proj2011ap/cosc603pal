import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author Compaq_Administrator
 *
 */
public class VendingMachineItemTest extends TestCase {	
	VendingMachineItem vi;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {	
		VendingMachineItem vi = new VendingMachineItem("chocolate", 1.50);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		vi = null;
	}

	/** Constructor which fills in the name and price of the item 
	 * Precondition: price argument >= 0 
	 * Postcondition: The name and price of the item is set to be the 
	 * values in the arguments 
	 * this method tests the constructor with valid item price
	 * Test method for {@link VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test
	public final void testVendingMachineItem_valid() {
		VendingMachineItem item = new VendingMachineItem("Kitkat", 1.50);
		assertEquals("Kitkat", item.getName());	
		assertEquals(1.50, item.getPrice(), 0);
	}
	
	//tests constructor throwing exception if price is less than zero	
	@Test 
	public final void testVendingMachineItem_invalidPrice() {
		try{
		new VendingMachineItem("Snickers", -1.50);	
		}
		catch(VendingMachineException vme){			
		}
	}

	/**
	 * Test method for {@link VendingMachineItem#getName()}.
	 * The string corresponding to the name of the vending machine item
	 *  Postcondition: the actual name of the item is returned
	 */
	@Test
	public final void testGetName() {
		VendingMachineItem vi = new VendingMachineItem("chocolate", 1.50);
		assertEquals("chocolate", vi.getName());
	}

	/**
	 * Test method for {@link VendingMachineItem#getPrice()}.
	 * The price of the vending machine item in dollars 
	 * Postcondition: The actual price of the item is returned
	 */
	@Test
	public final void testGetPrice() {
		VendingMachineItem vi = new VendingMachineItem("Kitkat", 2.50);
		assertEquals(2.50, vi.getPrice(), 0);
	}

}
