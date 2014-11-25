/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24 
 */

package ae.threadpooltest.strategies;

import static ae.threadpooltest.constants.Constants.NJOBS;
import static ae.threadpooltest.constants.Constants.VALUES_PER_THREAD;

import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ae.threadpooltest.random.RandMaker;


/**
 * Execution strategy that runs all jobs in separate threads
 * 
 * @author Albin Engström
 */
public class OneThreadPerJobStrategy extends ExecutionStrategy {
	
	/**
	 * A vector to hold the results
	 */
	private Vector<Future<Double>> results;
	
	/* (non-Javadoc)
	 * @see ae.threadpooltest.strategies.ExecutionStrategy#RunIt()
	 */
	@Override
	public void runIt() {
		
		//Create the results vector
		results = new Vector<Future<Double>>();
		
		//Print info to user
		System.out.println("OneThreadPerJobStrategy: " + NJOBS + " threads "
		+ VALUES_PER_THREAD + " values each...");
		
		//Variable to hold the sum
		double sum = 0.0;
		
		//Start myTimer
		myTimer.start();
		
		//Variable to hold an Executor
		ExecutorService executor;
		
		//Create a thread for each job
		for(int i=0; i < NJOBS; ++i) {
			
			//Create a new Executor
			executor = Executors.newSingleThreadExecutor();
			
			//Create and add a future to results
			results.add(i, executor.submit(new RandMaker()));
		}

		//Get results from each job
		for(int i=0; i < NJOBS; ++i) {		
			try {
				//Ad element at i to sum
				sum += results.elementAt(i).get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		//Stop myTimer
		myTimer.stop();			

		//Print results to user
		System.out.println("Mean = " + sum/NJOBS);	
		System.out.println("Duration: " + myTimer.diff() + " ms.");

	}

}
