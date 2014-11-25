/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24 
 */

package ae.threadpooltest.strategies;

import java.util.Vector;
import java.util.concurrent.Future;

/**
 * Execution strategy that runs all jobs in separate threads
 * 
 * @author Albin Engström
 */
public class OneThreadPerJobStrategy extends ExecutionStrategy {
	
	Vector<Thread> threads;
	Vector<Future<Double>> results;
	Vector<packaged_task<double(unsigned int)>> tasks;

	/* (non-Javadoc)
	 * @see ae.threadpooltest.strategies.ExecutionStrategy#RunIt()
	 */
	@Override
	void runIt() {
		

	}

}
