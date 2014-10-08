/**
 * 
 */
package edu.ncsu.csc216.shipping_simulator.simulation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;

/**
 * @author Wesley
 *
 */
public class LogTest {
	
	/**
	 * The number of items that have logged their information
	 * and left the simulation
	 */
	private int numCompleted;
	
	/**
	 * The sum of all wait times logged by items so far
	 */
	private int totalWaitTime;
	
	/**
	 * The sum of all times that items took to do actual processing
	 * which is not including wait time.
	 */
	private int totalProcessTime;
	
	/**
	 * The log object being constructed
	 */
	private Log log;
	
	/**
	 * The item being shipped
	 */
	private ItemToShip item;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log = new Log();
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Log#Log()}.
	 */
	@Test
	public void testLog() {
		assertEquals(0, numCompleted);
		assertEquals(0, totalWaitTime);
		assertEquals(0, totalProcessTime);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Log#getNumCompleted()}.
	 */
	@Test
	public void testGetNumCompleted() {
		assertEquals(0, log.getNumCompleted());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Log#logItem(edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip)}.
	 */
	@Test
	public void testLogItem() {
		log.logItem(item);
		assertEquals(1, log.getNumCompleted());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Log#averageWaitTime()}.
	 */
	@Test
	public void testAverageWaitTime() {
		assertEquals(0.0, log.averageWaitTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Log#averageProcessTime()}.
	 */
	@Test
	public void testAverageProcessTime() {
		assertEquals(10.0, log.averageProcessTime());
	}

}
