package com.kata.calculator;

public class StringCalculator {

    private int result = 0;
    private String numbers;
    private String separator = ",";;
    private String negativeNumbers = "";
    private boolean isNegativesNumbers = false;

    public int add(String numbers) {
        if(numbers.isEmpty())
            return 0;
        treatStringNumbers(numbers);
        return theResult();
    }

    private void treatStringNumbers(String numbers) {
        setNumbers(numbers);
        if(isStartWithSeparator()){
            extractAndSetSeparator();
        }
        cleanNumbersString();
    }

    private void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    private boolean isStartWithSeparator() {
        return this.numbers.startsWith("//");
    }

    private void extractAndSetSeparator() {
        int posOfNewLine = this.numbers.indexOf("\n");
        this.separator = this.numbers.substring(2, posOfNewLine);
        if(this.separator.startsWith("[")) {
            int pos = this.separator.length()-1;
            this.separator = this.separator.substring(1, pos);
        }
        this.numbers = this.numbers.substring(posOfNewLine);
    }

    private void cleanNumbersString() {
        trimNumbersString();
        replaceSeparator();
        removeLastSeparatorIfExist();
    }

    private void trimNumbersString() {
        this.numbers = numbers.trim();
    }

    private void replaceSeparator() {
        this.numbers = this.numbers.replaceAll("\n", this.separator);
    }

    private void removeLastSeparatorIfExist() {
        if(this.numbers.lastIndexOf(this.separator) == this.numbers.length()-1)
            this.numbers = this.numbers.substring(0, this.numbers.length()-1);
    }

    private int theResult() {
        int result =  calcul();
        negativeNumber();
        return result;
    }

    private int calcul() {
        if (getSeparatorPosition() != -1) {
            this.result += extractNumber();
            extractEndNumbers();
            calcul();
        } else {
            String number = this.numbers;
            this.result += getIntegerNumber(number);
        }
        return this.result;
    }

    private int getSeparatorPosition() {
        return this.numbers.indexOf(this.separator) ;
    }

    private int extractNumber() {
        String number = this.numbers.substring(0, getSeparatorPosition());
        if( number.isEmpty())
            return 0;
        else
            return getIntegerNumber(number);
    }

    private void extractEndNumbers() {
        this.numbers = numbers.substring(getSeparatorPosition()+this.separator.length());
    }

    private Integer getIntegerNumber(String number) {
        int intNumber = Integer.parseInt(number);
        if(intNumber < 0) {
            this.isNegativesNumbers = true;
            this.negativeNumbers += number;
        }

        if(intNumber > 1000)
            intNumber = 0;

        return intNumber;
    }

    private void negativeNumber() {
        if(this.isNegativesNumbers){
            System.out.println("negatives not allowed " + negativeNumbers);
            throw new NumberFormatException();
        }
    }
 }
