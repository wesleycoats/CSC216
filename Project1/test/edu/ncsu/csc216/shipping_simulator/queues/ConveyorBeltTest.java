/**
 * 
 */
package edu.ncsu.csc216.shipping_simulator.queues;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.shipping_simulator.pkg.BookShipmentFactory;
import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;

/**
 * @author Wesley
 *
 */
public class ConveyorBeltTest {
	
	/**
	 * The queue of items created by the BookShipmentFactory in the ConveyorBelt constructor.
	 * Items are added to the queue in order of their arrivalTime.
	 */
	private ShipmentQueue queueFromFactory;
	
	/**
	 * An array of shipment process stations used by the method processNext.
	 */
	private ShipmentProcessStation[] station;
	
	/**
	 * The item (book package) being created and added to the conveyor belt
	 */
	private ItemToShip item;
	
	/**
	 * The 2nd book package
	 */
	private ItemToShip item2;
	
	/**
	 * The 3rd book package
	 */
	private ItemToShip item3;
	
	private ConveyorBelt theBelt;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
			item = BookShipmentFactory.generateBookShipment();
			item2 = BookShipmentFactory.generateBookShipment();
			item3 = BookShipmentFactory.generateBookShipment();
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ConveyorBelt#ConveyorBelt(int)}.
	 */
	@Test
	public void testConveyorBelt() {
		if (queueFromFactory != null) {
			try {
				queueFromFactory.add(item);
				queueFromFactory.add(item2);
			} catch (NoSuchElementException e) {
				assertTrue(!queueFromFactory.isEmpty());
			}
		}	
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ConveyorBelt#size()}.
	 */
	@Test
	public void testSize() {
		assertEquals(3, queueFromFactory.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ConveyorBelt#hasNext()}.
	 */
	@Test
	public void testHasNext() {
		assertEquals(true, theBelt.hasNext());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ConveyorBelt#processNext()}.
	 */
	@Test
	public void testProcessNext() {
		assertEquals(station[0], theBelt.processNext());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.queues.ConveyorBelt#departTimeNext()}.
	 */
	@Test
	public void testDepartTimeNext() {
		assertEquals(3, theBelt.departTimeNext());
	}

}
