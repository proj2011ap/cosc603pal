package edu.towson.cosc603.coffeemaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import junit.framework.TestCase;

/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private String name = "Coffee";
    private int price = 50;
    private int amtCoffee = 6;
    private int amtMilk = 1;
    private int amtSugar = 1;
    private int amtChocolate = 0;
    
	private CoffeeMaker cm;
	private Inventory i;
	private Recipe r1;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();
		r1 = new Recipe();		
		
		r1.setName("Coffee");		
		r1.setPrice(50);
		r1.setAmtCoffee(6); 
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	}
	
	@Test
	public void testAddRecipe1() {		
		assertTrue(cm.addRecipe(r1));		
		//assertNotNull(r1);
	}
	
	@Test
	public void testDeleteRecipe1() {
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}
	
	@Test
	public void testEditRecipe1() {
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		newRecipe.setAmtSugar(2);
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	@Test
	public final void testSetName() {
		assertEquals(name, r1.getName());		
		}
	
	@Test
	public final void testGetName() {			
		assertEquals("Coffee", r1.getName().toString());
	}
	
	@Test
	public final void testSetChocolate() {
		assertEquals(amtChocolate, r1.getAmtChocolate());
		}
	
	@Test
	public final void testSetMilk() {
		assertEquals(amtMilk, r1.getAmtMilk());		
	}
	
	@Test
	public final void testSetCoffee() {
		assertEquals(amtCoffee, r1.getAmtCoffee());
	}
	
	@Test
	public final void testSetSugar() {
		assertEquals(amtSugar, r1.getAmtSugar());
	}
	
	@Test
	public void testAddInventory(){
		cm.addInventory(15, 15, 15, 15);
		assertNotNull(i);		
	}	
		
	@Test
	public void testCheckInventory(){
		assertNotNull(cm.addInventory(15, 15, 15, 15));
		cm.addRecipe(r1);
		assertTrue(i.enoughIngredients(r1));				
	}
	
	@Test
	public void testMakeCoffee(){
		assertTrue(i.enoughIngredients(r1));
		assertNotNull(cm);
		int amtPaid = 60;
		assertEquals(50, r1.getPrice());
		assertEquals(10, amtPaid - r1.getPrice());		
	}
	
	@Test
	public void testCanMakeCoffee(){
		assertTrue(i.enoughIngredients(r1));
		cm.addRecipe(r1);
		assertEquals(50, r1.getPrice());
		assertNotNull(cm.makeCoffee(r1, 50));			
	}
	
	@Test
	public void testGetRecipes(){
		assertTrue(cm.checkInventory().enoughIngredients(r1));
		cm.addRecipe(r1);		
		assertNotNull(cm.getRecipes());			
	}	
	
	@Test
	public void testGetRecipeForName(){
		cm.addRecipe(r1);
		//cm.deleteRecipe(r1);
		assertEquals("Coffee", cm.getRecipeForName(name).toString());		
	} 

}