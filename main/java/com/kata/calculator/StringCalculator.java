package com.kata.calculator;

public class StringCalculator {

    private int result = 0;
    private String numbers;
    private String separator = ",";
    private String negativeNumbers = "";
    private boolean isNegativesNumbers = false;

    public int add(String numbers) {
        if(numbers.isEmpty())
            return 0;

        setNumbers(numbers);
        if(isStartsWith(numbers)){
            extractAndSetSeparator(numbers);
        }
        cleanNumbersString();

        if(checkNumbersString()){
            int result =  calcul();
            if(this.isNegativesNumbers){
                System.out.println("negatives not allowed " + negativeNumbers);
                throw new NumberFormatException();
            }
            return result;
        }
        else
            return -1;
    }

    private void extractAndSetSeparator(String numbers) {
        int posOfNewLine = numbers.indexOf("\n");
        String separator = numbers.substring(2, posOfNewLine);
        this.numbers = numbers.substring(posOfNewLine);
        setSeparator(separator);
    }

    private boolean isStartsWith(String numbers) {
        return numbers.startsWith("//");
    }

    private void setSeparator(String separator) {
        this.separator = separator;
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
        this.numbers = this.numbers.replaceAll("\n", this.separator);
    }

    private void removeLastSeparatorIfExist() {
        if(this.numbers.lastIndexOf(this.separator) == this.numbers.length()-1)
            this.numbers = this.numbers.substring(0, this.numbers.length()-1);
    }

    private boolean checkNumbersString() {
        return !this.numbers.contains(",\n");
    }

    private int calcul() {
        if (getSeparatorPosition() != -1) {
            result += extractNumber();
            extractEndNumbers();
            calcul();
        } else {
            String number = this.numbers;
            result += getIntegerNumber(number);
        }
        return result;
    }

    private Integer getIntegerNumber(String number) {
        int intNumber = Integer.parseInt(number);
        if(intNumber < 0) {
            this.isNegativesNumbers = true;
            this.negativeNumbers += number;
        }
        return intNumber;
    }

    private int getSeparatorPosition() {
        return this.numbers.indexOf(this.separator);
    }

    private int extractNumber() {
        String number = numbers.substring(0, getSeparatorPosition());
        if( number.isEmpty())
            return 0;
        else
            return getIntegerNumber(number);
    }

    private void extractEndNumbers() {
        this.numbers = numbers.substring(getSeparatorPosition()+1);
    }
}
