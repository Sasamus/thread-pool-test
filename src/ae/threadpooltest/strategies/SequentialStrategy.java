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
		
		//Create a new RandMaker object
		RandMaker randMaker = new RandMaker();
		
		//Gets required constants
		long tot_values = ae.threadpooltest.constants.Constants.TOT_VALUES;
		int njobs = ae.threadpooltest.constants.Constants.NJOBS;
		
		System.out.println("SequentialStrategy: 1 thread " + tot_values + " values...");
		
		//Variable to hold the sum
		double sum = 0.0;
		
		//Start myTimer
		myTimer.start();
		
		//Run NJOBS jobs
		for(int i=0; i < njobs; ++i) {
			
			//Add the result of randMakers call() to sum
			sum += randMaker.call();
		}
		
		//Stop myTimer
		myTimer.stop();
		
		System.out.println("Mean = " + sum/njobs);
		
		System.out.println("Duration: " + myTimer.diff() + " ms.");
	}
}
