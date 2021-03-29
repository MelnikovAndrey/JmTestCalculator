package ru.melnikov.calculator.check;

import java.io.IOException;
import java.util.List;

public interface CheckExpression {
    void check(List<String> list) throws IOException;
    void sizeList(List<String> list) throws IOException;
    void arithmeticOperations(List<String> list) throws IOException;
    boolean checkArabian(String value);
    boolean checkRoman(String value);
}
