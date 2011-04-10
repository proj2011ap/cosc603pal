package actualcode;
//import static org.junit.Assert.*;

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
	String iname = "chocolate";
	double iprice = 1.50;
	VendingMachineItem vi = new VendingMachineItem(iname, iprice);
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/** this method tests the constructor with valid item price
	 * Test method for {@link VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test
	public final void testVendingMachineItem_valid() {
		VendingMachineItem item = new VendingMachineItem("Kitkat", 1.50);
		assertEquals("Kitkat", item.getName());	
		assertEquals(1.50, item.getPrice(), 0);
	}
		
	@Test(expected = actualcode.VendingMachineException.class)
	public final void testVendingMachineItem_invalidPrice() {
		VendingMachineItem item = new VendingMachineItem("Lays", -1.00);
		//assertEquals("Lays", item.getName());
		//assertEquals(-1.00, item.getPrice(), 0);
	}

	/**
	 * Test method for {@link VendingMachineItem#getName()}.
	 */
	@Test
	public final void testGetName() {
		assertEquals(iname, vi.getName());
	}

	/**
	 * Test method for {@link VendingMachineItem#getPrice()}.
	 */
	@Test
	public final void testGetPrice() {
		assertEquals(iprice, vi.getPrice(), 0);
	}

}
