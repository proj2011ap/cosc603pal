/**
 * 
 */
package edu.towson.cosc603.coffeemaker;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Compaq_Administrator
 *
 */
public class InventoryTest extends TestCase{
	private int amtCoffee ;
	private int amtChocolate ;
	private int amtMilk ;
	private int amtSugar ;
	private int price;
	    
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cm = new CoffeeMaker();
		r1 = new Recipe();		
		i = cm.checkInventory();
		
		r1.setName("Coffee");		
		r1.setAmtCoffee(amtCoffee); //4
		r1.setAmtMilk(amtMilk); //1
		r1.setAmtSugar(amtSugar); //1
		r1.setAmtChocolate(amtChocolate); //0
		r1.setPrice(price);//50
	//	i.setChocolate(15);// already set in Inventory.java class
	//	i.setCoffee(15);
	//	i.setMilk(15);
	//	i.setSugar(15);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cm = null;
		i = null;
		r1 = null;
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#Inventory()}.
	 */
	@Test
	public final void testInventory_enoughIngr() {
		assertNotNull(cm.addInventory(15, 15, 15, 15));
		cm.addRecipe(r1);
		assertEquals(30, i.getChocolate());
		assertEquals(30, i.getSugar());
		assertEquals(30, i.getCoffee());
		assertEquals(30, i.getMilk());		
		assertTrue(i.enoughIngredients(r1));
	}
	
	
	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getChocolate()}.
	 */
	@Test
	public final void testGetChocolate2() {
		//i.setChocolate(200);
		assertEquals(15, i.getChocolate());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setChocolate(int)}.
	 */
	@Test
	public final void testSetChocolate2() {
		i.setChocolate(200);
		assertEquals(200, i.getChocolate());
	} 
	
	@Test
	public final void testSetChocolate_negAmt() {
		i.setChocolate(-100);
		assertEquals(0, i.getChocolate());
	} 
	

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getCoffee()}.
	 */
	@Test
	public final void testGetCoffee2() {
		//i.setCoffee(200);
		assertEquals(15, i.getCoffee());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setCoffee(int)}.
	 */
 	@Test
	public final void testSetCoffee2() {
 		i.setCoffee(200);
 		assertEquals(200, i.getCoffee());
	}
 	
 	@Test
	public final void testSetCoffee_negAmt() {
 		i.setCoffee(-15);
 		assertEquals(0, i.getCoffee());
	}
	
	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getMilk()}.
	 */
	@Test
	public final void testGetMilk2() {
	//	i.setMilk(200);
		assertEquals(15, i.getMilk());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setMilk(int)}.
	 */
	@Test
	public final void testSetMilk2() {
		i.setMilk(100);
		assertEquals(100, i.getMilk());
	} 
	
	@Test
	public final void testSetMilk_negAmt() {
		i.setMilk(-100);
		assertEquals(0, i.getMilk());
	} 
	

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getSugar()}.
	 */
	@Test
	public final void testGetSugar2() {
		//i.setSugar(200);
		assertEquals(15, i.getSugar());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setSugar(int)}.
	 */
	@Test
	public final void testSetSugar2() {
		i.setSugar(150);
		assertEquals(150, i.getSugar());
	} 
	
	@Test
	public final void testSetSugar_negAmt() {
		i.setSugar(-150);
		assertEquals(0, i.getSugar());
	} 
	

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#enoughIngredients(edu.towson.cosc603.coffeemaker.Recipe)}.
	 */
	@Test
	public final void testEnoughIngredients2() {
		assertEquals(15, i.getChocolate());
		assertEquals(15, i.getSugar());
		assertEquals(15, i.getCoffee());
		assertEquals(15, i.getMilk());		
		assertTrue(i.enoughIngredients(r1));
	}
	
	@Test
	public final void testEnoughIngredients_not() {
		i.setChocolate(2);
		i.setCoffee(0);
		i.setMilk(0);
		i.setSugar(1);
		r1.setAmtChocolate(3);
		r1.setAmtCoffee(1);
		r1.setAmtMilk(4);
		r1.setAmtSugar(5);
		assertFalse(i.enoughIngredients(r1));
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#toString()}.
	 */
	@Test
	public final void testToString2() {
		assertTrue(i.enoughIngredients(r1));
		assertNotNull(i.toString());		
	}	
}
