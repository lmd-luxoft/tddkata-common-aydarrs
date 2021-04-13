/**
 * Calc.
 *
 * @author Aydar_Safiullin
 */
public class Calc {
    public int sum(String expression) {
        if ("".equals(expression)) {
            return 0;
        }

        int result = 0;
        try {
            String[] numbers = expression.split(",");
            for (String number : numbers) {
                number.trim();
                result += Integer.parseInt(number);
            }
        } catch (Exception e) {
                return -1;
        }

        return result;
    }
}
