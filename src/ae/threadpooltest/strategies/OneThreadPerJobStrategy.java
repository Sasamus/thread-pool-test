/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24 
 */

package ae.threadpooltest.strategies;

import java.util.Vector;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


/**
 * Execution strategy that runs all jobs in separate threads
 * 
 * @author Albin Engström
 */
public class OneThreadPerJobStrategy extends ExecutionStrategy {
	
	private Vector<Thread> threads;
	private Vector<Future<Double>> results;
	private Vector<FutureTask<Double>> tasks;

	/* (non-Javadoc)
	 * @see ae.threadpooltest.strategies.ExecutionStrategy#RunIt()
	 */
	@Override
	void runIt() {
		

	}

}
