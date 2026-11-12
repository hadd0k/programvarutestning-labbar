package wb;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Specification-based tests for NextDate, written to reach full statement
 * and branch coverage. Expected values follow the real calendar, so a test
 * that fails points to a defect in NextDate.
 */
public class NextDateClaudeTests {

    private String next(int month, int day, int year) {
        return new NextDate(month, day, year).run(month, day, year);
    }

    private void assertInvalid(int month, int day, int year) {
        String result = next(month, day, year);
        assertTrue("Expected an invalid-date message for " + month + "/" + day + "/" + year
                + " but got: " + result, result.toLowerCase().contains("invalid"));
    }

    // ---------- Input validation ----------

    @Test
    public void rejectsMonthBelowRange() { assertInvalid(0, 10, 2000); }

    @Test
    public void rejectsMonthAboveRange() { assertInvalid(13, 10, 2000); }

    @Test
    public void rejectsDayBelowRange() { assertInvalid(5, 0, 2000); }

    @Test
    public void rejectsYearBelowRange() { assertInvalid(5, 10, 1800); }

    @Test
    public void rejectsYearAboveRange() { assertInvalid(5, 10, 2022); }

    @Test
    public void acceptsLowestYear() { assertEquals("5/11/1801", next(5, 10, 1801)); }

    // ---------- 31-day months (Jan, Mar, May, Jul, Aug, Oct) ----------

    @Test
    public void januaryMidMonth() { assertEquals("1/16/2010", next(1, 15, 2010)); }

    @Test
    public void marchMidMonth() { assertEquals("3/16/2010", next(3, 15, 2010)); }

    @Test
    public void mayMidMonth() { assertEquals("5/16/2010", next(5, 15, 2010)); }

    @Test
    public void julyMidMonth() { assertEquals("7/16/2010", next(7, 15, 2010)); }

    @Test
    public void augustMidMonth() { assertEquals("8/16/2010", next(8, 15, 2010)); }

    @Test
    public void octoberMidMonth() { assertEquals("10/16/2010", next(10, 15, 2010)); }

    @Test
    public void januaryLastDay() { assertEquals("2/1/2010", next(1, 31, 2010)); }

    @Test
    public void julyLastDay() { assertEquals("8/1/2010", next(7, 31, 2010)); }

    @Test
    public void augustLastDay() { assertEquals("9/1/2010", next(8, 31, 2010)); }

    @Test
    public void thirtyOneDayMonthRejectsDay32() { assertInvalid(3, 32, 2010); }

    // ---------- 30-day months (Apr, Jun, Sep, Nov) ----------

    @Test
    public void aprilMidMonth() { assertEquals("4/16/2010", next(4, 15, 2010)); }

    @Test
    public void juneMidMonth() { assertEquals("6/16/2010", next(6, 15, 2010)); }

    @Test
    public void septemberMidMonth() { assertEquals("9/16/2010", next(9, 15, 2010)); }

    @Test
    public void novemberMidMonth() { assertEquals("11/16/2010", next(11, 15, 2010)); }

    @Test
    public void juneLastDay() { assertEquals("7/1/2010", next(6, 30, 2010)); }

    @Test
    public void thirtyDayMonthRejectsDay31() { assertInvalid(9, 31, 2010); }

    // ---------- December ----------

    @Test
    public void decemberMidMonth() { assertEquals("12/16/2010", next(12, 15, 2010)); }

    @Test
    public void decemberLastDayRollsYear() { assertEquals("1/1/2011", next(12, 31, 2010)); }

    @Test
    public void decemberLastDayOfLastYearIsInvalid() { assertInvalid(12, 31, 2021); }

    @Test
    public void decemberRejectsDay32() { assertInvalid(12, 32, 2010); }

    @Test
    public void decemberRejectsDay32InLastYear() { assertInvalid(12, 32, 2021); }

    // ---------- February / leap years ----------

    @Test
    public void februaryMidMonth() { assertEquals("2/16/2010", next(2, 15, 2010)); }

    @Test
    public void february28NonLeapYear() { assertEquals("3/1/2019", next(2, 28, 2019)); }

    @Test
    public void february28LeapYear() { assertEquals("2/29/2016", next(2, 28, 2016)); }

    @Test
    public void february28CenturyNonLeapYear() { assertEquals("3/1/1900", next(2, 28, 1900)); }

    @Test
    public void february28CenturyLeapYear() { assertEquals("2/29/2000", next(2, 28, 2000)); }

    @Test
    public void february29LeapYear() { assertEquals("3/1/2016", next(2, 29, 2016)); }

    @Test
    public void february29NonLeapYearIsInvalid() { assertInvalid(2, 29, 2019); }

    @Test
    public void february30IsInvalid() { assertInvalid(2, 30, 2016); }

    // ---------- main ----------

    @Test
    public void mainPrintsNextDate() {
        PrintStream original = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        try {
            NextDate.main(new String[]{"6", "15", "2010"});
        } finally {
            System.setOut(original);
        }
        assertEquals("Type: 6/16/2010", out.toString().trim());
    }
}
