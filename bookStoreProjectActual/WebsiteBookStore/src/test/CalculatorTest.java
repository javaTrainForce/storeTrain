package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		int a = 1234;
		int b = 5678;
		int result = calculator.add(a, b);
		
		int expectedValue = 6912;
		
		assertEquals(expectedValue, result);
	}

}
