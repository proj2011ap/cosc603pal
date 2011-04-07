package testcode;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import actualcode.VendingMachine;
import actualcode.VendingMachineException;
import actualcode.VendingMachineItem;


public class VendingMachineTest {
	VendingMachine vm;
	VendingMachineItem[] valid_vmi;
	double price;

	@Before
	public void setUp() throws Exception {
		VendingMachine vm = new VendingMachine();
		VendingMachineItem[] valid_vmi = new VendingMachineItem[4];
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
	assertEquals(valid_vmi[0], "coke");
				
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testAddItem_invalid() {
	vm.addItem(valid_vmi[0], "Z");
	assertEquals(valid_vmi[0], "coke");				
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testAddItem_multipleItem() {
		vm.addItem(valid_vmi[1], "B");
		vm.addItem(valid_vmi[1], "B");
		assertEquals(valid_vmi[0], "coke");				
	}

	@Test
	public final void testGetItem() {
		//why getItem() is not accessed??
	}


	@Test
	public final void testRemoveItem_slotEmpty() {
		
	}
	
	@Test
	public final void testRemoveItem_invalidCode() {
		vm.removeItem("D");
		//????????????
		
	}

	@Test
	public final void testInsertMoney_valid() {
		vm.insertMoney(10.00);
		assertTrue(vm.getBalance() >= 10); // ??? ask??
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testInsertMoney_invalidBalance() {
		vm.insertMoney(10.00);
		assertTrue(vm.getBalance() != 10); // ??? ask??
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
		assertEquals(vm.removeItem("C"), valid_vmi[2]);
		assertEquals(vm.getBalance(), 1.75, 0);
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
