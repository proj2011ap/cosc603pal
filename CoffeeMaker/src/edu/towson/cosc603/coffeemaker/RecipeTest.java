package edu.towson.cosc603.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest {
	private String name = "cappuccino";
    private int price = 70;
    private int amtCoffee = 3;
    private int amtMilk = 3;
    private int amtSugar = 2;
    private int amtChocolate = 1;
    
    private Recipe r2;
    private CoffeeMaker cm;
    private Inventory i;
    
	@Before
	public void setUp() throws Exception {
		r2 = new Recipe();
		cm = new CoffeeMaker();
		i = cm.checkInventory();
	}

	@After
	public void tearDown() throws Exception {
		r2 = null;
		cm = null;
	}
	
	@Test
	public final void testSetAmtChocolate() {
		assertTrue(i.enoughIngredients(r2));
		assertTrue(cm.addRecipe(r2));
	}

	@Test
	public final void testGetAmtChocolate() {		
		//cm.addRecipe(r2);
		//assertTrue(i.enoughIngredients(r2));
		//cm.addRecipe(r2);
		
		//assertEquals(1, r2.getAmtChocolate());
	}

	
	@Test
	public final void testGetAmtCoffee() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetAmtCoffee() {
		//assertTrue(i.enoughIngredients(r2));		
		//assertTrue(r2.setAmtCoffee(3));
	}

	@Test
	public final void testGetAmtMilk() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetAmtMilk() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetAmtSugar() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetAmtSugar() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetName() {		
		//assertTrue(i.enoughIngredients(r2));
		cm.addRecipe(r2);
		assertEquals("cappuccino", r2.getName());
	}

	@Test
	public final void testSetName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetPrice() {
		assertEquals(70, cm.makeCoffee(r2, r2.getPrice()));
	}

	@Test
	public final void testSetPrice() {
		assertEquals(r2.getPrice(), cm.makeCoffee(r2, 70));
		
	}

	@Test
	public final void testEqualsRecipe() {
		cm.addRecipe(r2);
		assertTrue(cm.getRecipes().equals(r2));
	}

	@Test
	public final void testToString() {
		cm.addRecipe(r2);
		assertEquals("cappuccino", cm.getRecipes().toString());
	}

}
