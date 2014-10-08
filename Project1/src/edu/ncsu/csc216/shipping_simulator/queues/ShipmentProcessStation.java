package edu.ncsu.csc216.shipping_simulator.queues;

import java.util.NoSuchElementException;

import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;
import edu.ncsu.csc216.shipping_simulator.simulation.Log;
import edu.ncsu.csc216.shipping_simulator.simulation.Simulator;

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
	 * @return the removed line
	 */
	public ItemToShip processNext() {
		if (line.isEmpty()) {
			throw new NoSuchElementException();
		}
		log.logItem(line.front());
		return line.remove();
	}
	
	/**
	 * Returns true if the queue is not empty.
	 * Returns false if the queue is empty.
	 * @return if the queue is empty or not
	 */
	public boolean hasNext() {
		if (line != null) {
			return true;
		}	
		return false;
	}
	/**
	 * Tells when the item at the front of the queue (currently being processed)
	 * will finish its processing and leave the simulation. If the queue is empty,
	 * return Integer.MAX_VALUE
	 * @return the depart time of the item at the front of the queue
	 */
	public int departTimeNext() {
		if(!hasNext()) {
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
	 * @param item represents a package that needs to be processed and shipped
	 */
	public void addItemToLine(ItemToShip item) {
		if (line.front() == null) {
			item.setWaitTime(0);
		}
		if (line.front() != null) {
			item.setWaitTime(timeWhenAvailable - item.getArrivalTime());
		}
		timeWhenAvailable = timeWhenAvailable + item.getProcessTime();
		log.logItem(item);
		line.add(item);
	}
}