/*
 *  Created: 2014-11-24
 * Modified: 2014-11-26
 */

package ae.threadpooltest.strategies;

import static ae.threadpooltest.constants.Constants.NJOBS;
import static ae.threadpooltest.constants.Constants.TOT_VALUES;

import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ae.threadpooltest.random.RandMaker;

/**
 * @author Albin Engström
 */
public class ThreadPoolStrategy extends ExecutionStrategy {
	
	/**
	 * Holds the thread pool
	 */
	private ExecutorService pool = null;
	
	/**
	 * Holds the pool size
	 */
	private int poolSize;
	
	/**
	 * Holds the number of available Cpus
	 */
	private int nrCpus;
	
	/**
	 * @param nrThreads number of threads to use
	 */
	public ThreadPoolStrategy(int nrThreads) {
		
		//Set nrCpus to number of available CPUs
		nrCpus = Runtime.getRuntime().availableProcessors();
		
		//If nrThreads is 0, set create thread pool with nrCpus threads, else nThreads
		if(nrThreads == 0){
			pool = Executors.newFixedThreadPool(nrCpus);
			poolSize = nrCpus;
		}
		else{
			pool = Executors.newFixedThreadPool(nrThreads);
			poolSize = nrThreads;
		}
		
				
	}

	/* (non-Javadoc)
	 * @see ae.threadpooltest.strategies.ExecutionStrategy#RunIt()
	 */
	@Override
	public void runIt() {
		
		//Prints depending on poolSize
		if(poolSize == nrCpus) {	
			System.out.println("ThreadPoolStrategy " + nrCpus + " threads"
			+ " == " + "available processor cores,");
		}
		else
			System.out.println("ThreadPoolStrategy " + poolSize + " threads " 
			+ TOT_VALUES + " values in total...");

		//Holds the sum
		double sum = 0.0;
		
		//Holds the results
		Vector<Future<Double> > results = new Vector<Future<Double>>();
		
		//Start myTimer
		myTimer.start();
		
		//Create a thread for each job
		for(int i=0; i < NJOBS; ++i) {
			
			//Create and add a future to results
			results.add(i, pool.submit(new RandMaker()));
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

		//Prints results
		System.out.println("Mean = " +  sum/NJOBS);
		System.out.println("Duration: " + myTimer.diff() + " ms.");

	}

}
