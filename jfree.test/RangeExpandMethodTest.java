package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;

public class RangeExpandMethodTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This tests are realated to Method: Expand of Class Range.");
	}

	@Before
	public void setUp() throws Exception {}

	@Test
	public void testExpand_PositiveRange_ExpandsRangeCorrectly() {
		Range range = new Range(1.0, 10.0);
		// The expanded range should be expanded by 50% of the length in both upper bound and lower bound
		// length is 9 so expanded range should be (-3.5, 14.5)
		Range expandedRange = Range.expand(range, 0.5, 0.5);
		assertEquals(-3.5, expandedRange.getLowerBound(), 0.0);
		assertEquals(14.5, expandedRange.getUpperBound(), 0.0);
	}

	@Test
	public void testExpand_NegativeRange_ExpandsRangeCorrectly() {
		Range range = new Range(-10.0, -1.0);
		// The expanded range should be expanded by 50% of the length in both upper bound and lower bound
		// length is 9 so expanded range should be (-14.5, 3.5)
		Range expandedRange = Range.expand(range, 0.5, 0.5);
		assertEquals(-14.5, expandedRange.getLowerBound(), 0.0);
		assertEquals(3.5, expandedRange.getUpperBound(), 0.0);
	}

	@Test
	public void testExpand_ZeroRange_ExpandsRangeCorrectly() {
		Range range = new Range(0.0, 0.0);
		// The expanded range should be expanded by 50% of the length in both upper bound and lower bound
		// length is zero so expanded range should be (0,0)
		Range expandedRange = Range.expand(range, 0.5, 0.5);
		assertEquals(0, expandedRange.getLowerBound(), 0.0);
		assertEquals(0, expandedRange.getUpperBound(), 0.0);
	}

	@Test
	public void testExpand_InfiniteRange_ExpandsRangeCorrectly() {
		Range range = new Range(1.0, Double.POSITIVE_INFINITY);
		// The expanded range should be expanded by 50% of the length in both upper bound and lower bound
		// length is Double.POSITIVE_INFINITY so expanded range 
		// should be (Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
		Range expandedRange = Range.expand(range, 0.5, 0.5);
		assertEquals(Double.NEGATIVE_INFINITY, expandedRange.getLowerBound(), 0.0);
		assertEquals(Double.POSITIVE_INFINITY, expandedRange.getUpperBound(), 0.0);
	}

	@Test
	public void testExpand_InfiniteReversedRange_ExpandsRangeCorrectly() {
		Range range = new Range(Double.NEGATIVE_INFINITY, 1.0);
		// The expanded range should be expanded by 50% of the length in both upper bound and lower bound
		// length is Double.POSITIVE_INFINITY so expanded range 
		// should be (Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
		Range expandedRange = Range.expand(range, 0.5, 0.5);
		assertEquals(Double.NEGATIVE_INFINITY, expandedRange.getLowerBound(), 0.0);
		assertEquals(Double.POSITIVE_INFINITY, expandedRange.getUpperBound(), 0.0);

	}
	
	//adding for branch coverage
	@Test
	public void testExpand_changingTheupperboundAndLowerbound_ExpandsRangeCorrectly() {
		Range range = new Range(0, 10.0);
		Range expandedRange = Range.expand(range, -0.8, -0.8);
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
