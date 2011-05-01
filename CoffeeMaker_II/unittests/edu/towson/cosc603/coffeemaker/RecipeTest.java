package edu.towson.cosc603.coffeemaker;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest extends TestCase {
	private String name = "cappuccino";
    private int price ; //= 70
    private int amtCoffee ; //= 3
    private int amtMilk ; //= 3
    private int amtSugar ; //= 2
    private int amtChocolate; //= 1
    
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
	public final void testGetAmtChocolate3() {
		r2.setAmtChocolate(1);
		assertEquals(1, r2.getAmtChocolate());		
	}
	
	@Test
	public final void testSetAmtChocolate3() {
		r2.setAmtChocolate(amtChocolate);
		assertEquals(amtChocolate, r2.getAmtChocolate());
	}
	
	@Test
	public final void testSetAmtChocolate_negativeAmt() {
		r2.setAmtChocolate(-2);
		assertEquals(0, r2.getAmtChocolate());
	}
	
	@Test
	public final void testGetAmtCoffee3() {
		r2.setAmtCoffee(3);
		assertEquals(3, r2.getAmtCoffee());
	}	

	@Test
	public final void testSetAmtCoffee3() {
		r2.setAmtCoffee(amtCoffee);
		assertEquals(amtCoffee, r2.getAmtCoffee());
	}
	
	@Test
	public final void testSetAmtCoffee_negativeAmt() {
		r2.setAmtCoffee(-5);
		assertEquals(0, r2.getAmtCoffee());
	}

	@Test
	public final void testGetAmtMilk3() {
		r2.setAmtMilk(3);
		assertEquals(3, r2.getAmtMilk());
	}

	@Test
	public final void testSetAmtMilk3() {
		r2.setAmtMilk(amtMilk);
		assertEquals(amtMilk, r2.getAmtMilk());
	}
	
	@Test
	public final void testSetAmtMilk_negativeAmt() {
		r2.setAmtMilk(-2);
		assertEquals(0, r2.getAmtMilk());
	}

	@Test
	public final void testGetAmtSugar3() {
		r2.setAmtSugar(2);
		assertEquals(2, r2.getAmtSugar());
	}

	@Test
	public final void testSetAmtSugar3() {
		r2.setAmtSugar(amtSugar);
		assertEquals(amtSugar, r2.getAmtSugar());
	}
	
	@Test
	public final void testSetAmtSugar_negativeAmt() {
		r2.setAmtSugar(-3);
		assertEquals(0, r2.getAmtSugar());
	}

	@Test
	public final void testGetName3() {			
		assertEquals("cappuccino", r2.getName().toString());
	}

	@Test
	public final void testSetName3() {
		assertEquals(name, r2.getName().toString());
	}

	@Test
	public final void testGetPrice3() {
		r2.setPrice(70);
		assertEquals(70, r2.getPrice());
	}

	@Test
	public final void testSetPrice3() {
		r2.setPrice(price);
		assertEquals(price, r2.getPrice());
		
	}
	
	@Test
	public final void testSetPrice_negPrice() {
		r2.setPrice(-50);
		assertEquals(0, r2.getPrice());
		
	}

	@Test
	public final void testEqualsRecipe3() {		
		assertEquals("cappuccino", r2.getName());
		Recipe r4 = new Recipe();
		cm.editRecipe(r2, r4);		
		assertFalse(r4.equals(r2));
	}
	
	@Test
	public final void testEqualsRecipe_empty() {		
		r2.setName(" ");
		Recipe r5 = new Recipe();
		cm.editRecipe(r2, r5);
		assertEquals(" ", r2.getName());
	}

	@Test
	public final void testToString3() {
		assertEquals("cappuccino", r2.toString());
	}	

}
