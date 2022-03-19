package com.sofka.questionsgame;

import java.util.ArrayList;
import java.util.Random;

public class Category {
    private int difficultyLevel;
    private ArrayList<Question> questions;
   

    public Category(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    
    public void addQuestions(Question q1, Question q2, Question q3, Question q4, Question q5){
        questions = new ArrayList<Question>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);
        questions.add(q5);

    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }
   
    
    public Question getRandomQuestion(){
        //Generar un número aleatorio entre 0 y 3 para escoger una pregunta aleatoria
        Random random = new Random();
        int numeroRandom = random.nextInt(5);
        //Seleccionar pregunta según el número aleatorio
        Question question = questions.get(numeroRandom);
        return question;
    }
}
