/**
 * 
 */
package edu.ncsu.csc216.shipping_simulator.simulation;

import edu.ncsu.csc216.shipping_simulator.pkg.ItemToShip;

/**
 * Logs and keeps track of information for packages including waiting time
 * and processing time.
 * 
 * @author Wesley
 */
public class Log {
	
	/**
	 * The number of items that have logged their information
	 * and left the simulation
	 */
	private int numCompleted;
	
	/**
	 * The sum of all wait times logged by items so far
	 */
	private int totalWaitTime;
	
	/**
	 * The sum of all times that items took to do actual processing
	 * which is not including wait time.
	 */
	private int totalProcessTime;

	/**
	 * Initializes the log object
	 */
	public Log() {
		numCompleted = 0;
		totalWaitTime = 0;
		totalProcessTime = 0;
		
	}
	
	/**
	 * Returns the number of packages that have completed processing in the simulation
	 * @return the number of completed packages
	 */
	public int getNumCompleted() {
		return this.numCompleted;
	}
	
	/**
	 * Updates the three data members from the parameter.
	 * @param ItemToShip the package object that needs to be processed and shipped
	 */
	public void logItem (ItemToShip item) {
		if (item != null) {
			numCompleted++;
			totalWaitTime += item.getWaitTime();
			totalProcessTime += item.getProcessTime();
		}
		
	}
	
	/**
	 * Returns that average wait time of all the packages
	 * @return the average wait time for the packages
	 */
	public double averageWaitTime() {
		if (numCompleted == 0) {
			return 0;
		}	
		return totalWaitTime / numCompleted;	
	}
	
	/**
	 * Returns the average process time of all the packages
	 * @return the average wait time for the packages
	 */
	public double averageProcessTime() {
		if (numCompleted == 0) {
			return 0;
		}	
		return totalProcessTime / numCompleted;
	}
}