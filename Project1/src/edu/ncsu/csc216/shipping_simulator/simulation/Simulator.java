package edu.ncsu.csc216.shipping_simulator.simulation;

import java.awt.Color;

import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;
import edu.ncsu.csc216.shipping_simulator.queues.ConveyorBelt;
import edu.ncsu.csc216.shipping_simulator.queues.LineOfItems;
import edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation;

/**
 * Oversees the simulation and creates the ConveyorBelt and
 * ShipmentProcessStations. This class also steps through the simulation
 * using the EventCalendar and reports the current state of the simulation
 * after each step using its Log.
 * @author Wesley
 */
public class Simulator {

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
	 * The constructor for the Simulator class. Uses the parameters to create a
	 * ConveyorBelt and an array of ShipmentProcessStations. It also creates the Log
	 * to keep track of shipping statistics and an event calendar to control the order of events.
	 * @param numShipments the number of items (book packages) in the simulation
	 * @param numStations the number of shipment process stations in the simulation
	 */
	public Simulator(int numStations, int numShipments) {
		if (numShipments > 0 && numStations >= MIN_NUM_STATIONS && numStations <= MAX_NUM_STATIONS) {
			myLog = new Log();
			theBelt = new ConveyorBelt(numShipments, station);
			myCalendar = new EventCalendar(station, theBelt);
			station = new ShipmentProcessStation[numStations];
				for (int i = 0; i < station.length; i++) {
					station[i] = new ShipmentProcessStation(myLog);
				}
		}
		else if (numShipments < 0 || numStations < MIN_NUM_STATIONS || numStations > MAX_NUM_STATIONS) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Handles the next event from the Event Calendar
	 */
	public void step() {
		currentShipment = null;
		chosenItem = myCalendar.nextToBeProcessed();
		currentShipment = chosenItem.processNext();
		stepsTaken++;
	}
	
	/**
	 * Returns the number of steps taken so far
	 * @return number of steps taken
	 */
	public int getStepsTaken() {
		return this.stepsTaken;
	}
	
	/**
	 * Total number of steps in the simulation
	 * @return the total number of steps in the simulation
	 */
	public int totalNumberOfSteps() {
		return numShipments * 2;
	}
	
	/**
	 * Returns true if the simulatuion has not yet finished
	 * Returns false if the simulation has finished
	 * @return whether or not the simulation has finished
	 */
	public boolean moreSteps() {
		return !(stepsTaken == totalNumberOfSteps());
	}
	
	/**
	 * Returns the index of the ShipmentProcessStation selected by the
	 * currentShipent, or -1 if currentShipment is null.
	 * @return the station index of the current shipment
	 */
	public int getCurrentIndex() {
		if (currentShipment == null) {
			return -1;
		}
		else {
			return currentShipment.getStationIndex();
		}
	}
	
	/**
	 * Returns the color of the currentShipment or null if currentShipment is null
	 * @return the color of the currentShipment or null if currentShipment is null
	 */
	public Color getCurrentShipmentColor() {
		if (currentShipment == null) {
			return null;
		}
		else {
			return currentShipment.getColor();
		}
	}
	
	/**
	 * Returns true if the most recently handled item completed processing and left
	 * a shipment process station line.
	 * Returns false if the most recently handled item left the conveyor belt to join a shipment
	 * process station line or if there is no current item.
	 * @return whether or not the item has left the simulation
	 */
	public boolean itemLeftSimulation() {
		if (currentShipment == null) {
			return false;
		}
		return !(currentShipment.isWaitingInLineAtStation() == true);
	}
	
	/**
	 * Returns the average wait time of packages in the simulation
	 * @return the average wait time for the packages
	 */
	public double averageWaitTime() {
		return myLog.averageWaitTime();
	}
	/**
	 * Returns the average process time of the packages in the simulation
	 * @return the average process time for the packages
	 */
	public double averageProcessTime() {
		return myLog.averageProcessTime();
	}	
}