package trianglepackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * TriangleTest for testing the Triangle class.
 * This template is used in the exercise phase 1.
 * Students should add relevant unit test cases related to the Triangle 
 * class to this class.
 */
public class TriangleTest {

	@Test
	public void testEquilateralTriangle() {
		Triangle equilateralTriangle = new Triangle(3, 3, 3);
		assertAll("Equilateral triangle",
				() -> assertEquals("equilateral", equilateralTriangle.classify(), "Should return 'equilateral'"),
				() -> assertEquals(3.897, equilateralTriangle.getArea(), 0.0005, "Should have an area of 3.897"),
				() -> assertEquals(9, equilateralTriangle.getPerimeter(), "Should have a perimeter of 9")
				);
	}

	@Test
	public void testIsoscelesTriangle() {
		Triangle isoscelesTriangle = new Triangle(3, 3, 2);
		assertAll("Isosceles triangle",
				() -> assertEquals("isosceles", isoscelesTriangle.classify(), "Should return 'isosceles'"),
				() -> assertEquals(2.828, isoscelesTriangle.getArea(), 0.0005, "Should have an area of 2.828"),
				() -> assertEquals(8, isoscelesTriangle.getPerimeter(), "Should have a perimeter of 8")
				);
	}

	@Test
	public void testRightAngledTriangle() {
		Triangle rightAngledTriangle = new Triangle(3, 4, 5);
		assertAll("Right-angled triangle",
				() -> assertEquals("right-angled", rightAngledTriangle.classify(), "Should return 'right-angled'"),
				() -> assertEquals(6, rightAngledTriangle.getArea(), 0.0005, "Should have an area of 6"),
				() -> assertEquals(12, rightAngledTriangle.getPerimeter(), "Should have a perimeter of 12")
				);
	}

	@Test
	public void testScaleneTriangle() {
		Triangle scaleneTriangle = new Triangle(4, 5, 6);
		assertAll("Scalene triangle",
				() -> assertEquals("scalene", scaleneTriangle.classify(), "Should return 'scalene'"),
				() -> assertEquals(9.922, scaleneTriangle.getArea(), 0.0005, "Should have an area of 9.922"),
				() -> assertEquals(15, scaleneTriangle.getPerimeter(), "Should have a perimeter of 15")
				);
	}

	@Test
	public void testLongHypotenuse() {
		Triangle longHypotenuse = new Triangle(3, 9, 3);
		assertAll("Impossible triangle with a long side",
				() -> assertEquals("impossible", longHypotenuse.classify(), "Should return 'impossible'"),
				() -> assertEquals(-1, longHypotenuse.getArea(), 0.0005, "Should have an area of -1"),
				() -> assertEquals(-1, longHypotenuse.getPerimeter(), "Should have a perimeter of -1")
				);
	}

	@Test
	public void testSidesEqualHypotenuse() {
		Triangle sidesEqualHypotenuse = new Triangle(3, 3, 6);
		assertAll("Degenerate triangle",
				() -> assertEquals("impossible", sidesEqualHypotenuse.classify(), "Should return 'impossible'"),
				() -> assertEquals(0, sidesEqualHypotenuse.getArea(), 0.0005, "Should have an area of 0"),
				() -> assertEquals(12, sidesEqualHypotenuse.getPerimeter(), "Should have a perimeter of 12")
				);
	}

	@Test
	public void testZeroHypotenuse() {
		Triangle zeroHypotenuse = new Triangle(0, 3, 3);
		assertAll("Triangle with a zero side",
				() -> assertEquals("impossible", zeroHypotenuse.classify(), "Should return 'impossible'"),
				() -> assertEquals(-1, zeroHypotenuse.getArea(), 0.0005, "Should have an area of -1"),
				() -> assertEquals(-1, zeroHypotenuse.getPerimeter(), "Should have a perimeter of -1")
				);
	}

	@Test
	public void testNegativeHypotenuse() {
		Triangle negativeHypotenuse = new Triangle(-1, 3, 3);
		assertAll("Triangle with a negative side",
				() -> assertEquals("impossible", negativeHypotenuse.classify(), "Should return 'impossible'"),
				() -> assertEquals(-1, negativeHypotenuse.getArea(), 0.0005, "Should have an area of -1"),
				() -> assertEquals(-1, negativeHypotenuse.getPerimeter(), "Should have a perimeter of -1")
				);
	}


	

	@Test
	public void bvaUnderMinimum() {
		Triangle underMinimum = new Triangle(0, 3, 3);
		assertAll("Should return 'impossible', area -1, perimeter 6", 
				() -> assertEquals("impossible", underMinimum.classify(), "Should return 'impossible'"),
				() -> assertEquals(-1, underMinimum.getArea(), 0.0005, "Should have an area of -1"),
				() -> assertEquals(-1, underMinimum.getPerimeter(), "Should have a perimeter of -1")
				);
	}

	@Test
	public void bvaMinimum() {
		Triangle minimum = new Triangle(1, 3, 3);
		assertAll("Minimum side length",
				() -> assertEquals("isosceles", minimum.classify(), "Should return 'isosceles'"),
				() -> assertEquals(1.479, minimum.getArea(), 0.0005, "Should have an area of 1.479"),
				() -> assertEquals(7, minimum.getPerimeter(), "Should have a perimeter of 7")
				);
	}

	@Test
	public void bvaAboveMinimum() {
		Triangle aboveMinimum = new Triangle(2, 3, 3);
		assertAll("Above minimum side length",
				() -> assertEquals("isosceles", aboveMinimum.classify(), "Should return 'isosceles'"),
				() -> assertEquals(2.828, aboveMinimum.getArea(), 0.0005, "Should have an area of 2.828"),
				() -> assertEquals(8, aboveMinimum.getPerimeter(), "Should have a perimeter of 8")
				);
	}

	@Test
	public void bvaBelowValidTriangle() {
		Triangle belowValidTriangle = new Triangle(3, 3, 5);
		assertAll("Just inside the valid triangle boundary",
				() -> assertEquals("isosceles", belowValidTriangle.classify(), "Should return 'isosceles'"),
				() -> assertEquals(4.146, belowValidTriangle.getArea(), 0.0005, "Should have an area of 4.146"),
				() -> assertEquals(11, belowValidTriangle.getPerimeter(), "Should have a perimeter of 11")
				);
	}

	@Test
	public void bvaOnValidTriangle() {
		Triangle validTriangle = new Triangle(3, 3, 6);
		assertAll("Degenerate triangle boundary",
				() -> assertEquals("impossible", validTriangle.classify(), "Should return 'impossible'"),
				() -> assertEquals(0, validTriangle.getArea(), 0.0005, "Should have an area of 0"),
				() -> assertEquals(12, validTriangle.getPerimeter(), "Should have a perimeter of 12")
				);
	}

	@Test
	public void bvaAboveValidTriangle() {
		Triangle aboveValidTriangle = new Triangle(3, 3, 7);
		assertAll("Outside the valid triangle boundary",
				() -> assertEquals("impossible", aboveValidTriangle.classify(), "Should return 'impossible'"),
				() -> assertEquals(-1, aboveValidTriangle.getArea(), 0.0005, "Should have an area of -1"),
				() -> assertEquals(-1, aboveValidTriangle.getPerimeter(), "Should have a perimeter of -1")
				);
	}

	@Test
	public void bvaBelowRightTriangle() {
		Triangle belowRightTriangle = new Triangle(3, 4, 4);
		assertAll("Below the right-triangle boundary",
				() -> assertEquals("isosceles", belowRightTriangle.classify(), "Should return 'isosceles'"),
				() -> assertEquals(5.56, belowRightTriangle.getArea(), 0.0005, "Should have an area of 5.56"),
				() -> assertEquals(11, belowRightTriangle.getPerimeter(), "Should have a perimeter of 11")
				);
	}

	@Test
	public void bvaOnRightTriangle() {
		Triangle rightTriangle = new Triangle(3, 4, 5);
		assertAll("Right-triangle boundary",
				() -> assertEquals("right-angled", rightTriangle.classify(), "Should return 'right-angled'"),
				() -> assertEquals(6, rightTriangle.getArea(), 0.0005, "Should have an area of 6"),
				() -> assertEquals(12, rightTriangle.getPerimeter(), "Should have a perimeter of 12")
				);
	}

	@Test
	public void bvaAboveRightTriangle() {
		Triangle aboveRightTriangle = new Triangle(3, 4, 6);
		assertAll("Above the right-triangle boundary",
				() -> assertEquals("scalene", aboveRightTriangle.classify(), "Should return 'scalene'"),
				() -> assertEquals(5.333, aboveRightTriangle.getArea(), 0.0005, "Should have an area of 5.333"),
				() -> assertEquals(13, aboveRightTriangle.getPerimeter(), "Should have a perimeter of 13")
				);
	}

}
