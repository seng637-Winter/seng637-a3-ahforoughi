package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandToIncludeMethodTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("This tests are related to Method: expandToInclude of Class Range.");
    }

    @Before
    public void setUp() throws Exception { }

    @Test
    public void testExpandToInclude_PositiveRange_ExpandsCorrectly() {
        Range range = new Range(1.0, 10.0);
        Range expandedRange = Range.expandToInclude(range, 5.0);
     // The range already includes 5 value so epandedRange should remain the same.
        assertEquals(1.0, expandedRange.getLowerBound(), 0.0);
        assertEquals(10.0, expandedRange.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToInclude_NegativeRange_ExpandsCorrectly() {
        Range range = new Range(-10.0, -1.0);
        Range expandedRange = Range.expandToInclude(range, -5.0);
     // The range already include -5 value so expanded range should remain the same
        assertEquals(-10.0, expandedRange.getLowerBound(), 0.0);
        assertEquals(-1.0, expandedRange.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToInclude_ZeroRange_ExpandsCorrectly() {
        Range range = new Range(0.0, 0.0);
        Range expandedRange = Range.expandToInclude(range, 5.0);
        // The expanded range should include value 5, 
        // so upper range of expanded range should change to 5
        // and lower bound remain the same
        assertEquals(0.0, expandedRange.getLowerBound(), 0.0);
        assertEquals(5.0, expandedRange.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToInclude_InfiniteRange_ExpandsCorrectly() {
        Range range = new Range(1.0, Double.POSITIVE_INFINITY);
        Range expandedRange = Range.expandToInclude(range, Double.NEGATIVE_INFINITY);
        // The expanded range should include Double.NEGATIVE_INFINITY value 
        // so lower bound range of  extended range should be Double.NEGATIVE_INFINITY
        // and upper bound remain the same.
        assertEquals(Double.NEGATIVE_INFINITY, expandedRange.getLowerBound(), 0.0);
        assertEquals(Double.POSITIVE_INFINITY, expandedRange.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToInclude_InfiniteReversedRange_ExpandsCorrectly() {
        Range range = new Range(Double.NEGATIVE_INFINITY, 1.0);
        // The expanded range should include Double.POSITIVE_INFINITY value 
        // so upper bound range of  extended range should be Double.POSITIVE_INFINITY
        // and lower bound remain the same.        
        Range expandedRange = Range.expandToInclude(range, Double.POSITIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, expandedRange.getLowerBound(), 0.0);
        assertEquals(Double.POSITIVE_INFINITY, expandedRange.getUpperBound(), 0.0);
    }

   // this test added for more branch coverage
    @Test
   public void testExpandToInclude_NullRange_ExpandsCorrectly() {
//    	null range should change to (value, value) range to include range
       Range expandedRange = Range.expandToInclude(null, 5);
       assertEquals(5, expandedRange.getLowerBound(), 0.0);
       assertEquals(5, expandedRange.getUpperBound(), 0.0);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}