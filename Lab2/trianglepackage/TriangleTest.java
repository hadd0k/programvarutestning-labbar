package trianglepackage;

import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TriangleTest for testing the Triangle class.
 * This template is used in the exercise phase 1.
 * Students should add relevant unit test cases related to the Triangle 
 * class to this class.
 */
public class TriangleTest {

	
	@BeforeClass
	/*
	 * The method run once before any of the test methods in the class.
	 */
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	/* 
	 * The method will be run after all the tests in the class have been run
	 */
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	/*
	 * Initializes common objects. The method will be run before the Test method.
	 */
	public void setUp() throws Exception {
	
	}

	@After
	/*
	 *   Cleanup method. This method will be run after the Test method is completed
	 */
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testEquilateralTriangle() {
		Triangle equilateralTriangle = new Triangle(3, 3, 3);
		assertEquals("Should return 'equilateral'", "equilateral", equilateralTriangle.classify());
		assertEquals("Should have an area of 3.897", 3.897, equilateralTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 9", 9, equilateralTriangle.getPerimeter());
	}

	@Test
	public void testIsoscelesTriangle() {
		Triangle isoscelesTriangle = new Triangle(3, 3, 2);
		assertEquals("Should return 'isosceles'", "isosceles", isoscelesTriangle.classify());
		assertEquals("Should have an area of 2.828", 2.828, isoscelesTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 8", 8, isoscelesTriangle.getPerimeter());
	}

	@Test
	public void testRightAngledTriangle() {
		Triangle rightAngledTriangle = new Triangle(3, 4, 5);
		assertEquals("Should return 'right-angled'", "right-angled", rightAngledTriangle.classify());
		assertEquals("Should have an area of 6", 6, rightAngledTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 12", 12, rightAngledTriangle.getPerimeter());
	}

	@Test
	public void testScaleneTriangle() {
		Triangle scaleneTriangle = new Triangle(4, 5, 6);
		assertEquals("Should return 'scalene'", "scalene", scaleneTriangle.classify());
		assertEquals("Should have an area of 9.922", 9.922, scaleneTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 15", 15, scaleneTriangle.getPerimeter());
	}

	@Test
	public void testLongHypotenuse() {
		Triangle longHypotenuse = new Triangle(3, 9, 3);
		assertEquals("Should return 'impossible'", "impossible", longHypotenuse.classify());
		assertEquals("Should have an area of -1", -1, longHypotenuse.getArea(), 0.0005);
		assertEquals("Should have a perimeter of -1", -1, longHypotenuse.getPerimeter());
	}

	@Test
	public void testSidesEqualHypotenuse() {
		Triangle sidesEqualHypotenuse = new Triangle(3, 3, 6);
		assertEquals("Should return 'impossible'", "impossible", sidesEqualHypotenuse.classify());
		assertEquals("Should have an area of -1", -1, sidesEqualHypotenuse.getArea(), 0.0005);
		assertEquals("Should have a perimeter of -1", -1, sidesEqualHypotenuse.getPerimeter());
	}

	@Test
	public void testZeroHypotenuse() {
		Triangle zeroHypotenuse = new Triangle(0, 3, 3);
		assertEquals("Should return 'impossible'", "impossible", zeroHypotenuse.classify());
		assertEquals("Should have an area of -1", -1, zeroHypotenuse.getArea(), 0.0005);
		assertEquals("Should have a perimeter of -1", -1, zeroHypotenuse.getPerimeter());
	}

	@Test
	public void testNegativeHypotenuse() {
		Triangle negativeHypotenuse = new Triangle(-1, 3, 3);
		assertEquals("Should return 'impossible'", "impossible", negativeHypotenuse.classify());
		assertEquals("Should have an area of -1", -1, negativeHypotenuse.getArea(), 0.0005);
		assertEquals("Should have a perimeter of -1", -1, negativeHypotenuse.getPerimeter());
	}


	@Test
	public void bvaUnderMinimum() {
		Triangle underMinimum = new Triangle(0, 3, 3);
		assertEquals("Should return 'impossible'", "impossible", underMinimum.classify());
		assertEquals("Should have an area of -1", -1, underMinimum.getArea(), 0.0005);
		assertEquals("Should have a perimeter of -1", -1, underMinimum.getPerimeter());
	}

	@Test
	public void bvaMinimum() {
		Triangle minimum = new Triangle(1, 3, 3);
		assertEquals("Should return 'isosceles'", "isosceles", minimum.classify());
		assertEquals("Should have an area of 1.479", 1.479, minimum.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 7", 7, minimum.getPerimeter());
	}

	@Test
	public void bvaAboveMinimum() {
		Triangle aboveMinimum = new Triangle(2, 3, 3);
		assertEquals("Should return 'isosceles'", "isosceles", aboveMinimum.classify());
		assertEquals("Should have an area of 2.828", 2.828, aboveMinimum.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 8", 8, aboveMinimum.getPerimeter());
	}

	@Test
	public void bvaBelowValidTriangle() {
		Triangle belowValidTriangle = new Triangle(3, 3, 5);
		assertEquals("Should return 'isosceles'", "isosceles", belowValidTriangle.classify());
		assertEquals("Should have an area of -1", -1, belowValidTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of -1", -1, belowValidTriangle.getPerimeter());
	}

	@Test
	public void bvaOnValidTriangle() {
		Triangle validTriangle = new Triangle(3, 3, 6);
		assertEquals("Should return 'impossible'", "impossible", validTriangle.classify());
		assertEquals("Should have an area of -1", -1, validTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of -1", -1, validTriangle.getPerimeter());
	}

	@Test
	public void bvaAboveValidTriangle() {
		Triangle aboveValidTriangle = new Triangle(3, 3, 7);
		assertEquals("Should return 'impossible'", "impossible", aboveValidTriangle.classify());
		assertEquals("Should have an area of -1", -1, aboveValidTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of -1", -1, aboveValidTriangle.getPerimeter());
	}

	@Test
	public void bvaBelowRightTriangle() {
		Triangle belowRightTriangle = new Triangle(3, 4, 4);
		assertEquals("Should return 'isosceles'", "isosceles", belowRightTriangle.classify());
		assertEquals("Should have an area of 5.56", 5.56, belowRightTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 11", 11, belowRightTriangle.getPerimeter());
	}

	@Test
	public void bvaOnRightTriangle() {
		Triangle rightTriangle = new Triangle(3, 4, 5);
		assertEquals("Should return 'right-angled'", "right-angled", rightTriangle.classify());
		assertEquals("Should have an area of 6", 6, rightTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 12", 12, rightTriangle.getPerimeter());
	}

	@Test
	public void bvaAboveRightTriangle() {
		Triangle aboveRightTriangle = new Triangle(3, 4, 6);
		assertEquals("Should return 'scalene'", "scalene", aboveRightTriangle.classify());
		assertEquals("Should have an area of 5.333", 5.333, aboveRightTriangle.getArea(), 0.0005);
		assertEquals("Should have a perimeter of 13", 13, aboveRightTriangle.getPerimeter());
	}
}
