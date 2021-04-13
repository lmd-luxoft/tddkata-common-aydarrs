import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.StringJoiner;

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

    @Test
    public void testFailNegativeNumberSum() {
        int actual = calc.sum("-3,2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testFailNotNumberSum() {
        int actual = calc.sum("It's a trap!,2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testFailNullSum() {
        int actual = calc.sum(null);
        int expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    public void testManyNumbersSum() {
        Random random = new Random();
        int count = random.nextInt();
        String expression;
        StringJoiner joiner = new StringJoiner("");
        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum++;
        }

        joiner.add(String.valueOf(sum));
        expression = joiner.toString();

        int result = calc.sum(expression);
        assertEquals(result, sum);
    }

    @Test
    public void testFailNegativeNumberManyNumbersSum() {
        Random random = new Random();
        int count = random.nextInt();
        String expression;
        StringJoiner joiner = new StringJoiner("");
        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum++;
        }

        joiner.add(String.valueOf(sum));
        joiner.add("It's a trap");

        expression = joiner.toString();

        int result = calc.sum(expression);
        assertEquals(result, -1);
    }

    @Test
    public void testFailNotNumberManyNumbersSum() {
        Random random = new Random();
        int count = random.nextInt();
        String expression;
        StringJoiner joiner = new StringJoiner("");
        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum++;
        }

        joiner.add(String.valueOf(sum));
        joiner.add("-1");

        expression = joiner.toString();

        int result = calc.sum(expression);
        assertEquals(result, -1);
    }
}
