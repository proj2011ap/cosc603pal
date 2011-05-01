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
		r2.setName(name);
		r2.setAmtChocolate(amtChocolate);
		r2.setAmtCoffee(amtCoffee);
		r2.setAmtMilk(amtMilk);
		r2.setAmtSugar(amtSugar);
		r2.setPrice(price);
	}

	@After
	public void tearDown() throws Exception {
		r2 = null;
		cm = null;
	}	
	
	@Test
	public final void testGetAmtChocolate() {
		assertEquals(1, r2.getAmtChocolate());		
	}
	
	@Test
	public final void testSetAmtChocolate() {
		r2.setAmtChocolate(amtChocolate);
		assertEquals(amtChocolate, r2.getAmtChocolate());
	}
	
	@Test
	public final void testGetAmtCoffee() {
		assertEquals(3, r2.getAmtCoffee());
	}

	@Test
	public final void testSetAmtCoffee() {
		r2.setAmtChocolate(amtCoffee);
		assertEquals(amtCoffee, r2.getAmtCoffee());
	}

	@Test
	public final void testGetAmtMilk() {
		assertEquals(3, r2.getAmtMilk());
	}

	@Test
	public final void testSetAmtMilk() {
		r2.setAmtChocolate(amtMilk);
		assertEquals(amtMilk, r2.getAmtMilk());
	}

	@Test
	public final void testGetAmtSugar() {
		assertEquals(2, r2.getAmtSugar());
	}

	@Test
	public final void testSetAmtSugar() {
		r2.setAmtChocolate(amtSugar);
		assertEquals(amtSugar, r2.getAmtSugar());
	}

	@Test
	public final void testGetName() {			
		assertEquals("cappuccino", r2.getName().toString());
	}

	@Test
	public final void testSetName() {
		assertEquals(name, r2.getName().toString());
	}

	@Test
	public final void testGetPrice() {
		assertEquals(70, r2.getPrice());
	}

	@Test
	public final void testSetPrice() {
		assertEquals(price, r2.getPrice());
		
	}

	@Test
	public final void testEqualsRecipe() {		
		assertEquals("cappuccino", r2.getName());
		Recipe r4 = new Recipe();
		cm.editRecipe(r2, r4);		
		assertFalse(r4.equals(r2));
	}

	@Test
	public final void testToString() {
		assertEquals("cappuccino", r2.toString());
	}	

}
