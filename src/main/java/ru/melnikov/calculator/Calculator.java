package ru.melnikov.calculator;

import ru.melnikov.calculator.check.CheckExpression;
import ru.melnikov.calculator.convertors.MyConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static final CheckExpression EXPRESSION = new CheckExpression();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> list = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
            EXPRESSION.check(list);
            if (EXPRESSION.checkArabian(list.get(0)) && EXPRESSION.checkArabian(list.get(2))) {
                System.out.println(arabianCalculation(list));
            } else if (EXPRESSION.checkRoman(list.get(0)) && EXPRESSION.checkRoman(list.get(2))) {
                System.out.println(romanCalculation(list));
            } else {
                throw new IOException("Exception: Please use numbers from 1 to 10 in Roman or Arabic format only");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String arabianCalculation(List<String> list) throws IOException {
        int answer = 0;
        String arithmeticFunction = list.get(1);

        switch (arithmeticFunction) {
            case "*":
                answer = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(2));
                break;
            case "/":
                answer = Integer.parseInt(list.get(0)) / Integer.parseInt(list.get(2));
                break;
            case "+":
                answer = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(2));
                break;
            case "-":
                answer = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(2));
                break;
        }
        if (answer <= 0) {
            throw new IOException("Exception: Invalid response value!!!");
        }
        return String.valueOf(answer);
    }

    public static String romanCalculation(List<String> list) throws IOException {
        int answer = 0;
        String arithmeticFunction = list.get(1);
        MyConverter converter = new MyConverter();

        switch (arithmeticFunction) {
            case "*":
                answer = converter.toArabian(list.get(0)) * converter.toArabian(list.get(2));
                break;
            case "/":
                answer = converter.toArabian(list.get(0)) / converter.toArabian(list.get(2));
                break;
            case "+":
                answer = converter.toArabian(list.get(0)) + converter.toArabian(list.get(2));
                break;
            case "-":
                answer = converter.toArabian(list.get(0)) - converter.toArabian(list.get(2));
                break;
        }

        if (answer <= 0) {
            throw new IOException("Exception: Invalid response value!!!");
        }
        return converter.toRoman(answer);
    }
}
