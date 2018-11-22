package de.fh.albsig.db86097;

/** Class to calculate Power of Two. */

public final class PowerOfTwo {

    /**
     * Methode to calculate Power of Two.
     * 
     * @retrun result
     * @return -1 when intput was bad or result out of range from long
     * @param n input for Power of Two
     */
    public long powTwo(final int n) {
        if (n < 0) {
            return -1;
        } else {
            long result = 1;
            for (int i = 1; i <= n; i++) {
                result *= 2;
            }
            if (result == 0) {
                result = -1;
            }
            return result;
        }
    }
}
