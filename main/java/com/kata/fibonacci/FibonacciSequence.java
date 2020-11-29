package com.kata.fibonacci;

import java.util.ArrayList;

public class FibonacciSequence {

    private ArrayList<String> sequence = new ArrayList<String>();
    private String result = "";

    private String COMMA = ", ";

    public String generate(int iteration){

        initTheSequence();

        for (int i=0; i < iteration; i++){
            if(i>=2){
                getSequenceMember(i);
            }
            else{
                result += sequence.get(i) + COMMA;
            }
        }
        return result.substring(0, result.length()-2);
    }

    private void initTheSequence() {
        sequence.add("0");
        sequence.add("1");
    }

    private void getSequenceMember(int i) {
        int member = getMember(i);
        sequence.add(String.valueOf(member));
        result += String.valueOf(member) + COMMA;
    }

    private int getMember(int i) {
        return Integer.parseInt(sequence.get(i-2)) +
                Integer.parseInt(sequence.get(i-1));
    }

}
