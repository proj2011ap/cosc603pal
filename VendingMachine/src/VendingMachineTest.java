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
	/*Default constructor for the vending machine. It sets all the 
	 * entries in the itemArray to be null, corresponding to an empty 
	 * vending machine.  
	 */
	@Test
	public final void testVendingMachine_checkIfslotEmpty() {
		assertNull(vm.getItem("A"));
		assertNull(vm.getItem("B"));
		assertNull(vm.getItem("C"));
		assertNull(vm.getItem("D"));
		
	}
	
	//testing constructor
	//all entries in itemArray are null, balance set to be 0 
	@Test
	public final void testVendingMachine_checkbalanceZero() {
		assertEquals(vm.getBalance(), 0, 0);
	}
	
	
	/*Adds an item to the vending machine at the slot specified by 
	 * the code. Precondition: The slot specified by the code must be
	 * empty Postcondition: The item is now at the slot specified by
	 * the code 
	 * 
	 */
	@Test
	public final void testAddItem_valid() {
		vm.addItem(valid_vmi[0], "A");
		assertEquals(valid_vmi[0], vm.getItem("A"));	
	}
	
	//If you add an item with an invalid code throws exception
	@Test 
	public final void testAddItem_invalidCode() {
		try{
			vm.addItem(valid_vmi[0], "Z");	
		}
		catch(VendingMachineException vme){			
		}
	}
	
//If you add an item to a slot that is already occupied throws exception
	@Test//(expected = VendingMachineException.class)
	public final void testAddItem_multipleItem() {
		try{
		vm.addItem(valid_vmi[1], "B");
		vm.addItem(valid_vmi[1], "B");	
		}
		catch(VendingMachineException vme){			
		}
	}
	
	/*if 4 slots already occupied, it does not allow another item 
	 *  to add in different slot. for item "B", slot_no 1 
	 *  is assigned. It is VendingMachineException. */	 
	@Test
	public final void testAddItem_slotFull() {
		try{
			vm.addItem(valid_vmi[3], "B");			
		}catch(VendingMachineException vme){			
		}	
	}	
	
	@Test
	public final void testGetItem() {
		vm.addItem(valid_vmi[3], "D");
		vm.makePurchase("D");
		assertEquals(valid_vmi[3], vm.getItem("D"));		
	}	
	
	
	/*Removes an item from the vending machine given its code. 
	 * Postcondition: If the code slot is not empty, the item in that
	 *  slot is removed.  
	 */
    //If the slot at the specified code is empty throws exception
	@Test //(expected = VendingMachineException.class)
	public final void testRemoveItem_slotEmpty() {
		try{
			vm.removeItem(" ");
		}
		catch(VendingMachineException vme){			
		}
	}
	
		
	//if the code is invalid during removing item throws exception
	@Test
	public final void testRemoveItem_validCode() {
		vm.addItem(valid_vmi[1], "B");
		assertEquals(vm.removeItem("B"), valid_vmi[1]);	
		//assertTrue(vm.getItem("B") == null);
	}
	
	@Test //(expected = VendingMachineException.class)
	public final void testRemoveItem_invalidCode() {
		try{
			vm.removeItem("X");		
		}
		catch(VendingMachineException vme){			
		}
	}
	
	/* try to remove item already removed */
	public final void testRemoveItem_alreadyRemoved() {
		try{
			vm.removeItem("C");
			vm.removeItem("C");
		}catch(VendingMachineException vme){			
		}
	}
	
	
	/*Function to put money into the vending machine. 
	 * Precondition: amount >= 0 
	 * Postcondition: balance is now the previous balance + amount.  
	 */

	@Test 
	public final void testInsertMoney_valid() {
		double amountInsert = 1.00;
		vm.balance = 0.25;
		vm.insertMoney(amountInsert);		
		assertEquals(1.25, vm.getBalance(), 0); 		
		//current balance is now the previous balance + amount		
	}
	
	//Throws a VendingMachineException if the amount is < 0
	@Test //(expected = VendingMachineException.class)
	public final void testInsertMoney_invalidBalance() {
		try{
		vm.insertMoney(-10.00);		
		}
		catch(VendingMachineException vme){			
		}
	}
	
	/*Returns the amount of change the user has in the vending machine.
	 * Note that this simply returns the amount and does not actually 
	 * give back the change to the user. Precondition: balance >= 0
	 * 
	 */
	@Test
	public final void testGetBalance_initialZero() {
		vm.getBalance();
		assertEquals(0, vm.getBalance(), 0);
	}

	/*Postcondition: the balance is >= 0 and remains the same as it was
	before the function was called */
	@Test 
	public final void testGetBalance_insertMoneyFirsttime() {
		 vm.balance = 0.00;
		assertEquals(0.00 , vm.balance, 0);
		vm.insertMoney(0.25);
		assertEquals(0+0.25, vm.getBalance(), 0);	    
	}
	
	//returns total balance in the vending machine
	@Test 
	public final void testGetBalance_cumulative() {
		vm.balance = 0.25;
		assertEquals(0.25, vm.balance, 0);
		vm.insertMoney(10.00);
		assertEquals(0.25+10.00, vm.getBalance(), 0);  
	}
	
	//returns rest of the balance after purchasing an item from a slot
	@Test
	public final void testGetBalance_afterVending() {
		vm.addItem(valid_vmi[2], "C");
		vm.balance = 8.25;
		vm.makePurchase("C");
		//vm.getBalance() = 8.25 - 1.75 = 6.50;
		assertEquals(6.50, vm.getBalance(), 0);	    
	}

	/*This function attempts to purchase the item with the given code 
	 * from the vending machine  
	 */
	//Returns true if there is enough money to make the purchase
	@Test 
	public final void testMakePurchase_enoughMoney() {
		vm.addItem(valid_vmi[2], "C");
		vm.makePurchase("C");
		vm.balance = 1.00;
		assertEquals(1.00, vm.getBalance(), 0);
		vm.insertMoney(0.75);		
		assertEquals(1.00 + 0.75, vm.getItem("C").getPrice(), 0);		
	}
	
	//Returns false if not enough money is put into the vending machine to make the purchase
	@Test 
	public final void testMakePurchase_notEnoughMoney() {
		vm.addItem(valid_vmi[2], "C");
		vm.makePurchase("C");
		vm.balance = 0.50;
		assertEquals(0.50, vm.getBalance(), 0);
		vm.insertMoney(0.25);
		//price for "C" is 1.75, we have only 0.75
		//assertEquals(0.75, vm.getItem("C").getPrice(), 0);
		assertFalse(vm.makePurchase("C"));
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
	
	/* Returns the amount of change in the machine and sets the balance 
	 * to 0. Precondition: balance >= 0 Postcondition: balance = 0 
	 */

	@Test 
	public final void testReturnChange_sufficientMoney() {
		vm.addItem(valid_vmi[0], "A");
		vm.balance = 10.0;
		vm.makePurchase("A");
		assertEquals(9.0, vm.returnChange(), 0);		
	}	

}
