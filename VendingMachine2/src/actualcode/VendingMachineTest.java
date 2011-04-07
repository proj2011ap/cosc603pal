package actualcode;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class VendingMachineTest {
	VendingMachine vm;
	VendingMachineItem[] valid_vmi;
	//VendingMachineItem vmi;
	
	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
		//vmi = new VendingMachineItem("coke", 1.0);
		
		valid_vmi = new VendingMachineItem[4];
		valid_vmi[0] = new VendingMachineItem("coke", 1.0);
		valid_vmi[1] = new VendingMachineItem("sprite", 1.50);
		valid_vmi[2] = new VendingMachineItem("mdew", 1.75);
		valid_vmi[3] = new VendingMachineItem("pepsi", 1.25);
	}

	@After
	public void tearDown() throws Exception {
		vm = null;
		valid_vmi[0] = null;
		valid_vmi[1] = null;
		valid_vmi[2] = null;
		valid_vmi[3] = null;
	}
	
	//testing constructor
	@SuppressWarnings("static-access")
	@Test
	public final void testVendingMachine_checkslotEmpty() {
		int NUM_SLOTS = 0;
		assertEquals(valid_vmi[NUM_SLOTS], 0); // ask???????
	}
	//testing constructor
	@Test
	public final void testVendingMachine_checkbalanceZero() {
		assertEquals(vm.getBalance(), 0, 0);
	}
	
	@Test
	public final void testAddItem_valid() {
	vm.addItem(valid_vmi[0], "A");
	assertEquals(valid_vmi[0], vm.getItem("A"));				
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testAddItem_invalidCode() {
	vm.addItem(valid_vmi[0], "Z");
	//assertEquals(valid_vmi[0], "coke");				
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testAddItem_multipleItem() {
		vm.addItem(valid_vmi[1], "B");
		vm.addItem(valid_vmi[1], "B");						
	}

	@Test
	public final void testGetItem() {		
	}

	@Test(expected = VendingMachineException.class)
	public final void testRemoveItem_slotEmpty() {
		vm.removeItem(" ");
	}
	
	@Test
	public final void testRemoveItem_validCode() {
		vm.removeItem("A");
		assertEquals(vm.getItem("A"), valid_vmi[0]);		
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testRemoveItem_invalidCode() {
		vm.removeItem("x");		
	}

	@Test
	public final void testInsertMoney_valid() {
		vm.insertMoney(10.00);
		assertTrue(vm.getBalance() >= 10); // ??? ask??
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testInsertMoney_invalidBalance() {
		vm.insertMoney(-10.00);		
	}

	@Test
	public final void testGetBalance() {
		vm.getBalance();
		assertEquals(vm.getBalance(), valid_vmi[0].getPrice(), 0);
	}

	@Test
	public final void testMakePurchase_enoughMoney() {
		vm.makePurchase("C");
		vm.insertMoney(5.0);
		//assertTrue(vm.insertMoney(5.0), vm.makePurchase("C"));
		//assertEquals(vm.getItem("C").getPrice()  , valid_vmi[2].getPrice(), 0.0);
	//	assertEquals(vm.getItem("C").getPrice(), vm.makePurchase("C"));
	}
	
	@Test
	public final void testMakePurchase_emptySlot() {
		vm.makePurchase("C");
		assertEquals(vm.makePurchase("C"), valid_vmi[2].getName());
		
	}

	@Test
	public final void testReturnChange() {
		vm.returnChange();
		assertEquals(vm.returnChange(), vm.getBalance(), 0);
	}

}
