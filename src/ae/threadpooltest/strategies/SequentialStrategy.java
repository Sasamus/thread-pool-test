/*
 *  Created: 2014-11-24
 * Modified: 2014-11-24
 */

package ae.threadpooltest.strategies;

/**
 * @author Albin Engström
 */
public class SequentialStrategy extends ExecutionStrategy {

	/* (non-Javadoc)
	 * @see ae.threadpooltest.strategies.ExecutionStrategy#RunIt()
	 */
	@Override
	void RunIt() {
		
		System.out.println("SequentialStrategy: 1 thread " + TOT_VALUES + " values...");
		float sum=0.0;
		iTimer.start();
		for(int i=0;i<NJOBS;++i) {
			sum += ram(VALUES_PER_THREAD);
		}
		iTimer.stop();
		cout << "Mean = " <<  sum/NJOBS << '\n';
		cout << "Duration: " << iTimer.diff() << " ms." << endl;
	}

	}

}
