package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {
	/**
	 * compare between o1 to o2
	 * @param o1 monom
	 * @param o2 monom
	 * @return positive number if o1>o2, negative number if o2>o1, zero if o1=o2
	 */
	@Override
	public int compare(Monom o1, Monom o2) {
		return o1.get_power()-o2.get_power();
	}

}
