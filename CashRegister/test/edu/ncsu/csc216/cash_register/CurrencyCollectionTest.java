/**
 * 
 */
package edu.ncsu.csc216.cash_register;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality of the CurrencyCollection class
 * @author Wesley Coats
 */
public class CurrencyCollectionTest {
	
	/** Array storing all the currency in the collection */
	private Currency[] currency;
	
	/** Initial count of currency in the collection */
	private static final int INITIAL_COUNT = 0;
	
	/** Number of currency slots in the collection */
	public static final int NUM_SLOTS = 8;

	/**
	 * Sets up CurrencyCollectionTest by creating a currency array and filling it with objects
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		currency = new Currency[NUM_SLOTS];
		currency[0] = new Currency(CurrencyCollection.PENNY_VALUE, CurrencyCollection.PENNY_NAME, INITIAL_COUNT);
		currency[1] = new Currency(CurrencyCollection.NICKEL_VALUE, CurrencyCollection.NICKEL_NAME, INITIAL_COUNT);
		currency[2] = new Currency(CurrencyCollection.DIME_VALUE, CurrencyCollection.DIME_NAME, INITIAL_COUNT);
		currency[3] = new Currency(CurrencyCollection.QUARTER_VALUE, CurrencyCollection.QUARTER_NAME, INITIAL_COUNT);
		currency[4] = new Currency(CurrencyCollection.ONE_VALUE, CurrencyCollection.ONE_NAME, INITIAL_COUNT);
		currency[5] = new Currency(CurrencyCollection.FIVE_VALUE, CurrencyCollection.FIVE_NAME, INITIAL_COUNT);
		currency[6] = new Currency(CurrencyCollection.TEN_VALUE, CurrencyCollection.TEN_NAME, INITIAL_COUNT);
		currency[7] = new Currency(CurrencyCollection.TWENTY_VALUE, CurrencyCollection.TWENTY_NAME, INITIAL_COUNT);	
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#getCurrencyAtIdx(int)}.
	 */
	@Test
	public void testGetCurrencyAtIdx() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#modifyDenomination(int, int)}.
	 */
	@Test
	public void testModifyDenomination() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#depositCurrencyCollection(edu.ncsu.csc216.cash_register.CurrencyCollection)}.
	 */
	@Test
	public void testDepositCurrencyCollection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#refundByAmount(int)}.
	 */
	@Test
	public void testRefundByAmount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#getCurrencyCollection()}.
	 */
	@Test
	public void testGetCurrencyCollection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.cash_register.CurrencyCollection#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		fail("Not yet implemented");
	}

}
