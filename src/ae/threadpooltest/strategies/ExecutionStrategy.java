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
	
	final int ONE_MILLION = 1000000;
	final int VALUES_PER_THREAD = ONE_MILLION;
	final int NJOBS = 300;
	final long TOT_VALUES = NJOBS * VALUES_PER_THREAD; 
	
	/**
	 * A variable to hola a MyTimer object
	 */
	private MyTimer myTimer = new MyTimer();
	
	/**
	 * Runs the strategy
	 */
	abstract void RunIt();

}
