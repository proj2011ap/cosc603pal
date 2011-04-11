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

	/** this method tests the constructor with valid item price
	 * Test method for {@link VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test
	public final void testVendingMachineItem_valid() {
		VendingMachineItem item = new VendingMachineItem("Kitkat", 1.50);
		assertEquals("Kitkat", item.getName());	
		assertEquals(1.50, item.getPrice(), 0);
	}
		
	@Test(expected = VendingMachineException.class)
	public final void testVendingMachineItem_invalidPrice() {
		new VendingMachineItem("Snickers", -1.50);		
	}

	/**
	 * Test method for {@link VendingMachineItem#getName()}.
	 */
	@Test
	public final void testGetName() {
		VendingMachineItem vi = new VendingMachineItem("chocolate", 1.50);
		assertEquals("chocolate", vi.getName());
	}

	/**
	 * Test method for {@link VendingMachineItem#getPrice()}.
	 */
	@Test
	public final void testGetPrice() {
		VendingMachineItem vi = new VendingMachineItem("Kitkat", 2.50);
		assertEquals(2.50, vi.getPrice(), 0);
	}

}
