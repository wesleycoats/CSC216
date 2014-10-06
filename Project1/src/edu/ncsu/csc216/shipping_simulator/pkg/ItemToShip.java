package edu.ncsu.csc216.shipping_simulator.pkg;

import java.awt.Color;

import edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation;

/**
 * Contains the state and behavior for all book packages to be shipped.
 * The behaviors include joining the queue and returning the color of the item.
 * 
 * @author Wesley
 */
public abstract class ItemToShip {
	
	/**
	 * The integer that holds the initial station index
	 */
	public static final int INITIAL_STATION_IDX;
	
	/**
	 * The arrival time of the package which is the
	 * time when a package enters a shipment process station line. Time
	 * is measured by the number of seconds from the beginning of the simulation.
	 */
	private int arrivalTime;
	
	/**
	 * The wait time of the package which is the number of seconds the item waits
	 * in a shipment process station queue before processing.
	 */
	private int waitTime;
	
	/**
	 * The process time of the package which is the number of seconds required to
	 * process the item, and does not include the time in the queue prior to processing.
	 */
	private int processTime;
	
	/**
	 * The station index of the package which is the index of the ShipmentProcessStation
	 * that the item has selected. Before the item reaches the queue of its ShipmentProcessStation,
	 * stationIndex should be -1.
	 */
	private int stationIndex;
	
	/**
	 * Returns true if the item is currently on a ShipmentProcessStation queue.
	 * Returns false if the item is still on the conveyer belt or if it has left
	 * the ShipmentProcessStation queue.
	 */
	private boolean waitingProcessing;
	
	/**
	 * The constructor for the ItemToShip class.
	 * @param arrivalTime the arrival time for the package
	 * @param processTime the process time for the package
	 * @throws IllegalArgumentException if the arrivalTime or processTime is less than 0
	 */
	
	
	
	public ItemToShip(int arrvialTime, int processTime) throws IllegalArgumentException {
		ItemToShip item = BookShipmentFactory.generateBookShipment();
		if (arrivalTime < 0 || processTime < 0) {
			throw new IllegalArgumentException();
		}
		
	}
	
	/**
	 * Returns the arrival time for packages
	 * @return the arrival time for the package
	 */
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	/**
	 * Returns the wait time for packages
	 * @return the wait time for the package
	 */
	public int getWaitTime() {
		return this.waitTime;
	}
	
	/**
	 * Sets the wait time for packages
	 * @param waitTime the wait time for the package
	 */
	public void setWaitTime(int waitTime) {
		this.setWaitTime(waitTime);
	}
	
	/**
	 * Returns the process time for packages
	 * @return the process time for a package
	 */
	public int getProcessTime() {
		return this.processTime;
	}
	
	/**
	 * Returns the station index for packages
	 * @return the station index for a package
	 */
	public int getStationIndex() {
		return this.stationIndex;
	}
	
	/**
	 * The getter for the waitingProcessing boolean. Returns true if the item
	 * is on a ShipmentProcessStation queue. Returns false if the item is still on
	 * the ConveyorBelt or if it has left the ShipmentProcessStation queue. 
	 * @return
	 */
	public boolean isWaitingInLineAtStation() {
		return this.waitingProcessing;
	}
	
	/**
	 * Changes the status of the package. It takes it out of the waiting queue and
	 * completes the processing.
	 */
	public void removeFromWaitingLine() {
		waitingProcessing = false;
	}
	
	/**
	 * Sets the station index for a package
	 * @param stationIndex the index of the process station for the package
	 */
	protected void setStationIndex(int stationIndex) {
		this.setStationIndex(stationIndex);
	}
	
	/**
	 * Changes the status of the package and puts it in the back of the queue
	 * for the ShipmentProcessStation it chooses to join.
	 * @param ShipmentProcessStation[] The array of shipment process stations for packages
	 */
	public void getInLine(ShipmentProcessStation[]);
	
	/**
	 * Returns the color of the packages
	 * @return the color of the package
	 */
	public abstract Color getColor();

}