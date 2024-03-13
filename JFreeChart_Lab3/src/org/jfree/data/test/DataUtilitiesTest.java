
package org.jfree.data.test;
import static org.junit.Assert.*; import org.jfree.data.DataUtilities; import org.junit.*;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class DataUtilitiesTest {
	
	// Mockery instance for mocking objects
	private Mockery mockingContext;
	// Values2D instance for testing
	private Values2D values;
	// Test data array for testing methods
	private double[][] numArrayData = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
	// Mockery instance for mocking KeyedValues objects
	private Mockery keyValMock;
	// KeyedValues instance for testing
	private KeyedValues KeyValues;

	@Before
	public void setup() throws Exception {
		// Initialize the Mockery instance for mocking objects
	    mockingContext = new Mockery(); 
	    // Create a mock Values2D object for simulating a 2D matrix
	    values = mockingContext.mock(Values2D.class);
	    // Setup expectations for method calls on the mock Values2D object
		mockingContext.checking(new Expectations() {
			{ 
				// Define expectations for the number of rows and columns in the mock matrix
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getColumnCount();
	            will(returnValue(3));
	            
	            // Define expectations for values returned by getValue() method for each cell
	            one(values).getValue(0, 0);
	            will(returnValue(1));
	            one(values).getValue(1, 0); 
	            will(returnValue(1.5)); 
	            one(values).getValue(2, 0);
	            will(returnValue(2));
	            one(values).getValue(0, 1);
	            will(returnValue(-3));
	            one(values).getValue(1, 1); 
	            will(returnValue(-3.5)); 
	            one(values).getValue(2, 1);
	            will(returnValue(-4));
	            one(values).getValue(0, 2);
	            will(returnValue(4.5));
	            one(values).getValue(1, 2); 
	            will(returnValue(-5)); 
	            one(values).getValue(2, 2);
	            will(returnValue(5.5));
	            
	            // Describe the mock matrix:
	            // [1][-3][4.5]
	            // [1.5][-3.5][-5]
	            // [2][-4][5.5]
			} 
		}); 
		
		// Create a mock KeyedValues object for simulating key-value pairs
	    keyValMock = new Mockery();
	    KeyValues = keyValMock.mock(KeyedValues.class);

	    // Setup expectations for method calls on the mock KeyedValues object
		keyValMock.checking(new Expectations(){
			{
				// Define expectations for getIndex(), getKey(), and getValue() method calls
	            // for each key
	            atLeast(1).of(KeyValues).getIndex(0);
	            will(returnValue(0));
	            atLeast(1).of(KeyValues).getKey(0);
	            will(returnValue(0));
	            atLeast(1).of(KeyValues).getValue(0);
	            will(returnValue(1));
	            
	            atLeast(1).of(KeyValues).getIndex(1);
	            will(returnValue(1));
	            atLeast(1).of(KeyValues).getKey(1);
	            will(returnValue(1));
	            atLeast(1).of(KeyValues).getValue(1);
	            will(returnValue(-2.5));
	            
	            atLeast(1).of(KeyValues).getIndex(2);
	            will(returnValue(2));
	            atLeast(1).of(KeyValues).getKey(2);
	            will(returnValue(2));
	            atLeast(1).of(KeyValues).getValue(2);
	            will(returnValue(11));
	            
	            // Define the number of items in the KeyedValues object
	            atLeast(1).of(KeyValues).getItemCount();
	            will(returnValue(3));
	            
	            // Setting up the mock key-value pairs:
	            // Key: 0, 1, 2
	            // Value: 1, -2.5, 11

			}
		});

		// Initialize a new Mockery instance specific for another KeyedValues mock
		keyValMock1 = new Mockery();
		KeyValues1 = keyValMock1.mock(KeyedValues.class);

		// Set up expectations for the newly created KeyedValues mock (KeyValues1)
		keyValMock1.checking(new Expectations() {
			{
				atLeast(1).of(KeyValues1).getIndex(0);
				will(returnValue(0));
				atLeast(1).of(KeyValues1).getKey(0);
				will(returnValue(0));
				atLeast(1).of(KeyValues1).getValue(0);
				will(returnValue(1));
				
				atLeast(1).of(KeyValues1).getIndex(1);
				will(returnValue(1));
				atLeast(1).of(KeyValues1).getKey(1);
				will(returnValue(1));
				atLeast(1).of(KeyValues1).getValue(1);
				will(returnValue(null));
				
				atLeast(1).of(KeyValues1).getIndex(2);
				will(returnValue(2));
				atLeast(1).of(KeyValues1).getKey(2);
				will(returnValue(2));
				atLeast(1).of(KeyValues1).getValue(2);
				will(returnValue(9));
				
				// Expectation: getItemCount() method is called at least once and confirms there are 3 items
				atLeast(1).of(KeyValues1).getItemCount();
				will(returnValue(3));
				
				//setting up the  mock key
				//Key: 0,1,2
				//Value:1,null,9
			}
		});

		// Create a new Mockery instance
		mockingContext1 = new Mockery();
		// Create a mock for Values2D interface
		values1 = mockingContext1.mock(Values2D.class);
		// Set expectations for method calls on the mock Values2D object
		mockingContext1.checking(new Expectations() { 
			{
				one(values1).getRowCount();
				will(returnValue(3));
				one(values1).getColumnCount();
				will(returnValue(3));
				
				one(values1).getValue(0, 0);
				will(returnValue(null));
				one(values1).getValue(1, 0); 
				will(returnValue(1.5)); 
				one(values1).getValue(2, 0);
				will(returnValue(2));
				one(values1).getValue(0, 1);
				will(returnValue(-3));
				one(values1).getValue(1, 1); 
				will(returnValue(-3.5)); 
				one(values1).getValue(2, 1);
				will(returnValue(-4));
				one(values1).getValue(0, 2);
				will(returnValue(4.5));
				one(values1).getValue(1, 2); 
				will(returnValue(-5)); 
				one(values1).getValue(2, 2);
				will(returnValue(5.5));
				
				// Define the structure of the mock matrix
				// [null][-3][4.5]
				// [1.5][-3.5][-5]
				// [2][-4][5.5]
			} 
		}); 
	}
	
	// Test case for calculating column total for column one
	@Test
	public void calculateColumnTotalForColumnOne() { 
	    // Calculate the column total for the first column using the DataUtilities class
	    double result = DataUtilities.calculateColumnTotal(values, 0); 
	    
	    // Verify that the result matches the expected total for column one
	    // The expected total for column one is 4.5; column 0 contains values: 1, 1.5, 2, so the sum is 1 + 1.5 + 2 = 4.5
	    // The assert compares the calculated result with the expected value.	    
	    assertEquals("Incorrect column total for column one", 4.5, result, 0.000000001d);
	}
	
	// Test case for calculating column total for column two
	@Test
	public void calculateColumnTotalForColumnTwo() { 
	    // Calculate the column total for the second column using the DataUtilities class
	    double result = DataUtilities.calculateColumnTotal(values, 1); 
	    
	    // Verify that the result matches the expected total for column two
	    // The expected total for column two is -10.5; column 1 contains values: -3, -3.5, -4, so the sum is -3 + (-3.5) + (-4) = -10.5
	    // The assert compares the calculated result with the expected value.
	    assertEquals("Incorrect column total for column two", -10.5, result, 0.000000001d);
	}

	// Test case for calculating column total for column three
	@Test
	public void calculateColumnTotalForColumnThree() { 
		// Calculate the column total for the third column using the DataUtilities class
		double result=DataUtilities.calculateColumnTotal(values, 2); 
		
		// Verify that the result matches the expected total for column three
	    // The expected total for column two is 5; column 3 contains values: 4.5, -5, 5.5, so the sum is 4.5 + (-5) + 5.5 = 5
	    // The assert compares the calculated result with the expected value.
		assertEquals("Incorrect column total for column three", 5, result, 0.000000001d);
	}

	// Test added for more coverage
	@Test
	public void calculateColumnTotalForRowOne_withNullValue() { 

		double result =DataUtilities.calculateColumnTotal(values1, 0); 
		//   verify 
		assertEquals(result, 1.5, .000000001d);
	}
	
	// Test case for calculating row total for row one
	@Test
	public void calculateRowTotalForRowOne() { 
	    // Calculate the row total for the first row using the DataUtilities class
	    double result = DataUtilities.calculateRowTotal(values, 0); 
	    
	    // Verify that the result matches the expected total for row one
	    // The expected total for row one is 2.5; row 0 contains values: 1, -3, 4.5, so the sum is 1 + (-3) + 4.5 = 2.5
	    // The assert compares the calculated result with the expected value.
	    assertEquals("Incorrect row total for row one", 2.5, result, 0.000000001d);
	}
	
	// Test case for calculating row total for row two
	@Test
	public void calculateRowTotalForRowTwo() { 
	    // Calculate the row total for the second row using the DataUtilities class
	    double result = DataUtilities.calculateRowTotal(values, 1); 
	    
	    // Verify that the result matches the expected total for row two
	    // The expected total for row two is -7; row 1 contains values: 1.5, -3.5, -5, so the sum is 1.5 + (-3.5) + (-5) = -7
	    // The assert compares the calculated result with the expected value.
	    assertEquals("Incorrect row total for row two", -7, result, 0.000000001d);
	}
	
	// Test case for calculating row total for row three
	@Test
	public void calculateRowTotalForRowThree() { 
	    // Calculate the row total for the third row using the DataUtilities class
	    double result = DataUtilities.calculateRowTotal(values, 2); 
	    
	    // Verify that the result matches the expected total for row three
	    // The expected total for row three is 3.5; row 2 contains values: 2, -4, 5.5, so the sum is 2 + (-4) + 5.5 = 3.5
	    // Comment: The assert compares the calculated result with the expected value.
	    assertEquals("Incorrect row total for row three", 3.5, result, 0.000000001d);
	}

	// Test case for calculating row total for row one with null value
	@Test
	public void calculateRowTotalForRowOne_withNullValue() { 
		// Calculate the row total for row one using the DataUtilities class
		double result = DataUtilities.calculateRowTotal(values1, 0); 
		
		// Verify that the result matches the expected total for row one
		// Row one contains values: 1.5, null, 3.5, so the sum is 1.5
		// The assert compares the calculated result with the expected value.
		assertEquals("Incorrect row total for row one with null value", 1.5, result, 0.000000001d);
	}

	// Test case for creating a number array with three numbers
	@Test
	public void createNumberArrayWithThreeNumbers() {
		// Iterate over the indices of the first row in numArrayData to test each number in the array
		for (int i = 0; i < numArrayData[0].length; i++) {
			// Verify that the number array was created correctly by comparing each element with the expected value
			assertEquals("Number array was not created.", numArrayData[0][i], DataUtilities.createNumberArray(numArrayData[0])[i].doubleValue(), 0.0);
		}
	}
	
	// Test case for creating a 2D number array with three number sets
	@Test
	public void createNumberArray2DWithThreeNumberSets() {
		for(int i = 0; i < numArrayData.length - 1; i++) {
			for(int j = 0; j < numArrayData.length - 1; j++) {
			// Verify that the 2D number array was created correctly for each element
			assertEquals("2D number array was not created.", numArrayData[i][j], DataUtilities.createNumberArray2D(numArrayData)[i][j].doubleValue(), 0.0);
			}
		}
	}
	
	// Test case for calculating cumulative percentage for the first key
	@Test
	public void getCumulativePercentageWithThreeKeysFirstNum() {
	    // Verify that the cumulative percentage for the first key matches the expected value
	    // For example, if the Keys are: 0, 1, 2 and Values are: 1, -2.5, 11, then
	    // the cumulative percentage for key 0 is calculated as 1 / (1 + (-2.5) + 11)
	    assertEquals("Incorrect cumulative percentage for the first key", 0.10526315789, DataUtilities.getCumulativePercentages(KeyValues).getValue(0).doubleValue(), .000000001d);
	}
	
	// Test case for calculating cumulative percentage for the second key
	@Test
	public void getCumulativePercentageWithThreeKeysSecondNum() {
	    // Verify that the cumulative percentage for the second key matches the expected value
	    // The cumulative percentage for key 1 is calculated as (1 - 2.5) / (1 + (-2.5) + 11)
	    assertEquals("Incorrect cumulative percentage for the second key", -0.15789473684, DataUtilities.getCumulativePercentages(KeyValues).getValue(1).doubleValue(), .000000001d);
	}
	
	// Test case for calculating cumulative percentage for the third key
	@Test
	public void getCumulativePercentageWithThreeKeysThirdNum() {
	    // Verify that the cumulative percentage for the third key matches the expected value
	    // The cumulative percentage for key 2 is calculated as 1.0, as it's the last key and the sum of values is already 100%
	    assertEquals("Incorrect cumulative percentage for the third key", 1.0, DataUtilities.getCumulativePercentages(KeyValues).getValue(2).doubleValue(), .000000001d);
	}

	// Test case for getting cumulative percentage for null value
	@Test
	public void getCumulativePercentageForNullValue() {
		// Verify that the cumulative percentage for null value is returned correctly
		assertEquals("Incorrect cumulative percentage for null value", 0.1, DataUtilities.getCumulativePercentages(KeyValues1).getValue(0).doubleValue(), .000000001d);
	}
	
	@After
	public void teardown() throws Exception{}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{}
	
}

