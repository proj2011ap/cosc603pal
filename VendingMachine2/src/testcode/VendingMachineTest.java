package testcode;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import actualcode.VendingMachine;
import actualcode.VendingMachineItem;


public class VendingMachineTest {
	VendingMachine vm;
	VendingMachineItem[] valid_vmi;
	double price;

	@Before
	public void setUp() throws Exception {
		VendingMachine vm = new VendingMachine();
		VendingMachineItem[] valid_vmi = new VendingMachineItem[4];
		price = 0.00;
		valid_vmi[0] = new VendingMachineItem("coke", 1.0);
		valid_vmi[1] = new VendingMachineItem("sprite", 1.50);
		valid_vmi[2] = new VendingMachineItem("mdew", 1.75);
		valid_vmi[3] = new VendingMachineItem("pepsi", 1.25);
	}

	@After
	public void tearDown() throws Exception {
		vm = null;
		valid_vmi = null;
	}
	
	//testing constructor
	@Test
	public final void testVendingMachine_checkslotEmpty() {
		
	}
	//testing constructor
	@Test
	public final void testAddItem_checkbalanceZero() {
		
	}

	@Test
	public final void testRemoveItem() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testInsertMoney() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetBalance() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testMakePurchase() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testReturnChange() {
		fail("Not yet implemented"); // TODO
	}

}
