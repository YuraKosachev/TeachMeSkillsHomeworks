package Homework_calculator;

public class CalcOperations {

    private final char[] maxPriority;
    private final char[] operations;
    private final String pattern;

    {
        this.operations = new char[]{'-', '+', '/', '*'};
        this.maxPriority = new char[]{'*', '/'};
        this.pattern = "%.3f";
    }

    private String calculate(String v1, String v2, String operator) {
        double v1Convert = Double.valueOf(v1);
        double v2Convert = Double.valueOf(v2);

        switch (operator) {
            case "+" -> {
                return String.format(this.pattern,sum(v1Convert, v2Convert));
            }
            case "-" -> {
                return String.format(this.pattern,minus(v1Convert, v2Convert));
            }
            case "/" -> {
                return String.format(this.pattern,div(v1Convert, v2Convert));
            }
            default -> {
                return String.format(this.pattern,multi(v1Convert, v2Convert));
            }
        }
    }

    public String getEquationResult(String src) throws Exception {

        if(src == null || src.isEmpty())
            return null;

        String[] result = new String[0];
        StringBuilder builder = new StringBuilder();
        src = Extensions.isContains(src.charAt(src.length() - 1), this.operations)
                ? src.substring(0, src.length() - 1)
                : src;

        String previousVal = null;
        String previousOperator = null;
        for (int i = 0; i < src.length(); i++) {
            if (i != 0 && Extensions.isContains(src.charAt(i), this.operations)) {

                String currentVal = builder.toString();
                String currentOperator = String.valueOf(src.charAt(i));

                if (Extensions.isContains(src.charAt(i), this.maxPriority)) {
                    previousVal = previousVal != null ? calculate(previousVal, currentVal, previousOperator) : currentVal;
                    previousOperator = currentOperator;
                    builder.setLength(0);
                    continue;
                }

                if (previousVal != null) {
                    currentVal = calculate(previousVal, currentVal, previousOperator);
                    previousVal = null;
                    previousOperator = null;
                }

                result = Extensions.extend(result, currentVal);
                result = Extensions.extend(result, currentOperator);
                builder.setLength(0);
                continue;
            }

            builder.append(src.charAt(i));

            if (i == src.length() - 1) {
                String current = builder.toString();
                current = previousVal != null ? calculate(previousVal,current, previousOperator) : current;
                result = Extensions.extend(result, current);
            }
        }

        String calculationResult = null;
        String calculationOperator = null;

        for(int i = 0; i < result.length; i++){

            if(i != 0 && Extensions.isContains(result[i].charAt(0), operations))
            {
                calculationOperator = result[i];
                continue;
            }

            calculationResult = calculationResult == null
                    ? result[i]
                    : calculate(calculationResult, result[i], calculationOperator);
        }

        if(calculationResult.equals("Infinity"))
            throw new Exception("Houston we have a problem!\nPerhaps you are trying to divide by 0");

        return calculationResult;
    }

    private double sum(double v1, double v2) {
        return v1 + v2;
    }

    private double minus(double v1, double v2) {
        return v1 - v2;
    }

    private double multi(double v1, double v2) {
        return v1 * v2;
    }

    private double div(double v1, double v2) {
        return v1 / v2;
    }
}
