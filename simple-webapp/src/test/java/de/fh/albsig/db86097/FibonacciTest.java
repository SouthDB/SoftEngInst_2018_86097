package de.fh.albsig.db86097;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciTest {

	@DisplayName("Test Fibonacci Calculation")
	@ParameterizedTest(name = "{index} => fib= {0} n= {1}")
	@CsvSource({ "0,0", "1,1", "1,2", "8,6", "13,7" })
	void fibCalculation(int res, int n) {
		Fibonacci fib = new Fibonacci();
		assertEquals(res, fib.fibonacci(n));
	}

	@DisplayName("Test Fibonacci Border")
	@ParameterizedTest(name = "{index} => value= -1 n= {1}")
	@CsvSource({ "-1", "-5", "51", "55" })
	void fibBorder(int n) {
		Fibonacci fib = new Fibonacci();
		assertEquals(-1, fib.fibonacci(n));
	}
}
