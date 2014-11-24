/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24
 */

package ae.threadpooltest.strategies;

import ae.threadpooltest.test.MyTimer;

/**
 * @author Albin Engström
 */
public abstract class ExecutionStrategy {
	
	private MyTimer myTimer;
	
	/**
	 * Runs the strategy
	 */
	abstract void RunIt();

}
