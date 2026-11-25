package wb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextDateBranchTest {

    private String nextDate(int year, int month, int day) {
        return new NextDate(month, day, year).run(month, day, year);
    }

    // node 2 true
    @Test
    public void testInvalidDay() {
        assertEquals("invalid Input Date", nextDate(2020, 1, 0));
    }

    // node 4 true
    @Test
    public void testInvalidMonthLow() {
        assertEquals("invalid Input Date", nextDate(2020, 0, 1));
    }

    // node 5 true
    @Test
    public void testInvalidMonthHigh() {
        assertEquals("invalid Input Date", nextDate(2020, 13, 1));
    }

    // node 6 true
    @Test
    public void testInvalidYearLow() {
        assertEquals("invalid Input Date", nextDate(1800, 1, 1));
    }

    // node 7 true
    @Test
    public void testInvalidYearHigh() {
        assertEquals("invalid Input Date", nextDate(2022, 1, 1));
    }

    // node 9 true, node 10 true
    @Test
    public void testThirtyOneDayMonthNormalDay() {
        assertEquals("1/6/2020", nextDate(2020, 1, 5));
    }

    // node 10 false
    @Test
    public void testThirtyOneDayMonthBoundary() {
        assertEquals("2/1/2020", nextDate(2020, 1, 31));
    }

    // node 9 false, node 13 true, node 14 true
    @Test
    public void testThirtyDayMonthNormalDay() {
        assertEquals("4/6/2020", nextDate(2020, 4, 5));
    }

    // node 14 false, node 16 true
    @Test
    public void testThirtyDayMonthBoundary() {
        assertEquals("5/1/2020", nextDate(2020, 4, 30));
    }

    // node 16 false
    @Test
    public void testThirtyDayMonthInvalidInput() {
        assertEquals("Invalid Input Date", nextDate(2020, 4, 31));
    }

    // node 13 false, node 19 true, node 20 true
    @Test
    public void testDecemberNormalDay() {
        assertEquals("12/6/2020", nextDate(2020, 12, 5));
    }

    // node 20 false, node 23 false
    @Test
    public void testDecemberBoundary() {
        assertEquals("Invalid Input Date", nextDate(2020, 12, 32));
    }

    // node 23 true
    @Test
    public void testDecemberInvalidYear() {
        assertEquals("Invalid Input Date", nextDate(2021, 12, 32));
    }

    // node 19 false, node 26 true, node 27 true
    @Test
    public void testFebruaryNormalDay() {
        assertEquals("2/6/2020", nextDate(2020, 2, 5));
    }

    // node 27 false, node 29 true, node 30 true
    @Test
    public void testFebruary28WithLeapYear() {
        assertEquals("2/29/2020", nextDate(2020, 2, 28));
    }

    // node 30 false
    @Test
    public void testFebruary28() {
        assertEquals("3/1/2019", nextDate(2019, 2, 28));
    }

    // node 29 false, node 33 true, node 34 true
    @Test
    public void testFebruary29WithLeapYear() {
        assertEquals("3/1/2020", nextDate(2020, 2, 29));
    }

    // node 34 false
    @Test
    public void testFebruary29() {
        assertEquals("Invalid Input Date", nextDate(2019, 2, 29));
    }

    // node 33 false, node 37 true
    @Test
    public void testFebruaryInvalidDay() {
        assertEquals("Invalid Input Date", nextDate(2020, 2, 30));
    }

    // node 26 false (July is in none of the month groups)
    @Test
    public void testJuly() {
        assertEquals("7/6/2020", nextDate(2020, 7, 5));
    }
}
