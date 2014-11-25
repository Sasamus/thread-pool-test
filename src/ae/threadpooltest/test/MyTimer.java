/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24
 */

package ae.threadpooltest.test;

/**
 * @author Albin Engström
 */
public class MyTimer {
	
	/**
	 * A variable to hold the start time
	 */
	private long startTime;
	
	/**
	 * A variable to hold the stop time
	 */
	private long stopTime;
	
	/**
	 * Sets startTime
	 */
	public void start(){
		startTime = System.nanoTime();
	}
	
	/**
	 * Sets stopTime
	 */
	public void stop(){
		stopTime = System.nanoTime();
	}
	
	/**
	 * @return the difference between stopTime and startTime in milliseconds
	 */
	public long diff(){
		final int MILLION = 1000000;
	  	return (stopTime - startTime)/MILLION;
	}

}
