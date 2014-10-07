/**
 * 
 */
package edu.ncsu.csc216.shipping_simulator.pkg;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation;
import edu.ncsu.csc216.shipping_simulator.simulation.Log;

/**
 * @author Wesley
 *
 */
public class RushBookShipmentTest {
	
	private ItemToShip bookpack3;
	
	private ShipmentProcessStation[] station;
	
	private Log log;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log = new Log();
		bookpack3 = new RushBookShipment(1, 10);
		station = new ShipmentProcessStation[3];
			for (int i = 0; i < station.length; i++) {
				station[i] = new ShipmentProcessStation(log);
			}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.RushBookShipment#getInLine()}.
	 */
	@Test
	public void testGetInLine() {
		bookpack3.getInLine(station);
		assertEquals(false, bookpack3.isWaitingInLineAtStation());
		assertEquals(1, bookpack3.getStationIndex());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.RushBookShipment#getColor()}.
	 */
	@Test
	public void testGetColor() {
		assertEquals(Color.black, bookpack3.getColor());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.RushBookShipment#RushBookShipment(int, int)}.
	 */
	@Test
	public void testRushBookShipment() {
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
		assertEquals(0, bookpack3.getArrivalTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getWaitTime()}.
	 */
	@Test
	public void testGetWaitTime() {
		assertEquals(0, bookpack3.getWaitTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#setWaitTime(int)}.
	 */
	@Test
	public void testSetWaitTime() {
		bookpack3.setWaitTime(30);
		assertEquals(30, bookpack3.getWaitTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getProcessTime()}.
	 */
	@Test
	public void testGetProcessTime() {
		assertEquals(10, bookpack3.getProcessTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getStationIndex()}.
	 */
	@Test
	public void testGetStationIndex() {
		assertEquals(0, bookpack3.getStationIndex());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#isWaitingInLineAtStation()}.
	 */
	@Test
	public void testIsWaitingInLineAtStation() {
		assertFalse(bookpack3.isWaitingInLineAtStation());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#removeFromWaitingLine()}.
	 */
	@Test
	public void testRemoveFromWaitingLine() {
		bookpack3.removeFromWaitingLine();
		assertFalse(bookpack3.isWaitingInLineAtStation());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#setStationIndex(int)}.
	 */
	@Test
	public void testSetStationIndex() {
		bookpack3.setStationIndex(3);
		assertEquals(3, bookpack3.getStationIndex());
	}

}
