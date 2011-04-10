package actualcode;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;



public class VendingMachineTest extends TestCase {
	VendingMachine vm;
	VendingMachineItem[] valid_vmi;
		
	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
				
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
	@Test
	public final void testVendingMachine_checkIfslotEmpty() {
		assertNull(vm.getItem("A"));
		assertNull(vm.getItem("B"));
		assertNull(vm.getItem("C"));
		assertNull(vm.getItem("D"));
		
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
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testAddItem_multipleItem() {
		vm.addItem(valid_vmi[1], "A");
		vm.addItem(valid_vmi[1], "A");						
	}

	/*
	@Test
	public final void testGetItem() {		
	}
	*/

	@Test(expected = VendingMachineException.class)
	public final void testRemoveItem_slotEmpty() {
		vm.removeItem(" ");
	}
	
	@Test
	public final void testRemoveItem_validCode() {
		vm.addItem(valid_vmi[1], "B");
		assertEquals(vm.removeItem("B"), valid_vmi[1]);	
		assertTrue(vm.getItem("B") == null);
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testRemoveItem_invalidCode() {
		vm.removeItem("x");		
	}

	@Test 
	public final void testInsertMoney_valid() {
		double amountInsert = 1.00;
		vm.balance = 0.25;
		vm.insertMoney(amountInsert);		
		assertEquals(1.25, vm.getBalance(), 0); 		
		//current balance is now the previous balance + amount		
	}
	
	@Test(expected = VendingMachineException.class)
	public final void testInsertMoney_invalidBalance() {
		vm.insertMoney(-10.00);		
	}
	
	@Test
	public final void testGetBalance_initialZero() {
		vm.getBalance();
		assertEquals(0, vm.getBalance(), 0);
	}

	@Test 
	public final void testGetBalance_insertMoneyFirsttime() {
		 vm.balance = 0.00;
		assertEquals(0.00 , vm.balance, 0);
		vm.insertMoney(0.25);
		assertEquals(0+0.25, vm.getBalance(), 0);	    
	}
	
	@Test 
	public final void testGetBalance_cumulative() {
		vm.balance = 0.25;
		assertEquals(0.25, vm.balance, 0);
		vm.insertMoney(10.00);
		assertEquals(0.25+10.00, vm.getBalance(), 0);  
	}
	
	@Test
	public final void testGetBalance_afterVending() {
		vm.addItem(valid_vmi[2], "C");
		vm.balance = 8.25;
		vm.makePurchase("C");
		//vm.getBalance() = 8.25 - 1.75 = 6.50;
		assertEquals(6.50, vm.getBalance(), 0);	    
	}

	@Test 
	public final void testMakePurchase_enoughMoney() {
		vm.addItem(valid_vmi[2], "C");
		vm.makePurchase("C");
		vm.balance = 1.00;
		assertEquals(1.00, vm.getBalance(), 0);
		vm.insertMoney(0.75);		
		assertEquals(1.00 + 0.75, vm.getItem("C").getPrice(), 0);		
	}
	
	@Test 
	public final void testMakePurchase_notEnoughMoney() {
		vm.addItem(valid_vmi[2], "C");
		vm.makePurchase("C");
		vm.balance = 0.50;
		assertEquals(0.50, vm.getBalance(), 0);
		vm.insertMoney(0.25);
		//price for "C" is 1.75, we have only 0.75
		assertTrue(vm.getItem("C").getPrice()> 0.75);		
	}	
	
	//even there is sufficient balance, can't make purchase because slot is empty
	@Test 
	public final void testMakePurchase_EmptySlot() {
		vm.addItem(valid_vmi[1], "B");
		vm.balance = 2.0;
		assertEquals(2.0, vm.getBalance(), 0);
		vm.removeItem("B");			
		assertFalse(vm.makePurchase("B"));			
	}

	@Test 
	public final void testReturnChange_sufficientMoney() {
		vm.addItem(valid_vmi[0], "A");
		vm.balance = 10.0;
		vm.makePurchase("A");
		assertEquals(9.0, vm.returnChange(), 0);		
	}
	
	@Test // price of "A" is 1.00, so can not purchase due to insufficient balance
	public final void testReturnChange_insufficientMoney() {
		vm.addItem(valid_vmi[0], "A");
		vm.balance = 0.50;
		assertEquals(0.50, vm.getBalance(), 0);
		assertFalse(vm.makePurchase("A"));
	}

}
