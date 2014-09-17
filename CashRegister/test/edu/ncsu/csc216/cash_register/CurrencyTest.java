/**
 * 
 */
package edu.ncsu.csc216.cash_register;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality of the Currency class
 * @author Wesley Coats
 */
public class CurrencyTest {
	 	/** Currency object with the value of a penny */
	   private Currency penny;
	   /** Currency object with the value of a nickel */
	   private Currency nickel;
	   /** Currency object with the value of a dime */
	   private Currency dime;
	   /** Currency object with the value of a quarter */
	   private Currency quarter;
	   /** Currency object with the value of a dollar */
	   private Currency dollar;
	   /** Currency object with the value of five dollars */
	   private Currency five;
	   /** Currency object with the value of ten dollars */
	   private Currency ten;
	   /** Currency object with the value of twenty dollars */
	   private Currency twenty;

	/**
    * Sets up the CurrencyTest by creating representative Currency objects:
    * with the value of a penny, nickel, dime, quarter, one dollar, five, ten, and twenty.
	* @throws java.lang.Exception
	*/
	@Before
	public void setUp() throws Exception {
		penny = new Currency(CurrencyCollection.PENNY_VALUE, CurrencyCollection.PENNY_NAME, 10);
		nickel = new Currency(CurrencyCollection.NICKEL_VALUE, CurrencyCollection.NICKEL_NAME, 10);
		dime = new Currency(CurrencyCollection.DIME_VALUE, CurrencyCollection.DIME_NAME, 10);
		quarter = new Currency(CurrencyCollection.QUARTER_VALUE, CurrencyCollection.QUARTER_NAME, 10);
	    dollar = new Currency(CurrencyCollection.ONE_VALUE, CurrencyCollection.ONE_NAME, 10);
	    five = new Currency(CurrencyCollection.FIVE_VALUE, CurrencyCollection.FIVE_NAME, 10);
	    ten = new Currency(CurrencyCollection.TEN_VALUE, CurrencyCollection.TEN_NAME, 10);
	    twenty = new Currency(CurrencyCollection.TWENTY_VALUE, CurrencyCollection.TWENTY_NAME, 10);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#hashCode()}.
	 */
	@Test
	public void testHashCode() {
			//Create a new penny object that has the same state as our 
		   //field named penny
		   Currency penny2 = new Currency(CurrencyCollection.PENNY_VALUE, CurrencyCollection.PENNY_NAME, 10);
			
		   //Assert that both of these objects have the same has code.
		   //When using assertTrue, the expected value is true.  The actual
		   //value is the result of the argument.
		   assertTrue(penny.hashCode() == penny2.hashCode());
			
		   //Assert that the penny and dollar objects have different
		   //hashcodes.
		   assertTrue(penny.hashCode() != dollar.hashCode());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#getValue()}.
	 */
	@Test
	public void testGetValue() {
		   //The PENNY_VALUE constant is our expected value
		   //The actual value is the call to the getValue() method
		   assertEquals(CurrencyCollection.PENNY_VALUE, penny.getValue());
		   
		   //The NICKEL_VALUE constant is our expected value
		   //The actual value is the call to the getValue() method
		   assertEquals(CurrencyCollection.NICKEL_VALUE, nickel.getValue());
		   
		   //The DIME_VALUE constant is our expected value
		   //The actual value is the call to the getValue() method
		   assertEquals(CurrencyCollection.DIME_VALUE, dime.getValue());
		   
		   //The QUARTER_VALUE constant is our expected value
		   //The actual value is the call to the getValue() method
		   assertEquals(CurrencyCollection.QUARTER_VALUE, quarter.getValue());
		   
		   //The ONE_VALUE constant is our expected value
		   //The actual value is the call to the getValue method
		   assertEquals(CurrencyCollection.ONE_VALUE, dollar.getValue());
		   
		   //The FIVE_VALUE constant is our expected value
		   //The actual value is the call to the getValue method
		   assertEquals(CurrencyCollection.FIVE_VALUE, five.getValue());
		   
		   //The TEN_VALUE constant is our expected value
		   //The actual value is the call to the getValue method
		   assertEquals(CurrencyCollection.TEN_VALUE, ten.getValue());
		   
		   //The TWENTY_VALUE constant is our expected value
		   //The actual value is the call to the getValue method
		   assertEquals(CurrencyCollection.TWENTY_VALUE, twenty.getValue());
		}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#getName()}.
	 */
	@Test
	public void testGetName() {
			//The PENNY_NAME constant is our expected value
		   //The actual value is the call to the getName() method
		   assertEquals(CurrencyCollection.PENNY_NAME, penny.getName());
		   
		   //The NICKEL_NAME constant is our expected value
		   //The actual value is the call to the getName() method
		   assertEquals(CurrencyCollection.NICKEL_NAME, nickel.getName());
		   
		   //The DIME_NAME constant is our expected value
		   //The actual value is the call to the getName() method
		   assertEquals(CurrencyCollection.DIME_NAME, dime.getName());
		   
		   //The QUARTER_NAME constant is our expected value
		   //The actual value is the call to the getName() method
		   assertEquals(CurrencyCollection.QUARTER_NAME, quarter.getName());
		   
		   //The ONE_NAME constant is our expected value
		   //The actual value is the call to the getName() method
		   assertEquals(CurrencyCollection.ONE_NAME, dollar.getName());
		   
		   //The FIVE_NAME constant is our expected value
		   //The actual value is the call to the getName() method
		   assertEquals(CurrencyCollection.FIVE_NAME, five.getName());
		   
		   //The TEN_NAME constant is our expected value
		   //The actual value is the call to the getName() method
		   assertEquals(CurrencyCollection.TEN_NAME, ten.getName());
		   
		   //The TWENTY_NAME constant is our expected value
		   //The actual value is the call to the getName() method
		   assertEquals(CurrencyCollection.TWENTY_NAME, twenty.getName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#getCount()}.
	 */
	@Test
	public void testGetCount() {
			//We started all currencies with 10 so 10 is our expected value
		   //The actual value is the call to the getCount() method
		   assertEquals(10, penny.getCount());
		   assertEquals(10, nickel.getCount());
		   assertEquals(10, dime.getCount());
		   assertEquals(10, quarter.getCount());
		   assertEquals(10, dollar.getCount());
		   assertEquals(10, five.getCount());
		   assertEquals(10, ten.getCount());
		   assertEquals(10, twenty.getCount());
		   
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#modifyCount(int)}.
	 * The test uses the getCount() method to understand how the 
	 * count is changed when using the modifyCount() method
	 */
	@Test
	public void testModifyCount() {
				//Ensure we're starting with 10 pennies
				//We can't assume that the getCount() method has been tested at this point
				//so this is our sanity check that we can use the getCount() method to evaluate
				//modifyCount()
				//10 is our expected value and penny.getCount() is our actual value
				assertEquals(10, penny.getCount());
				
				//Increase the count of pennies by 3
				penny.modifyCount(3);
				
				//Check that the count changed
				assertEquals(13, penny.getCount());
				
				//Decrease the count of pennies by 5
				penny.modifyCount(-5);
				
				//Check that the count changed
				assertEquals(8, penny.getCount());
				
				try {
			        //Decrease the count of pennies by 9
					penny.modifyCount(-9);
					fail(); //We should never reach this point, if we do, the test fails
				} catch (IllegalArgumentException e) {		
				//Check that the count did NOT change
				assertEquals(8, penny.getCount());
				}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.Currency#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		//Create a new penny object that has the same state as our 
		   //field named penny
		   Currency penny2 = new Currency(CurrencyCollection.PENNY_VALUE, CurrencyCollection.PENNY_NAME, 10);
					
		   //Assert that both of these objects are the same using the 
		   //equals method.
		   //When using assertTrue, the expected value is true.  The actual
		   //value is the result of the argument.
		   assertTrue(penny.equals(penny2));
				
		   //Assert that the penny and dollar objects are not the same.
		   //When using assertFalse, the expected value is false.  The actual
		   //value is the result of the argument.
		   assertFalse(penny.equals(dollar));
	}

}
