package com.sofka.questionsgame;

import java.util.*;
import java.util.ArrayList;

public class Question {
    private String statement;
    private String rightAnswer;
    private String option1;
    private String option2;
    private String option3;
    private ArrayList<String> options;


    public Question(String statement, String rightAnswer, String option1, String option2, String option3) {
         //Instanciar ArrayList
        options = new ArrayList<String>();
        
        this.statement = statement;
        this.rightAnswer = rightAnswer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        
        options.add(rightAnswer);
        options.add(option1);
        options.add(option2);
        options.add(option3);
        
        Collections.shuffle(options);       
    }

    public String getStatement() {
        return statement;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
    
    public String getRightAnswer() {
        return rightAnswer;
    }

}
