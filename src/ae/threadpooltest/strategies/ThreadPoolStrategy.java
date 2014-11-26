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
	
	private ExecutorService pool = null;
	
	private int poolSize;
	
	private int nrCpus;
	
	public ThreadPoolStrategy(int nrThreads) {
		
		int nrCpus = Runtime.getRuntime().availableProcessors();
		
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
		
		if(poolSize == 0) {	
			System.out.println("ThreadPoolStrategy " + nrCpus + " threads "
			+ " == " + "available processor cores,");
		}
		else
			System.out.println("ThreadPoolStrategy " + poolSize + " threads " 
			+ TOT_VALUES + " values in total...");

		double sum = 0.0;
		
		Vector<Future<Double> > results = new Vector<Future<Double>>();
		
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
		
		myTimer.stop();

		System.out.println("Mean = " +  sum/NJOBS);
		System.out.println("Duration: " + myTimer.diff() + " ms.");

	}

}
