package ae.threadpooltest.test;

import ae.threadpooltest.random.RandMaker;

/**
 * @author Albin Engström
 * @since 2014-11-24
 */
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandMaker randMaker = new RandMaker();
		double mean = randMaker.run(1000);
		System.out.println("Mean: " + mean);

	}

}
