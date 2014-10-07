/**
 * 
 */
package edu.ncsu.csc216.shipping_simulator.pkg;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation;

/**
 * @author Wesley
 *
 */
public class RegularBookShipmentTest {
	
	private ItemToShip bookpack1;
	
	private ShipmentProcessStation[] station;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ItemToShip bookpack1 = new RegularBookShipment(1, 10);
		ShipmentProcessStation[] station = new ShipmentProcessStation[3];
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.RegularBookShipment#getInLine()}.
	 */
	@Test
	public void testGetInLine() {
		bookpack1.getInLine(station);
		assertEquals(false, bookpack1.isWaitingInLineAtStation());
		assertEquals(1, bookpack1.getStationIndex());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.RegularBookShipment#getColor()}.
	 */
	@Test
	public void testGetColor() {
		assertEquals(Color.blue, bookpack1.getColor());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.RegularBookShipment#RegularBookShipment(int, int)}.
	 */
	@Test
	public void testRegularBookShipment() {
		
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#ItemToShip(int, int)}.
	 */
	@Test
	public void testItemToShip() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getArrivalTime()}.
	 */
	@Test
	public void testGetArrivalTime() {
		assertEquals(1, bookpack1.getArrivalTime());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getWaitTime()}.
	 */
	@Test
	public void testGetWaitTime() {
		assertEquals(0, bookpack1.getWaitTime());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#setWaitTime(int)}.
	 */
	@Test
	public void testSetWaitTime() {
		bookpack1.setWaitTime(30);
		assertEquals(30, bookpack1.getWaitTime());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getProcessTime()}.
	 */
	@Test
	public void testGetProcessTime() {
		assertEquals(10, bookpack1.getProcessTime());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getStationIndex()}.
	 */
	@Test
	public void testGetStationIndex() {
		assertEquals(1, bookpack1.getStationIndex());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#isWaitingInLineAtStation()}.
	 */
	@Test
	public void testIsWaitingInLineAtStation() {
		assertFalse(bookpack1.isWaitingInLineAtStation());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#removeFromWaitingLine()}.
	 */
	@Test
	public void testRemoveFromWaitingLine() {
		bookpack1.removeFromWaitingLine();
		assertFalse(bookpack1.isWaitingInLineAtStation());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#setStationIndex(int)}.
	 */
	@Test
	public void testSetStationIndex() {
		bookpack1.setStationIndex(3);
		assertEquals(3, bookpack1.getStationIndex());
		//fail("Not yet implemented");
	}

}
