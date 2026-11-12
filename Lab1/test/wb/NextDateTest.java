package wb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextDateTest {

    // Replace this helper with the actual call to the method under test.
    private String nextDate(int year, int month, int day) {
        return new NextDate(month, day, year).run(month, day, year);
    }

    //testValidInput

    //testThirtyOneDayMonthNormalDay
    //testThirtyOneDayMonthBoundary

    //testThirtyDayMonthNormalDay
    //testThirtyDayMonthBoundary
    //testThirtyDayMonthInvalidInput

    //testDecemberNormalDay
    //testDecemberBoundary
    //testDecemberInvalidYear

    //testFebruaryNormalDay (not 28)
    //testFebruary28WithLeapYear
    //testFebruary28
    //testFebruary29
    //testFebruary29WithLeapYear
    //testFebruaryInvalidDay (over 29)

    @Test
    public void validInput() {
        assertEquals("invalid Input Date", nextDate(2020,0, 1));
        assertEquals("invalid Input Date", nextDate(2020,13, 1));
        assertEquals("invalid Input Date", nextDate(2022,1, 1));
        assertEquals("invalid Input Date", nextDate(1800,1, 1));
        assertEquals("invalid Input Date", nextDate(2020,1, 0));
        assertEquals("invalid Input Date", nextDate(2020,1, 32));
    }

    @Test
    public void testThirtyOneDayMonth() {
        assertEquals("10/6/2020", nextDate(2020, 10, 5));
        assertEquals("11/1/2020", nextDate(2020, 10, 31));
    }

    @Test
    public void testThirtyDayMonth() {
        assertEquals("11/6/2020", nextDate(2020, 11, 5));
        assertEquals("Invalid Input Date", nextDate(2020, 11, 31));
        assertEquals("12/1/2020", nextDate(2020, 11, 30));
    }

    @Test
    public void testDecember() {
        assertEquals("1/1/2021", nextDate(2020, 12, 31));
        assertEquals("12/6/2020", nextDate(2020, 12, 5));
        assertEquals("Invalid Input Date", nextDate(2021, 12, 31));
    }

    @Test
    public void testFebruary() {
        assertEquals("2/6/2020", nextDate(2020, 2, 5));
        assertEquals("3/1/2019", nextDate(2019, 2, 28));
        assertEquals("2/29/2020", nextDate(2020, 2, 28));
        assertEquals("3/1/2020", nextDate(2020, 2, 29));
        assertEquals("Invalid Input Date", nextDate(2019, 2, 29));
        assertEquals("Invalid Input Date", nextDate(2020, 2, 30));
        assertEquals("Invalid Input Date", nextDate(2019, 2, 30));

    }
}
