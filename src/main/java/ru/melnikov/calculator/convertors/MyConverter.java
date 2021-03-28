package ru.melnikov.calculator.convertors;

import ru.melnikov.calculator.enums.RomanNumerals;

public class MyConverter {

    public String toRoman(int n) {
        StringBuilder result = new StringBuilder();

        int[] arabicValues = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanValues = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < arabicValues.length; i++) {
            while (n >= arabicValues[i]){
                n -= arabicValues[i];
                result.append(romanValues[i]);
            }
        }
        return result.toString();
    }

    public int toArabian(String value){
        for (RomanNumerals r: RomanNumerals.values()){
            if (value.equals(r.getValue())){
                return r.ordinal() + 1;
            }
        }
        return 0;
    }
}
