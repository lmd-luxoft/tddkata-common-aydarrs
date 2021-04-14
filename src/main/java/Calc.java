import com.sun.xml.internal.ws.util.StringUtils;

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
            String firstSymbol = String.valueOf(expression.charAt(0));
            if (firstSymbol != null && !firstSymbol.matches("\\d+")) {
                return parseWithSpecialDelimiter(result, expression.substring(2), firstSymbol);

            } else {
                if (expression.contains(",\n") || expression.contains("\n,")) {
                    return -1;
                }
                String[] numbers = expression.split(",");
                result = parse(result, numbers);
            }
        } catch (Exception e) {
                return -1;
        }

        return result;
    }

    private int parse(int result, String[] numbers) {
        for (String number : numbers) {
            if (number.contains("\n")) {
                String[] entryNumbers = number.split("\n");
                result += parse(result, entryNumbers);
            } else {
                result += Integer.parseInt(number.trim());
            }
        }
        return result;
    }

    private int parseWithSpecialDelimiter(int result, String expression, String delimiter) {
        String[] entries = expression.split(delimiter);
        return parse(result, entries);
    }
}
