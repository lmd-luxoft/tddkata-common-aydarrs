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

    /**
     * Проверка на пустую строку
     */
    @Test
    public void testEmptyStringSum() {
        int actual = calc.sum("");
        int expected = 0;
        assertEquals(expected, actual);
    }

    /**
     * Проверка со строкой в виде одного числа
     */
    @Test
    public void testSingleNumberStringSum() {
        int actual = calc.sum("1");
        int expected = 1;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на строку из нескольких чисел (в данном случае сто единиц, для удобства проверки).
     */
    @Test
    public void testSeveralNumbersSum() {
        Random randomizer = new Random();
        StringJoiner joiner = new StringJoiner("");
        int numbersCount = randomizer.nextInt(100);
        for (int i = 0; i < numbersCount; i++) {
            joiner.add("1,");
        }

        int actual = calc.sum(joiner.toString());
        assertEquals(numbersCount, actual);
    }

    /**
     * Проверка на строку, содержащую отрицательное число
     */
    @Test
    public void testFailNegativeNumberSum() {
        int actual = calc.sum("-3,2");
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на строку, содержащую нечисловые данные
     */
    @Test
    public void testFailNotNumberSum() {
        int actual = calc.sum("It's a trap!,2, 6");
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на null
     */
    @Test
    public void testFailNullSum() {
        int actual = calc.sum(null);
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на корректную сумму из выражения, содержащего перевод строки
     */
    @Test
    public void testWithNewLineSum() {
        int actual = calc.sum("1\n2,3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на выполнение, содержащего некоректный перевод строки с запятой после
     */
    @Test
    public void testFailWithNewLineAndComaSum() {
        int actual = calc.sum("1\n,2,3");
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на выполнение, содержащего некоректный перевод строки с запятой до
     */
    @Test
    public void testFailWithComaAndNewLineSum() {
        int actual = calc.sum("1,\n2,3");
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на выполнение, содержащего некоректный перевод строки с запятой до и после
     */
    @Test
    public void testFailWithComaAndNewLineAndComaSum() {
        int actual = calc.sum("1,\n,2,3");
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на выполнение, с заданным разделителем
     */
    @Test
    public void testWithSpecifiedDelimeterAndComaSum() {
        int actual = calc.sum(";\n1;2;3");
        int expected = 6;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на выполнение, с заданным разделителем и намереной ошибкой ввода
     */
    @Test
    public void testFailWithSpecifiedDelimeterAndComaSum() {
        int actual = calc.sum(";\n1;,2;б3");
        int expected = -1;
        assertEquals(expected, actual);
    }

    /**
     * Проверка на выполнение, с пустым разделителем
     */
    @Test
    public void testFailWithEmptySpecifiedDelimeterAndComaSum() {
        int actual = calc.sum("\n1,2,3");
        int expected = -1;
        assertEquals(expected, actual);
    }
}
