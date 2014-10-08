/**
 * 
 */
package edu.ncsu.csc216.shipping_simulator.simulation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;
import edu.ncsu.csc216.shipping_simulator.queues.ConveyorBelt;
import edu.ncsu.csc216.shipping_simulator.queues.LineOfItems;
import edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation;

/**
 * @author Wesley
 *
 */
public class SimulatorTest {
	
	/**
	 * The minimum number of stations in the simulation
	 */
	private static final int MIN_NUM_STATIONS =3;
	
	/**
	 * The maximum number of stations in the simulation
	 */
	private static final int MAX_NUM_STATIONS = 9;
	
	/**
	 * The number of shipment process stations
	 */
	private int numStations;
	
	/**
	 * The number of items (book packages)
	 */
	private int numShipments;
	
	/**
	 * The number of steps taken in the simulation. There is a step
	 * whenever an item leaves the conveyor belt to enter a line at
	 * a shipment processing station. There is also a step whenever an item completes
	 * processing and leaves it shipment process station.
	 */
	private int stepsTaken;
	
	/**
	 * Creates the conveyor belt
	 */
	private ConveyorBelt theBelt;
	
	/**
	 * Creates the shipment process station
	 */
	private ShipmentProcessStation[] station;
	
	/**
	 * Creates the calendar to determine when events occur
	 */
	private EventCalendar myCalendar;
	
	/**
	 * Creates the log to keep track of the statistics for packages
	 */
	private Log myLog;
	
	/**
	 * Represents the item currently being handled by the simulator
	 */
	private ItemToShip currentShipment;
	
	/**
	 * A reference to LineOfItems so the step method can return the next step in the simulation
	 */
	private LineOfItems chosenItem;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#Simulator(int, int)}.
	 */
	@Test
	public void testSimulator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#step()}.
	 */
	@Test
	public void testStep() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#getStepsTaken()}.
	 */
	@Test
	public void testGetStepsTaken() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#totalNumberOfSteps()}.
	 */
	@Test
	public void testTotalNumberOfSteps() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#moreSteps()}.
	 */
	@Test
	public void testMoreSteps() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#getCurrentIndex()}.
	 */
	@Test
	public void testGetCurrentIndex() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#getCurrentShipmentColor()}.
	 */
	@Test
	public void testGetCurrentShipmentColor() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#itemLeftSimulation()}.
	 */
	@Test
	public void testItemLeftSimulation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#averageWaitTime()}.
	 */
	@Test
	public void testAverageWaitTime() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.shipping_simulator.simulation.Simulator#averageProcessTime()}.
	 */
	@Test
	public void testAverageProcessTime() {
		fail("Not yet implemented");
	}

}
