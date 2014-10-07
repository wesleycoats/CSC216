package edu.ncsu.csc216.shipping_simulator.pkg;

import java.awt.Color;

import edu.ncsu.csc216.shipping_simulator.queues.ShipmentProcessStation;

/**
 * Implements the behavior for joining a shipment process station intended
 * for international packages
 * 
 * @author Wesley
 */
public class InternationalBookShipment extends ItemToShip {
	
	/**
	 * The color of the package
	 */
	private Color color;
	
	/**
	 * The constructor for the InternationalBookShipment class
	 * @param arrivalTime the arrival time for the package
	 * @param processTime the process time for the package
	 */
	public InternationalBookShipment(int arrivalTime, int processTime) {
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
		if (station.length == 3 || station.length == 4) {
			bestStation = station.length-1;
		}
		else if (5 <= station.length && station.length <= 8) {
			bestStationLength = station[5].size();
			for (int i = station.length-2; i < station.length; i++) {
				if (station[i].size() < bestStationLength) {
					bestStation = i;
				}	
			}
		}
		else if (station.length == 9) {
			bestStationLength = station[6].size();
			for (int i = station.length-3; i < station.length; i++) {
				if (station[i].size() < bestStationLength) {
					bestStation = i;
				}
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
		return Color.yellow;
	}

}
