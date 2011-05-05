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
	private Recipe r1, r2, r3, r4, r5;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();
		r1 = new Recipe();		
		r2 = new Recipe();
		r3 = new Recipe();		
		r4 = new Recipe();
		r5 = new Recipe();		
		
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
	public void testAddRecipe1_notMoreThanFour() {		
		cm.addRecipe(r1);	
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		cm.addRecipe(r5);
		assertFalse(cm.addRecipe(r5));
		//assertNotNull(r1);
	}
	
	@Test
	public void testAddRecipe1_alreadyExists() {		
		cm.addRecipe(r1);	
		cm.addRecipe(r1);
		cm.addRecipe(r3);
		cm.addRecipe(r4);		
		assertFalse(cm.addRecipe(r1));		
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
	public void testEditRecipe1_with5thRecipe() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);		
		Recipe r5 = new Recipe();		
		assertFalse(cm.editRecipe(r3, r5));
	}
	
	@Test
	public void testEditRecipe1_withOldRecipe() {	
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.addRecipe(r4);
		Recipe r2 = new Recipe();		
		assertFalse(cm.editRecipe(r3, r2));
	}
	
	@Test
	public void testEditRecipe1_Recipe() {	
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		r3.equals(r2);
		//assertFalse(cm.addRecipe(r2));		
		assertFalse(cm.editRecipe(r3, r2));
	}
	
	@Test
	public final void testSetName1() {
		assertEquals(name, r1.getName());		
		}
	
	@Test
	public final void testGetName1() {			
		assertEquals("Coffee", r1.getName().toString());
	}
	
	@Test
	public final void testSetChocolate1() {
		assertEquals(amtChocolate, r1.getAmtChocolate());
		}
	
	@Test
	public final void testSetMilk1() {
		assertEquals(amtMilk, r1.getAmtMilk());		
	}
	
	@Test
	public final void testSetCoffee1() {
		assertEquals(amtCoffee, r1.getAmtCoffee());
	}
	
	@Test
	public final void testSetSugar1() {
		assertEquals(amtSugar, r1.getAmtSugar());
	}
	
	@Test
	public void testAddInventory1(){
		cm.addInventory(15, 15, 15, 15);
		assertNotNull(i);		
	}	
	
	@Test
	public void testAddInventory_negAmt(){	
		cm.addRecipe(r1);		
		i.setChocolate(0);
		i.setCoffee(0);
		i.setMilk(0);
		i.setSugar(0);
		cm.addInventory(-15, -15, -15, -15);
		assertFalse(i.enoughIngredients(r1));			
	}
	
	@Test//added to kill COR_6 in addInventory, but did not work
	public void testAddInventory_ngAmtAddedSugChoco(){	
		cm.addRecipe(r1);		
		i.setChocolate(1);
		i.setCoffee(1);
		i.setMilk(1);
		i.setSugar(1);
		cm.addInventory(15, 15, -10, -10);
		assertFalse(i.enoughIngredients(r1));			
	}	
	
	@Test
	public void testAddInventory_getTotalAmtInventory(){	
		i.setChocolate(5);
		i.setCoffee(5);
		i.setMilk(5);
		i.setSugar(5);
		cm.addInventory(105, 105, 105, 105);
		assertEquals(110, i.getChocolate());			
		assertEquals(110, i.getCoffee());
		assertEquals(110, i.getMilk());
		assertEquals(110, i.getSugar());
	}	
	
	
		
	@Test
	public void testCheckInventory1(){
		assertNotNull(cm.addInventory(15, 15, 15, 15));
		cm.addRecipe(r1);
		assertTrue(i.enoughIngredients(r1));				
	}
	
	@Test
	public void testMakeCoffee1(){
		assertTrue(i.enoughIngredients(r1));
		assertNotNull(cm);
		int amtPaid = 60;
		assertEquals(50, r1.getPrice());
		assertEquals(10, amtPaid - r1.getPrice());		
	}	
		
	
	@Test
	public void testCanMakeCoffee1(){
		assertTrue(i.enoughIngredients(r1));
		cm.addRecipe(r1);
		assertEquals(50, r1.getPrice());
		assertNotNull(cm.makeCoffee(r1, 50));			
	} 
	

	@Test//to kill AORB_29, AORB_36, LOI_41 in makeCoffe() method
	public void testCanMakeCoffee1_setInventory(){
		assertTrue(i.enoughIngredients(r1));
		cm.addRecipe(r1);
		assertEquals(50, r1.getPrice());
		cm.makeCoffee(r1, 50);	
		assertEquals(13, i.getSugar() - r1.getAmtSugar());
		assertEquals(15, i.getCoffee()- r1.getAmtCoffee());
		assertEquals(13, i.getMilk() - r1.getAmtSugar());
		assertEquals(15, i.getChocolate() - r1.getAmtChocolate());
		assertEquals(10, cm.makeCoffee(r1, 60));
		assertEquals(20, cm.makeCoffee(r1, 20));
	} 
	
		
	@Test
	public void testCanNotMakeCoffee_lessResource(){
		i.setChocolate(1);
		i.setCoffee(1);
		i.setMilk(1);
		i.setSugar(0);
		assertFalse(i.enoughIngredients(r1));
		cm.addRecipe(r1);
		assertEquals(50, r1.getPrice());
		assertNotNull(cm.makeCoffee(r1, 50));			
	} 
	
	@Test
	public void testCanMakeCoffee_lessPricePaid(){
		assertTrue(i.enoughIngredients(r1));		
		int amtPaid = 40;
		r1.setPrice(50);
		assertNotSame(50,cm.makeCoffee(r1, 40));
	//	assertEquals(10, amtPaid - r1.getPrice());								
	}	
		
	@Test
	public void testCanMakeCoffee_returnNegPricePaid(){
		assertTrue(i.enoughIngredients(r1));		
		r1.setPrice(50);	
		int amtPaid = -100;
		assertEquals(-150, amtPaid - r1.getPrice());
		assertFalse(cm.getRecipes().equals(r1));								
	} 
	
	@Test
	public void testCanMakeCoffee_returnNoPricePaid(){
		assertTrue(i.enoughIngredients(r1));		
		r1.setPrice(50);	
		int amtPaid = 0;
		assertEquals(-50, amtPaid - r1.getPrice());
		assertFalse(cm.getRecipes().equals(r1));								
	} 
	
	@Test
	public void testGetRecipes1(){
		assertTrue(cm.checkInventory().enoughIngredients(r1));
		cm.addRecipe(r1);		
		assertNotNull(cm.getRecipes());			
	}	
	
	@Test
	public void testGetRecipeForName1(){
		cm.addRecipe(r1);
		//cm.deleteRecipe(r1);
		assertEquals("Coffee", cm.getRecipeForName(name).toString());		
	} 

}