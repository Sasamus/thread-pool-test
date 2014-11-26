/*
 *  Created: 2014-11-24
 * Modified: 2014-11-26
 */

package ae.threadpooltest.test;

import ae.threadpooltest.strategies.ExecutionStrategy;
import ae.threadpooltest.strategies.OneThreadPerJobStrategy;
import ae.threadpooltest.strategies.SequentialStrategy;
import ae.threadpooltest.strategies.ThreadPoolStrategy;


/**
 * @author Albin Engström
 * @since 2014-11-24
 */
public class ThreadPoolTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------------------------------------------------");
		
		ExecutionStrategy strategy = new SequentialStrategy();
		
		strategy.runIt();
		
		System.out.println("-------------------------------------------------------");
		
		strategy = new OneThreadPerJobStrategy();
		
		strategy.runIt();
		
		System.out.println("-------------------------------------------------------");
		
		strategy = new ThreadPoolStrategy(200);
		
		strategy.runIt();
		
		System.out.println("-------------------------------------------------------");
		
		strategy = new ThreadPoolStrategy(300);
		
		strategy.runIt();

		System.out.println("-------------------------------------------------------");
		
		strategy = new ThreadPoolStrategy(0);
		
		strategy.runIt();
		
		System.out.println("-------------------------------------------------------");
		
		strategy = new ThreadPoolStrategy(Runtime.getRuntime().availableProcessors()/2);
		
		strategy.runIt();
		
		System.out.println("-------------------------------------------------------");

	}

}
