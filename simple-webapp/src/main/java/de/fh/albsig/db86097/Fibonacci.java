package de.fh.albsig.db86097;

public class Fibonacci {

	public long fibonacci(int n) {
		if (n == 1 || n == 0) {
			return n;
		} else if (n < 0 || n > 50) {
			return -1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}