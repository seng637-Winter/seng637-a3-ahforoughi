package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeGetLowerBoundMethodTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This tests are realated to Method: getLowerBound of Class Range.");
	}

	@Before
	public void setUp() throws Exception {}

    @Test
    public void testGetLowerBound_PositiveRange_ReturnsCorrectLowerBound() {
        Range range = new Range(1.0, 10.0);
        double result = range.getLowerBound();
        assertEquals(1.0, result, 0.0);
    }

    @Test
    public void testGetLowerBound_NegativeRange_ReturnsCorrectLowerBound() {
        Range range = new Range(-10.0, -1.0);
        double result = range.getLowerBound();
        assertEquals(-10.0, result, 0.0);
    }

    @Test
    public void testGetLowerBound_ZeroRange_ReturnsCorrectLowerBound() {
        Range range = new Range(0.0, 0.0);
        double result = range.getLowerBound();
        assertEquals(0.0, result, 0.0);
    }


    @Test
    public void testGetLowerBound_InfiniteRange_ReturnsCorrectLowerBound() {
        Range range = new Range(Double.NEGATIVE_INFINITY, 10.0);
        double result = range.getLowerBound();
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.0);
    }

    @Test
    public void testGetLowerBound_InfiniteReversedRange_ReturnsCorrectLowerBound() {
        Range range = new Range(10.0, Double.POSITIVE_INFINITY);
        double result = range.getLowerBound();
        assertEquals(10.0, result, 0.0);
    }
    
	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
