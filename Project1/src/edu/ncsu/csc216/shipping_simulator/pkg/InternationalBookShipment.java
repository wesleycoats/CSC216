package edu.ncsu.csc216.shipping_simulator.pkg;

import java.awt.Color;

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
	public void getInLine(ShipmentProcessStation[]) {
		//You need to do three things:
		//Determine the index of the processing station that the item should choose.
		//Set the station index (setStationIndex)
		//Add the item to that processing station's line (addItemToLine).
		int bestStation = 0;
		if (station.length == 3 || station.length == 4) {
			bestStation = station.length-1;
		}
		if (5 <= station.length <= 8) {
			for (int i = station.length-2; i < station.length; i++) {
				bestStation = station[i].size();
				if (station[i].size() < bestStation) {
					bestStation = station[i].size();
				}	
			}
		}
		if (station.length == 9) {
			for (int i = station.length-3; i < station.length; i++) {
				bestStation = station[i].size();
				if (station[i].size() < bestStation) {
					bestStation = station[i].size();
				}
			}
		}	
		setStationIndex(indexOf(bestStation));
		addItemToLine(item);
		waitingProcessing = true;
	}
	
	/**
	 * Returns the color of the packages
	 * @return the color of the package
	 */
	public Color getColor() {
		return Color.yellow;
	}

}
