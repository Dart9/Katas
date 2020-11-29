package com.kata.conwaysequence;

public class ConwaySequence {

    private char firstCaract;

    public static void main(String[] args) {
        ConwaySequence conwaySequence = new ConwaySequence();
        conwaySequence.generateSequence("1", 0, 10);
    }

    public void generateSequence(String firstSequenceMember, int currentIteration, int numberMaxOfIteration){
        if (currentIteration == 0)
            System.out.println("1");
        if(currentIteration <= numberMaxOfIteration){
            String result = readMember(firstSequenceMember);
            System.out.println(result);
            generateSequence(result, ++currentIteration, numberMaxOfIteration);
        }
    }

    public String readMember(String member){
        int numberOfStartSequence;
        String result = new String();

        if(member.length() != 0) {
            numberOfStartSequence = extractStartSequence(member);
            result = getResult(numberOfStartSequence);
            member = member.substring(numberOfStartSequence, member.length());
            result += readMember(member);
        }
        return result;
    }

    private String getResult(int numberOfStartSequence) {
        return String.valueOf(numberOfStartSequence) + String.valueOf(firstCaract);
    }

    private int extractStartSequence(String figureSequence) {
        firstCaract = figureSequence.charAt(0);
        int countCaract = 0;

        while (countCaract < figureSequence.length() &&
                    figureSequence.charAt(countCaract) == firstCaract)
            countCaract += 1;

        return countCaract;
    }
}
