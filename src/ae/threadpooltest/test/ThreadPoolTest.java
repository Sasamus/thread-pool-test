package ae.threadpooltest.test;

import ae.threadpooltest.strategies.ExecutionStrategy;
import ae.threadpooltest.strategies.OneThreadPerJobStrategy;
import ae.threadpooltest.strategies.SequentialStrategy;


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

	}

}
