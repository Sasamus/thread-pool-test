package ae.threadpooltest.random;
/** 
*   Random.java 
*	 Generates pseduo-random numbers 
*	 uniformly distributed over the interval [0.0..1.0[
*
*/


import java.util.Date;


public class Random {

	private final int s1max = 2147483562;
	private final int s2max = 2147483398;
	private int	s1,s2;


	private void checkSeeds()
	{
		if (s1 < 1 || s1 > s1max) s1 = (Math.abs(s1) % s1max) + 1;
		if (s2 < 1 || s2 > s2max) s2 = (Math.abs(s2) % s2max) + 1;
	}

	Random()
	{
		Date now = new Date();
		s1 = now.hashCode();
		s2 = this.hashCode();
		checkSeeds();
	}

	Random(int seed1, int seed2)
	{
		s1 = seed1;  s2 = seed2;
		checkSeeds();
	}

	double next()
	{
		long Z;
		int k;

		k = s1/53668;
		s1 = 40014 * (s1 - k * 53668) - k * 12211;
		if (s1 < 0) s1 += s1max + 1;

		k = s2/52774;
		s2 = 40692 * (s2 - k * 52774) - k * 3791;
		if (s2 < 0) s2 += s2max + 1;

		Z = s1 - s2;
		if (Z < 1) Z += s1max;

		return Z * 4.656613E-10;
	}
}
