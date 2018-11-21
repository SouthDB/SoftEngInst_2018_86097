package de.fh.albsig.db86097;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PowerOfTwoTest {

	@DisplayName("Test PowerOfTwo Calculation")
	@ParameterizedTest(name = "{index} => fib= {0} n= {1}")
	@CsvSource({ "1,0", "2,1", "4,2", "64,6" })
	void powCalculation(int res, int n) {
		PowerOfTwo pow = new PowerOfTwo();
		assertEquals(res, pow.powTwo(n));
	}

	@DisplayName("Test PowerOfTwo Border")
	@ParameterizedTest(name = "{index} => value= -1 n= {1}")
	@CsvSource({ "-1", "-5", "100" })
	void powBorder(int n) {
		PowerOfTwo pow = new PowerOfTwo();
		assertEquals(-1, pow.powTwo(n));
	}
}
