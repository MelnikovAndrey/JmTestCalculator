package ru.melnikov.calculator.enums;

public enum RomanNumerals {
    I("I"),
    II("II"),
    III("III"),
    IV("IV"),
    V("V"),
    VI("VI"),
    VII("VII"),
    VIII("VIII"),
    IX("IX"),
    X("X");

    private final String value;

    RomanNumerals(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
