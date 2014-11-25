/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24
 */

package ae.threadpooltest.test;

/**
 * @author Albin Engström
 */
public class MyTimer {
	
	private long startTime;
	private long stopTime;
	
	public void start(){
		startTime = System.nanoTime();
	}
	
	public void stop(){
		stopTime = System.nanoTime();
	}
	
	long diff(){
	  	return stopTime - startTime;
	}

}
