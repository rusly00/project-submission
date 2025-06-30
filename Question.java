package application;

public class Question {
    public String question, optionA, optionB, optionC, optionD;
    public char correctOption;

    public Question(String q, String a, String b, String c, String d, char correct) {
        question = q;
        optionA = a;
        optionB = b;
        optionC = c;
        optionD = d;
        correctOption = correct;
    }
}