package org.jfree.data.test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertFalse;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeGetUpperBoundMethodTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This tests are realated to Method: getUpperBound of Class Range.");
	}

	@Before
	public void setUp() throws Exception {}

    @Test
    public void testGetUpperBound_PositiveRange_ReturnsCorrectUpperBound() {
        Range range = new Range(1.0, 10.0);
        double result = range.getUpperBound();
        assertEquals(10.0, result, 0.0);
    }

    @Test
    public void testGetUpperBound_NegativeRange_ReturnsCorrectUpperBound() {
        Range range = new Range(-10.0, -1.0);
        double result = range.getUpperBound();
        assertEquals(-1.0, result, 0.0);
    }

    @Test
    public void testGetUpperBound_ZeroRange_ReturnsCorrectUpperBound() {
        Range range = new Range(0.0, 0.0);
        double result = range.getUpperBound();
        assertEquals(0.0, result, 0.0);
    }

    @Test
    public void testGetUpperBound_InfiniteRange_ReturnsCorrectUpperBound() {
        Range range = new Range(1.0, Double.POSITIVE_INFINITY);
        double result = range.getUpperBound();
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0);
    }

    @Test
    public void testGetUpperBound_InfiniteReversedRange_ReturnsCorrectUpperBound() {
        Range range = new Range(Double.NEGATIVE_INFINITY, 1.0);
        double result = range.getUpperBound();
        assertEquals(1.0, result, 0.0);
    }
    
    @Test
    public void testGetUpperBound_for_invalidRange() {
    	 Boolean flag = false;
    	try {
    		new Range(5.0, 2.0).getUpperBound();
    		
    		} catch (IllegalArgumentException e) {
    			flag  = true;
    		
    		}
    	assertEquals(true, flag);
		}
	
	@After
	public void tearDown() throws Exception {
	}
	 

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}