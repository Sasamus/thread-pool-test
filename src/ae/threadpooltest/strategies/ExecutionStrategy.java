package ae.threadpooltest.strategies;

import ae.threadpooltest.test.MyTimer;

/**
 * @author Albin Engström
 * @since 2014-11-24
 */
public abstract class ExecutionStrategy {
	
	private MyTimer myTimer;
	
	/**
	 * Runs the strategy
	 */
	abstract void RunIt();

}
