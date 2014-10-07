package edu.ncsu.csc216.shipping_simulator.pkg;

import java.awt.Color;

import edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation;

/**
 * Implements the behavior for joining a shipment process station intended
 * for regular packages
 * 
 * @author Wesley
 */
public class RegularBookShipment extends ItemToShip {
	
	/**
	 * The color of the package
	 */
	private Color color;
	
	/**
	 * The constructor for the RegularBookShipment class
	 * @param arrivalTime the arrival time for the package
	 * @param processTime the process time for the package
	 */
	public RegularBookShipment(int arrivalTime, int processTime) {
		super(arrivalTime, processTime);
	}
	
	/**
	 * Enters the package to the back of the queue for the ShipmentProcessStation
	 * that it chooses to join.
	 * @param ShipmentProcessStation[] The array of shipment process stations for the packages
	 */
	public void getInLine(ShipmentProcessStation[] station) {
		//You need to do three things:
		//Determine the index of the processing station that the item should choose.
		//Set the station index (setStationIndex)
		//Add the item to that processing station's line (addItemToLine).
		int bestStation = 0;
		int bestStationLength = 0;
		bestStationLength = station[1].size();
		for (int i = 1; i < station.length; i++) {
				if (station[i].size() < bestStationLength) {
					bestStation = i;
				}	
		}
		this.setStationIndex(bestStation);
		station[bestStation].addItemToLine(this);
		this.removeFromWaitingLine();
	}
	
	/**
	 * Returns the color of the packages
	 * @return the color of the package
	 */
	public Color getColor() {
		return Color.blue;
	}

}
