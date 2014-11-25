/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24
 */

package ae.threadpooltest.strategies;

import ae.threadpooltest.random.RandMaker;


/**
 * Execution strategy that runs all jobs in one thread sequentially
 * 
 * @author Albin Engström
 */
public class SequentialStrategy extends ExecutionStrategy {

	/* (non-Javadoc)
	 * @see ae.threadpooltest.strategies.ExecutionStrategy#RunIt()
	 */
	@Override
	public void runIt() {
		
		System.out.println("SequentialStrategy: 1 thread " + 
				ae.threadpooltest.constants.Constants.TOT_VALUES + " values...");
		
		//Variable to hold the sum
		double sum = 0.0;
		
		//Start myTimer
		myTimer.start();
		
		//Run NJOBS jobs
		for(int i=0; i < ae.threadpooltest.constants.Constants.NJOBS; ++i) {
			
			//Add the result of RandMakers run() to sum
			sum += new RandMaker().call();
		}
		
		//Stop myTimer
		myTimer.stop();
		
		System.out.println("Mean = " + sum/NJOBS);
		
		System.out.println("Duration: " + myTimer.diff() + " ms.");
	}
}
