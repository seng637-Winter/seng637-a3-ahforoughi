package org.jfree.data.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeContainsMethodTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("These tests are related to the Contains method of Range class.");
    }

    @Before
    public void setUp() throws Exception {}

    // @Test
    // public void testContains_PositiveRange_ReturnsCorrectValue() {
    //     Range range = new Range(1.0, 100.0);
    //     boolean result = range.contains(50.0);
    //     assertTrue(result);
    // }

    // @Test
    // public void testContains_PositiveRange_ReturnsFalseForValueLessThanMin() {
    //     Range range = new Range(1.0, 100.0);
    //     boolean result = range.contains(0.0);
    //     assertFalse(result);
    // }

    // @Test
    // public void testContains_PositiveRange_ReturnsFalseForValueGreaterThanMax() {
    //     Range range = new Range(1.0, 100.0);
    //     boolean result = range.contains(101.0);
    //     assertFalse(result);
    // }

    @Test
    public void testContains_NegativeRange_ReturnsCorrectValue() {
        Range range = new Range(-100.0, -1.0);
        boolean result = range.contains(-50.0);
        assertTrue(result);
    }

    @Test
    public void testContains_NegativeRange_ReturnsFalseForValueLessThanMin() {
        Range range = new Range(-100.0, -1.0);
        boolean result = range.contains(-101.0);
        assertFalse(result);
    }

    @Test
    public void testContains_NegativeRange_ReturnsFalseForValueGreaterThanMax() {
        Range range = new Range(-100.0, -1.0);
        boolean result = range.contains(0.0);
        assertFalse(result);
    }

    @Test
    public void testContains_ZeroRange_ReturnsCorrectValue() {
        Range range = new Range(0.0, 0.0);
        boolean result = range.contains(0.0);
        assertTrue(result);
    }

    @Test
    public void testContains_ZeroRange_ReturnsFalseForNonZeroValue() {
        Range range = new Range(0.0, 0.0);
        boolean result = range.contains(1.0);
        assertFalse(result);
    }
        
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
