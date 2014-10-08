/**
 * 
 */
package edu.ncsu.csc216.shipping_simulator.queues;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;
import edu.ncsu.csc216.shipping_simulator.simulation.Log;

/**
 * @author Wesley
 *
 */
public class ShipmentProcessStationTest {
	
	/**
	 * The time when the queue for the station will be clear of all
	 * items currently in the queue.
	 */
	private int timeWhenAvailable;
	
	/**
	 * The ShipmentQueue of items waiting for or being processed at this station
	 */
	private ShipmentQueue line;
	
	/**
	 * The item at the front of the line logs its information here during its processing
	 */
	private Log log;

	/**
	 * The shipment process station being used
	 */
	private ShipmentProcessStation station;
	
	/**
	 * The item to ship being used
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
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation#ShipmentProcessStation(edu.ncsu.csc216.shipping_simulator.simulation.Log)}.
	 */
	@Test
	public void testShipmentProcessStation() {
		assertEquals(this.log, log);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation#size()}.
	 */
	@Test
	public void testSize() {
		assertEquals(0, line.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation#processNext()}.
	 */
	@Test
	public void testProcessNext() {
		try {
			line.remove();
		} catch (NoSuchElementException e) {
			assertEquals(2, line.size());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation#hasNext()}.
	 */
	@Test
	public void testHasNext() {
		assertTrue(line.isEmpty());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation#departTimeNext()}.
	 */
	@Test
	public void testDepartTimeNext() {
		if (line.isEmpty())
		assertEquals(Integer.MAX_VALUE, station.departTimeNext());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation#addItemToLine(edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip)}.
	 */
	@Test
	public void testAddItemToLine() {
		if (line.front() == null) {
				assertEquals(0, item.getWaitTime());
		}
	}

}
