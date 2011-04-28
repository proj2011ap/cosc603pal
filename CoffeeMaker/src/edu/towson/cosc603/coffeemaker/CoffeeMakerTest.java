package edu.towson.cosc603.coffeemaker;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();

		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6); // use case has 3 coffee
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}

	public void testAddRecipe1() {
		assertTrue(cm.addRecipe(r1));
	}

	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	public void testAddInventory(){
		cm.addInventory(15, 15, 15, 15);
		assertEquals(15, i.getChocolate());	
		assertEquals(15, i.getCoffee());
		assertEquals(15, i.getMilk());
		assertEquals(15, i.getSugar());
	}
	
	public void testCheckInventory(){
		assertTrue(i.enoughIngredients(r1));				
	}
	
	public void testMakeCoffee(){
		assertTrue(i.enoughIngredients(r1));
		int amtPaid = 60;
		assertEquals(10, amtPaid - r1.getPrice());		
	}
	
}