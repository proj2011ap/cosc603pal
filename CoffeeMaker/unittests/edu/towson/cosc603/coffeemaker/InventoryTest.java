/**
 * 
 */
package edu.towson.cosc603.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Compaq_Administrator
 *
 */
public class InventoryTest {
	    
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
		r1.setAmtCoffee(4); 
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		r1.setPrice(50);
		i.setChocolate(200);
		i.setCoffee(200);
		i.setMilk(200);
		i.setSugar(200);
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
		//assertEquals(15, i.getChocolate());
		//assertEquals(15, i.getSugar());
		//assertEquals(15, i.getCoffee());
		//assertEquals(15, i.getMilk());		
		assertTrue(i.enoughIngredients(r1));
	}
	
	
	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getChocolate()}.
	 */
	@Test
	public final void testGetChocolate() {
		//i.setChocolate(200);
		assertEquals(200, i.getChocolate());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setChocolate(int)}.
	 */
	@Test
	public final void testSetChocolate() {
		assertEquals(200, i.getChocolate());
	} 
	

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getCoffee()}.
	 */
	@Test
	public final void testGetCoffee() {
	//	i.setCoffee(200);
		assertEquals(200, i.getCoffee());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setCoffee(int)}.
	 */
 	@Test
	public final void testSetCoffee() {
 		assertEquals(200, i.getCoffee());
	}
	
	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getMilk()}.
	 */
	@Test
	public final void testGetMilk() {
	//	i.setMilk(200);
		assertEquals(200, i.getMilk());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setMilk(int)}.
	 */
	@Test
	public final void testSetMilk() {
		assertEquals(200, i.getMilk());
	} 
	

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getSugar()}.
	 */
	@Test
	public final void testGetSugar() {
		//i.setSugar(200);
		assertEquals(200, i.getSugar());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setSugar(int)}.
	 */
	@Test
	public final void testSetSugar() {
		assertEquals(200, i.getSugar());
	} 
	

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#enoughIngredients(edu.towson.cosc603.coffeemaker.Recipe)}.
	 */
	@Test
	public final void testEnoughIngredients() {
		assertEquals(200, i.getChocolate());
		assertEquals(200, i.getSugar());
		assertEquals(200, i.getCoffee());
		assertEquals(200, i.getMilk());		
		assertTrue(i.enoughIngredients(r1));
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#toString()}.
	 */
	@Test
	public final void testToString() {
		assertTrue(i.enoughIngredients(r1));
		assertNotNull(i.toString());		
	}	
}
