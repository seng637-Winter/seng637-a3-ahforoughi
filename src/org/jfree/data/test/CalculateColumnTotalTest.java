package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;

import org.jmock.Expectations;
import org.jmock.Mockery;

import org.junit.*;
import org.junit.rules.ExpectedException;


public class CalculateColumnTotalTest {
    // Mocking context for creating mock objects
    Mockery mockingContext;
	
    // Mock object for Values2D interface to simulate data structures
    Values2D values;
 
    // Variable to save the result 
    double result;

    @Rule
    public final ExpectedException exception = ExpectedException.none();
 
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}
 

    @Before
    public void setUp() throws Exception {
        // Initialize the mocking context
		mockingContext = new Mockery();
		// Create a mock object for Values2D
		values = mockingContext.mock(Values2D.class);
    }
 
    @Test
    public void calcColTotal_ValidColPos() {
  
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); 
            will(returnValue(3));
            
            // Setup expectations for specific cell values and the expected result
            one(values).getValue(0, 0);
            will(returnValue(7.5));
            one(values).getValue(1, 0);
            will(returnValue(2.5));
            one(values).getValue(2, 0);
            will(returnValue(5.0));
        }});
 
        // get the result of the first row total , then verify the result
        result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The result of testing valid column and positive data:", 15.0, result, .000000001d);
    }
 
    @Test
    public void calcColTotal_ValidColNeg() {
        mockingContext.checking(new Expectations() {{
            one(values).getRowCount(); 
            will(returnValue(3));
        
            // Setup expectations for specific cell values and the expected result
            one(values).getValue(0, 0);
            will(returnValue(-7.5));
            one(values).getValue(1, 0);
            will(returnValue(-2.5));
            one(values).getValue(2, 0);
            will(returnValue(5.0));
        }});
 
        // get the result of the first row total , then verify the result
        result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The result of testing valid column and negative data:", -5.0, result, .000000001d);
    }


    @After
    public void tearDown() throws Exception {
        mockingContext = null;
        assertNull(mockingContext);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}
}