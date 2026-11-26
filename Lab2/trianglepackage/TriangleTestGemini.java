package trianglepackage;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleTestGemini {

    private static final double DELTA = 1e-3;

    private void assertTriangleState(
            Triangle t,
            String expectedType,
            boolean isEq,
            boolean isIso,
            boolean isRight,
            boolean isSca,
            boolean isImp,
            int expectedPerimeter,
            double expectedArea) {
        assertAll(
                () -> assertEquals(expectedType, t.classify(), "classify()"),
                () -> assertEquals(isEq, t.isEquilateral(), "isEquilateral()"),
                () -> assertEquals(isIso, t.isIsosceles(), "isIsosceles()"),
                () -> assertEquals(isRight, t.isRightAngled(), "isRightAngled()"),
                () -> assertEquals(isSca, t.isScalene(), "isScalene()"),
                () -> assertEquals(isImp, t.isImpossible(), "isImpossible()"),
                () -> assertEquals(expectedPerimeter, t.getPerimeter(), "getPerimeter()"),
                () -> assertEquals(expectedArea, t.getArea(), DELTA, "getArea()")
        );
    }

    @Nested
    @DisplayName("Valid Equivalence Partitions (EP-V1 to EP-V4)")
    class ValidEquivalencePartitions {

        @Test
        @DisplayName("TC01: Equilateral (also satisfies isIsosceles)")
        void equilateralTriangle() {
            Triangle t = new Triangle(5, 5, 5);
            double expectedArea = (Math.sqrt(3) / 4.0) * 5 * 5;
            assertTriangleState(t, "equilateral", true, true, false, false, false, 15, expectedArea);
        }

        @ParameterizedTest(name = "TC02-TC04: Isosceles permutation ({0}, {1}, {2})")
        @CsvSource({
                "5, 5, 6",
                "5, 6, 5",
                "6, 5, 5"
        })
        void isoscelesPermutations(int s1, int s2, int s3) {
            Triangle t = new Triangle(s1, s2, s3);
            assertTriangleState(t, "isosceles", false, true, false, false, false, 16, 12.0);
        }

        @ParameterizedTest(name = "TC05-TC07: Right-angled permutation ({0}, {1}, {2})")
        @CsvSource({
                "3, 4, 5",
                "3, 5, 4",
                "5, 3, 4"
        })
        void rightAngledPermutations(int s1, int s2, int s3) {
            Triangle t = new Triangle(s1, s2, s3);
            assertTriangleState(t, "right-angled", false, false, true, false, false, 12, 6.0);
        }

        @Test
        @DisplayName("TC08: Scalene non-right-angled")
        void scaleneTriangle() {
            Triangle t = new Triangle(13, 14, 15);
            assertTriangleState(t, "scalene", false, false, false, true, false, 42, 84.0);
        }
    }

    @Nested
    @DisplayName("Invalid Equivalence Partitions (EP-I1 to EP-I4)")
    class InvalidEquivalencePartitions {

        @ParameterizedTest(name = "TC09-TC12: Zero side length ({0}, {1}, {2})")
        @CsvSource({
                "0, 4, 5",
                "4, 0, 5",
                "4, 5, 0",
                "0, 0, 0"
        })
        void zeroSideLengths(int s1, int s2, int s3) {
            Triangle t = new Triangle(s1, s2, s3);
            assertTriangleState(t, "impossible", false, false, false, false, true, -1, -1.0);
        }

        @ParameterizedTest(name = "TC13-TC17: Negative side lengths ({0}, {1}, {2})")
        @CsvSource({
                "-1,  4,  5",
                " 4, -1,  5",
                " 4,  5, -1",
                "-3, -3, -3",
                "-3, -4, -5"
        })
        void negativeSideLengths(int s1, int s2, int s3) {
            Triangle t = new Triangle(s1, s2, s3);
            assertTriangleState(t, "impossible", false, false, false, false, true, -1, -1.0);
        }

        @ParameterizedTest(name = "TC18-TC20: Strictly violates triangle inequality ({0}, {1}, {2})")
        @CsvSource({
                " 2,  3, 10",
                " 2, 10,  3",
                "10,  2,  3"
        })
        void triangleInequalityViolated(int s1, int s2, int s3) {
            Triangle t = new Triangle(s1, s2, s3);
            assertTriangleState(t, "impossible", false, false, false, false, true, -1, -1.0);
        }

        @ParameterizedTest(name = "TC24-TC26: Degenerate triangle a + b == c ({0}, {1}, {2})")
        @CsvSource({
                "3, 4, 7",
                "3, 7, 4",
                "7, 3, 4"
        })
        void degenerateTriangles(int s1, int s2, int s3) {
            Triangle t = new Triangle(s1, s2, s3);
            assertTriangleState(t, "impossible", false, false, false, false, true, -1, -1.0);
        }
    }

    @Nested
    @DisplayName("Boundary-Value Analysis (BVA)")
    class BoundaryValueAnalysis {

        @Test
        @DisplayName("TC21: Minimum valid equilateral (1, 1, 1)")
        void minimumValidEquilateral() {
            Triangle t = new Triangle(1, 1, 1);
            double expectedArea = Math.sqrt(3) / 4.0;
            assertTriangleState(t, "equilateral", true, true, false, false, false, 3, expectedArea);
        }

        @Test
        @DisplayName("TC22: Minimum valid non-equilateral isosceles (1, 2, 2)")
        void minimumValidIsosceles() {
            Triangle t = new Triangle(1, 2, 2);
            double expectedArea = Math.sqrt(2.5 * 1.5 * 0.5 * 0.5);
            assertTriangleState(t, "isosceles", false, true, false, false, false, 5, expectedArea);
        }

        @Test
        @DisplayName("TC23: Triangle inequality boundary -1 (3, 4, 6) -> valid scalene")
        void triangleInequalityJustValid() {
            Triangle t = new Triangle(3, 4, 6);
            double expectedArea = Math.sqrt(6.5 * 3.5 * 2.5 * 0.5);
            assertTriangleState(t, "scalene", false, false, false, true, false, 13, expectedArea);
        }

        @Test
        @DisplayName("TC27: Triangle inequality boundary +1 (3, 4, 8) -> impossible")
        void triangleInequalityJustInvalid() {
            Triangle t = new Triangle(3, 4, 8);
            assertTriangleState(t, "impossible", false, false, false, false, true, -1, -1.0);
        }

        @Test
        @DisplayName("TC28: Right-angle boundary -1 (8, 15, 16) -> acute scalene")
        void rightAngleMinusOne() {
            Triangle t = new Triangle(8, 15, 16);
            double expectedArea = Math.sqrt(19.5 * 11.5 * 4.5 * 3.5);
            assertTriangleState(t, "scalene", false, false, false, true, false, 39, expectedArea);
        }

        @Test
        @DisplayName("TC29: Right-angle exact boundary (8, 15, 17) -> right-angled")
        void rightAngleExact() {
            Triangle t = new Triangle(8, 15, 17);
            assertTriangleState(t, "right-angled", false, false, true, false, false, 40, 60.0);
        }

        @Test
        @DisplayName("TC30: Right-angle boundary +1 (8, 15, 18) -> obtuse scalene")
        void rightAnglePlusOne() {
            Triangle t = new Triangle(8, 15, 18);
            double expectedArea = Math.sqrt(20.5 * 12.5 * 5.5 * 2.5);
            assertTriangleState(t, "scalene", false, false, false, true, false, 41, expectedArea);
        }

        @Test
        @DisplayName("TC31: 32-bit squaring overflow threshold (46341, 46341, 46341)")
        void intSquaringOverflowBoundary() {
            int s = 46341;
            Triangle t = new Triangle(s, s, s);
            double expectedArea = (Math.sqrt(3) / 4.0) * s * s;
            assertAll(
                    () -> assertEquals("equilateral", t.classify()),
                    () -> assertTrue(t.isEquilateral()),
                    () -> assertTrue(t.isIsosceles()),
                    () -> assertFalse(t.isRightAngled()),
                    () -> assertFalse(t.isScalene()),
                    () -> assertFalse(t.isImpossible()),
                    () -> assertEquals(3 * s, t.getPerimeter()),
                    () -> assertEquals(expectedArea, t.getArea(), expectedArea * 1e-6)
            );
        }

        @Test
        @DisplayName("TC32: Maximum 32-bit int perimeter (715827882, 715827882, 715827883)")
        void maxIntPerimeterBoundary() {
            int a = 715_827_882;
            int b = 715_827_883;
            Triangle t = new Triangle(a, a, b);
            double s = (a + (double) a + b) / 2.0;
            double expectedArea = Math.sqrt(s * (s - a) * (s - a) * (s - b));
            assertAll(
                    () -> assertEquals("isosceles", t.classify()),
                    () -> assertFalse(t.isEquilateral()),
                    () -> assertTrue(t.isIsosceles()),
                    () -> assertFalse(t.isRightAngled()),
                    () -> assertFalse(t.isScalene()),
                    () -> assertFalse(t.isImpossible()),
                    () -> assertEquals(Integer.MAX_VALUE, t.getPerimeter()),
                    () -> assertEquals(expectedArea, t.getArea(), expectedArea * 1e-6)
            );
        }

        @Test
        @DisplayName("TC33: Integer.MAX_VALUE sides (exposes addition overflow in validity checks)")
        void integerMaxValueSides() {
            int max = Integer.MAX_VALUE;
            Triangle t = new Triangle(max, max, max);
            double expectedArea = (Math.sqrt(3) / 4.0) * (double) max * (double) max;
            assertAll(
                    () -> assertEquals("equilateral", t.classify()),
                    () -> assertTrue(t.isEquilateral()),
                    () -> assertTrue(t.isIsosceles()),
                    () -> assertFalse(t.isImpossible()),
                    () -> assertEquals(expectedArea, t.getArea(), expectedArea * 1e-6)
            );
        }

        @Test
        @DisplayName("TC34: Integer.MIN_VALUE sides (exposes Math.abs overflow)")
        void integerMinValueSides() {
            int min = Integer.MIN_VALUE;
            Triangle t = new Triangle(min, min, min);
            assertTriangleState(t, "impossible", false, false, false, false, true, -1, -1.0);
        }
    }

    @Nested
    @DisplayName("State Mutation & Formatting Methods")
    class MutationAndFormatting {

        @Test
        @DisplayName("TC35: setSideLengths returns same reference and updates all properties")
        void setSideLengthsValidToValid() {
            Triangle original = new Triangle(3, 4, 5);
            Triangle returned = original.setSideLengths(1, 1, 1);

            assertSame(original, returned, "setSideLengths() should return 'this'");
            double expectedArea = Math.sqrt(3) / 4.0;
            assertTriangleState(returned, "equilateral", true, true, false, false, false, 3, expectedArea);
        }

        @Test
        @DisplayName("TC36: setSideLengths transitions cleanly between valid and impossible")
        void setSideLengthsValidToImpossibleAndBack() {
            Triangle t = new Triangle(5, 5, 5);
            assertFalse(t.isImpossible());

            t.setSideLengths(0, 5, 5);
            assertTriangleState(t, "impossible", false, false, false, false, true, -1, -1.0);

            t.setSideLengths(3, 4, 5);
            assertTriangleState(t, "right-angled", false, false, true, false, false, 12, 6.0);
        }

        @Test
        @DisplayName("TC37: getSideLengths returns comma-separated values and reflects mutations")
        void getSideLengthsFormatting() {
            Triangle t = new Triangle(3, 4, 5);
            assertEquals("3,4,5", t.getSideLengths().replaceAll("\\s+", ""));

            t.setSideLengths(7, 8, 9);
            assertEquals("7,8,9", t.getSideLengths().replaceAll("\\s+", ""));
        }
    }
}
