package com.kata.calculator;

public class Calculator {

    private int result = 0;
    private String numbers;

    public int add(String numbers) {
        if(numbers.isEmpty())
            return 0;

        setNumbers(numbers);
        cleanNumbersString();

        if(checkNumbersString())
            return calcul();
        else
            return -1;
    }

    private void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    private void cleanNumbersString() {
        trimNumbersString();
        ReplaceSeparator();
        removeLastSeparatorIfExist();
    }

    private void trimNumbersString() {
        this.numbers = numbers.trim();
    }

    private void ReplaceSeparator() {
        this.numbers = this.numbers.replaceAll("\n", ",");
    }

    private void removeLastSeparatorIfExist() {
        if(this.numbers.lastIndexOf(",") == this.numbers.length()-1)
            this.numbers = this.numbers.substring(0, this.numbers.length()-1);
    }

    private boolean checkNumbersString() {
        if(this.numbers.contains(",\n"))
            return false;
        return true;
    }

    private int calcul() {
        if (getSeparatorPosition() != -1) {
            result += extractNumber();
            extractEndNumbers();
            calcul();
        } else
            result += getIntegerNumber();

        return result;
    }

    private Integer getIntegerNumber() {
        return Integer.valueOf(this.numbers);
    }

    private int getSeparatorPosition() {
        return this.numbers.indexOf(",");
    }

    private int extractNumber() {
        String number = numbers.substring(0, getSeparatorPosition());
        if( number.isEmpty())
            return 0;
        else
            return Integer.valueOf(number);
    }

    private void extractEndNumbers() {
        this.numbers = numbers.substring(getSeparatorPosition()+1);
    }
}
