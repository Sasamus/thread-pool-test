package ae.threadpooltest.test;

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
		
		SequentialStrategy seqstra = new SequentialStrategy();
		
		seqstra.runIt();

	}

}
