/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24
 */

package ae.threadpooltest.strategies;

import ae.threadpooltest.test.MyTimer;

/**
 * A superclass for executions strategies
 * 
 * @author Albin Engström
 */
public abstract class ExecutionStrategy {
	
	/**
	 * A variable to hold a MyTimer object
	 */
	protected MyTimer myTimer = new MyTimer();
	
	/**
	 * Runs the strategy
	 */
	abstract void runIt();

}
