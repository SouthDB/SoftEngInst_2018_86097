package de.fh.albsig.db86097;

public class PowerOfTwo {

	public long powTwo(int n) {
		if (n < 0) {
			return -1;
		} else {
			long result = 1;
			for (int i = 1; i <= n; i++) {
				result *= 2;
			}
			if (result == 0) { // out of range from long
				result = -1;
			}
			return result;
		}
	}
}
