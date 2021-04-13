import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * CalcTest.
 *
 * @author Aydar_Safiullin
 */
public class CalcTest {
    Calc calc;

    @BeforeEach
    public void init() {
        calc = new Calc();
    }

    @Test
    public void testEmptyStringSum() {
        int actual = calc.sum("");
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleNumberStringSum() {
        int actual = calc.sum("1");
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testTwoNumbersSum() {
        int actual = calc.sum("1,2");
        int expected = 3;
        assertEquals(expected, actual);
    }
}
