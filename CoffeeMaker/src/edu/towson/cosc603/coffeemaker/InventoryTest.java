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
		r1.setName("Coffee");
		i = cm.checkInventory();
		
		r1.setAmtCoffee(6); // ??use case has 3 coffee
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cm = null;
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#Inventory()}.
	 */
	@Test
	public final void testInventory_enoughIng() {
		assertTrue(i.enoughIngredients(r1));
	}
	
	
	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getChocolate()}.
	 */
	@Test
	public final void testGetChocolate() {
		assertEquals(0, r1.getAmtChocolate());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setChocolate(int)}.
	 
	@Test
	public final void testSetChocolate() {
		fail("Not yet implemented"); // TODO
	}
	*/

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getCoffee()}.
	 */
	@Test
	public final void testGetCoffee() {
		assertEquals(6, r1.getAmtCoffee());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setCoffee(int)}.
	 */
 /*	@Test
	public final void testSetCoffee() {
		fail("Not yet implemented"); // TODO
	}
	*/
	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getMilk()}.
	 */
	@Test
	public final void testGetMilk() {
		assertEquals(1, r1.getAmtMilk());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setMilk(int)}.
	 
	@Test
	public final void testSetMilk() {
		fail("Not yet implemented"); // TODO
	}
	*/

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#getSugar()}.
	 */
	@Test
	public final void testGetSugar() {
		assertEquals(1, r1.getAmtSugar());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#setSugar(int)}.
	 
	@Test
	public final void testSetSugar() {
		fail("Not yet implemented"); // TODO
	}
	*/

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#enoughIngredients(edu.towson.cosc603.coffeemaker.Recipe)}.
	 */
	@Test
	public final void testEnoughIngredients() {
		assertTrue(i.getCoffee() > r1.getAmtCoffee());
		assertTrue(i.getMilk() > r1.getAmtMilk());
		assertTrue(i.getSugar() > r1.getAmtSugar());
		assertTrue(i.getChocolate() > r1.getAmtChocolate());
	}

	/**
	 * Test method for {@link edu.towson.cosc603.coffeemaker.Inventory#toString()}.
	 
	@Test
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}
	*/

}
