package wb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextDateStatementTest {

    private String nextDate(int year, int month, int day) {
        return new NextDate(month, day, year).run(month, day, year);
    }

    // R1 (node 3)
    @Test
    public void testInvalidInput() {
        assertEquals("invalid Input Date", nextDate(2020, 1, 0));
    }

    // node 11
    @Test
    public void testThirtyOneDayMonthNormalDay() {
        assertEquals("1/6/2020", nextDate(2020, 1, 5));
    }

    // node 12
    @Test
    public void testThirtyOneDayMonthBoundary() {
        assertEquals("2/1/2020", nextDate(2020, 1, 31));
    }

    // node 15
    @Test
    public void testThirtyDayMonthNormalDay() {
        assertEquals("4/6/2020", nextDate(2020, 4, 5));
    }

    // node 17
    @Test
    public void testThirtyDayMonthBoundary() {
        assertEquals("5/1/2020", nextDate(2020, 4, 30));
    }

    // R2 (node 18)
    @Test
    public void testThirtyDayMonthInvalidInput() {
        assertEquals("Invalid Input Date", nextDate(2020, 4, 31));
    }

    // node 21
    @Test
    public void testDecemberNormalDay() {
        assertEquals("12/6/2020", nextDate(2020, 12, 5));
    }

    // nodes 22 + 25 (måste använda dag 32)
    @Test
    public void testDecemberBoundary() {
        assertEquals("Invalid Input Date", nextDate(2020, 12, 32));
    }

    // R3 (node 24)
    @Test
    public void testDecemberInvalidYear() {
        assertEquals("Invalid Input Date", nextDate(2021, 12, 32));
    }

    // node 28
    @Test
    public void testFebruaryNormalDay() {
        assertEquals("2/6/2020", nextDate(2020, 2, 5));
    }

    // node 31
    @Test
    public void testFebruary28WithLeapYear() {
        assertEquals("2/29/2020", nextDate(2020, 2, 28));
    }

    // node 32
    @Test
    public void testFebruary28() {
        assertEquals("3/1/2019", nextDate(2019, 2, 28));
    }

    // node 35
    @Test
    public void testFebruary29WithLeapYear() {
        assertEquals("3/1/2020", nextDate(2020, 2, 29));
    }

    // R4 (node 36)
    @Test
    public void testFebruary29() {
        assertEquals("Invalid Input Date", nextDate(2019, 2, 29));
    }

    // R4 (rad 99, day > 29)
    @Test
    public void testFebruaryInvalidDay() {
        assertEquals("Invalid Input Date", nextDate(2020, 2, 30));
    }
}
