package ru.melnikov.calculator.check;

import ru.melnikov.calculator.enums.RomanNumerals;

import java.io.IOException;
import java.util.List;

public class CheckExpressionImpl implements CheckExpression{

    public void check(List<String> list) throws IOException {
        sizeList(list);
        arithmeticOperations(list);
    }

    public void sizeList(List<String> list) throws IOException {
        if (list.size() != 3) {
            throw new IOException("Exception: Invalid expression, try entering \"5 * 6\" or \"VI + II\"");
        }
    }

    public void arithmeticOperations(List<String> list) throws IOException {
        if (!list.get(1).equals("*")
                && !list.get(1).equals("/")
                && !list.get(1).equals("+")
                && !list.get(1).equals("-")) {
            throw new IOException("Exception: Not a suitable math function, you should choose one of the \" * / + -\" ");
        }
    }

    public boolean checkArabian(String value) {
        try {
            return Integer.parseInt(value) > 0 && Integer.parseInt(value) <= 10;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public boolean checkRoman(String value) {
        for (RomanNumerals r : RomanNumerals.values()) {
            if (value.equals(r.getValue())) {
                return true;
            }
        }
        return false;
    }
}
