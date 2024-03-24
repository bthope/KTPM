package vn.edu.ueh.bit.sol2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialCalculator {
    public static void main(String[] args) {
        String dathuc = "-5x^3 + 9x^6 - 3x + 6x^2 + 8";
        int x = 5; // Giá trị của x

        int result = calculatePolynomialValue(dathuc, x);
        System.out.println("Gia tri cua bieu thuc khi x = " + x + " la: " + result);
    }

    public static int calculatePolynomialValue(String polynomial, int x) {

        polynomial = polynomial.replaceAll("\\s", "");

        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(polynomial);

        int result = 0;
        while (matcher.find()) {
            String term = matcher.group();


            int value = calculateTermValue(term, x);


            result += value;
        }

        return result;
    }

    public static int calculateTermValue(String term, int x) {
        // Tìm hệ số và số mũ của từng thành phần
        String[] parts = term.split("x\\^?");
        int coefficient = 0;
        int exponent = 0;

        if (parts.length >= 1) {
            coefficient = Integer.parseInt(parts[0]);
        }
        if (parts.length >= 2) {
            exponent = Integer.parseInt(parts[1]);
        }

        return coefficient * (int) Math.pow(x, exponent);
    }
}

