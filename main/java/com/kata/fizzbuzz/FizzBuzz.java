package com.kata.fizzbuzz;

public class FizzBuzz {

    public String generate(int min, int max) {
        return evaluateNumbers(min, max);
    }

    private String evaluateNumbers(int min, int max){
        String result = evaluateNumber(min);
        while (min < max)
            result += evaluateNumber(++min);
        return result;
    }

    private String evaluateNumber(int number) {
        if(number % 15 == 0)
            return "FizzBuzz";
        if(number % 5 == 0)
            return "Buzz";
        if (number % 3 == 0)
            return "Fizz";
        return String.valueOf(number);
    }
}
