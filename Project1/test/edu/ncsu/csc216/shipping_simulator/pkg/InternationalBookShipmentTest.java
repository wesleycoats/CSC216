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
public class InternationalBookShipmentTest {
	
	private ItemToShip bookpack2;
	
	private ShipmentProcessStation[] station;
	
	private Log log;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		log = new Log();
		bookpack2 = new InternationalBookShipment(1, 25);
		station = new ShipmentProcessStation[3];
			for (int i = 0; i < station.length; i++) {
				station[i] = new ShipmentProcessStation(log);
			}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.InternationalBookShipment#getInLine()}.
	 */
	@Test
	public void testGetInLine() {
		bookpack2.getInLine(station);
		assertEquals(false, bookpack2.isWaitingInLineAtStation());
		assertEquals(1, bookpack2.getStationIndex());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.InternationalBookShipment#getColor()}.
	 */
	@Test
	public void testGetColor() {
		assertEquals(Color.yellow, bookpack2.getColor());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.InternationalBookShipment#InternationalBookShipment(int, int)}.
	 */
	@Test
	public void testInternationalBookShipment() {
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
		assertEquals(0, bookpack2.getArrivalTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getWaitTime()}.
	 */
	@Test
	public void testGetWaitTime() {
		assertEquals(0, bookpack2.getWaitTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#setWaitTime(int)}.
	 */
	@Test
	public void testSetWaitTime() {
		bookpack2.setWaitTime(30);
		assertEquals(30, bookpack2.getWaitTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getProcessTime()}.
	 */
	@Test
	public void testGetProcessTime() {
		assertEquals(25, bookpack2.getProcessTime());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#getStationIndex()}.
	 */
	@Test
	public void testGetStationIndex() {
		assertEquals(2, bookpack2.getStationIndex());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#isWaitingInLineAtStation()}.
	 */
	@Test
	public void testIsWaitingInLineAtStation() {
		assertFalse(bookpack2.isWaitingInLineAtStation());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#removeFromWaitingLine()}.
	 */
	@Test
	public void testRemoveFromWaitingLine() {
		bookpack2.removeFromWaitingLine();
		assertFalse(bookpack2.isWaitingInLineAtStation());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip#setStationIndex(int)}.
	 */
	@Test
	public void testSetStationIndex() {
		bookpack2.setStationIndex(3);
		assertEquals(3, bookpack2.getStationIndex());
	}

}
