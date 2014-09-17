/**
 * 
 */
package edu.ncsu.csc216.cash_register;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality of the CashRegister class
 * @author Wesley
 *
 */
public class CashRegisterTest {
	
	/**
	 * Each day the cash register drawer starts with 10 
	 * items of each bill or coin
	 */
	private static final int INITIAL_COUNT = 10;
	/**
	 * The collection of currency in the drawer
	 */
	private CurrencyCollection cashDrawer;

	/**
	 * Sets up CashRegisterTest by creating a cashDrawer object with currency
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//Initializes the count of each piece of currency to 
				//the given constant.
				cashDrawer = new CurrencyCollection(INITIAL_COUNT);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CashRegister#getCurrentBalance()}.
	 * If there is 10 of each type of currency from penny to twenty, the total should be 36410.
	 */
	@Test
	public void testGetCurrentBalance() {
		assertEquals(36410, cashDrawer.getBalance());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CashRegister#processPurchase(int, edu.ncsu.csc216.cash_register.CurrencyCollection)}.
	 */
	@Test
	public void testProcessPurchase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CashRegister#processRefund(int)}.
	 */
	@Test
	public void testProcessRefund() {
		fail("Not yet implemented");
	}

}
