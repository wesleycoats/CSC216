package edu.ncsu.csc216.shipping_simulator.queues;

import java.util.NoSuchElementException;

import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;
import edu.ncsu.csc216.shipping_simulator.simulation.Log;

/**
 * Represents stations where items (book packages) go through their
 * final processing. Implements the LineOfItems interface and contains a
 * ShipmentQueue for the line of items to be processed at this station.
 * 
 * @author Wesley
 */
public class ShipmentProcessStation implements LineOfItems {
	
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
	 * The wait time of the package updated in addItemToLine;
	 */
	private double waitTime;
	
	
	/**
	 * The constructor for the ShipmentProcessStation class.
	 * @param Log Used to initialize the instance field log
	 */
	public ShipmentProcessStation(Log log) {
		this.log = log;
	}
	
	/**
	 * Returns the number of items still in the queue
	 * @return the number of items still in the queue
	 */
	public int size() {
		return line.size();
	}
	
	/**
	 * Removes the front item from the queue and logs its information in the
	 * process. The removed item is returned.
	 */
	public ItemToShip processNext() {
		if (hasNext()==true) {
				return line.remove();
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	
	/**
	 * Returns true if the queue is not empty.
	 * Returns false if the queue is empty.
	 */
	public boolean hasNext() {
		if (line.isEmpty()) {
			return false;
		}
		else {	
			return true;
		}
	}
	
	/**
	 * Tells when the item at the front of the queue (currently being processed)
	 * will finish its processing and leave the simulation. If the queue is empty,
	 * return Integer.MAX_VALUE
	 * @return the depart time of the item at the front of the queue
	 */
	public int departTimeNext() {
		if(hasNext()==false) {
			return Integer.MAX_VALUE;
		}
		else {
			return line.front().getArrivalTime() + line.front().getWaitTime() + line.front().getProcessTime();
		}
	}
	
	/**
	 * Adds an item to the end of the queue, updating the
	 * item's waitTime as well as the time when the items in the line
	 * will be clear of all current items
	 * @param ItemToShip Represents a package that needs to be processed and shipped
	 */
	public void addItemToLine(ItemToShip item) {
		if (line == null) {
			this.waitTime = 0.0;
		}
		if (line != null) {
			this.waitTime = timeWhenAvailable-item.getArrivalTime();
		}
		waitTime = timeWhenAvailable + this.waitTime;
		line.add(item);
	}
}