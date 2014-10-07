/**
 * 
 */
package edu.ncsu.csc216.shipping_simulator.queues;

import java.util.NoSuchElementException;

import edu.ncsu.csc216.shipping_simulator.pkg.BookShipmentFactory;
import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;

/**
 * Represents the conveyor belt carrying items (book packages)
 * from the factory. Implements LineOfItems and contains all of the
 * ItemToShip objects created by the BookShipmentFactory that have not yet joined
 * their ShipmentProcessStation queues.
 * 
 * @author Wesley
 */
public class ConveyorBelt implements LineOfItems {

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
	 * The constructor for the ConveyorBelt class
	 * @param numShipments the number of items (book packages) for the simulation
	 * @param ShipmentProcessStation[] The array of shipment process stations for the packages
	 */
	public ConveyorBelt(int numShipments, ShipmentProcessStation[] station) {
		if (numShipments > 0) {
			ItemToShip item = BookShipmentFactory.generateBookShipment();
		}
		else {
			throw new IllegalArgumentException();
		}
		if (queueFromFactory != null) {
			try {
				queueFromFactory.add(item);
			} catch (NoSuchElementException e) {	
			}
		}
	}
	
	/**
	 * Returns the number of items still in the queue
	 * @return the number of items still in the queue
	 */
	public int size() {
		return queueFromFactory.size();
		
	}
	
	/**
	 * Returns true if the queue is not empty
	 * Returns false if the queue is empty
	 */
	public boolean hasNext() {
		if (queueFromFactory.isEmpty()) {
			return false;
		}
		else {	
			return true;
		}
	}
	
	/**
	 * Removes the front item from the queue and sends it a
	 * getInLine message
	 */
	public ItemToShip processNext() {
		if (!hasNext()) {
				return queueFromFactory.remove();
		}
		else {
			throw new NoSuchElementException(); 
		}
	}
	
	/**
	 * Tells when the item at the front of the ConveyorBelt queue
	 * will depart that queue and enter a ShipmentProcessStation.
	 * If the queue is empty, return Integer.MAX_VALUE
	 * @return the depart time of the item at the front of the conveyor belt 
	 */
	public int departTimeNext() {
		if(hasNext()) {
			return Integer.MAX_VALUE;
		}
		else {
			return queueFromFactory.front().getArrivalTime();
		}
	}
}