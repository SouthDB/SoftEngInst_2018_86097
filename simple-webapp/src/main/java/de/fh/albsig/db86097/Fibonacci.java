package de.fh.albsig.db86097;

/** Class to calculate Fibonacci Sequence. */

public final class Fibonacci {

    /** should filter n higher than 50 because of cpu power. */
    public static final int MAX_N = 50;

    /**
     * Method to caclulate Fibonacci Sequence.
     * 
     * @return recursivley
     * @param n input number of fibonacci sequence
     */
    public long fibonacci(final int n) {

        if (n == 1 || n == 0) {
            return n;
        } else if (n < 0 || n > MAX_N) {
            return -1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
