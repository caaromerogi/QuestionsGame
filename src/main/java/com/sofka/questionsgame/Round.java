package com.sofka.questionsgame;

import java.util.ArrayList;

public class Round {
    private ArrayList<Category> categories;
    private Category category;
    private Question randomQuestion;
    private int difficultyLevel;
    private Prize prize;
    private Player p1;

    public Round(ArrayList<Category> categories, int difficultyLevel, Player p1) {
        this.categories = categories;
        this.difficultyLevel = difficultyLevel;
        this.p1 = p1;  
    }
    
    //Obtener la categoría correspondiente al nivel de dificultad y asignarla a la ronda
    private void validateCategory(){
        //Vaciar la variable categoria para almacenar la siguiente
        this.category = null;
        //Recorrer las categorias para encontrar la correspondiente al nivel
        for (Category category: categories){
            if (category.getDifficultyLevel() == difficultyLevel){
                this.category = category;
            }
        }
    }
    

    //Con la categoria asignada obtener una pregunta aleatoria
    private void setRandomQuestion(){
        this.validateCategory();
        this.randomQuestion = category.getRandomQuestion();  
    }
    
    public Question getRandomQuestion(){
        this.setRandomQuestion();
        return randomQuestion;
    }
   
    public int getPrize(){
        prize = new Prize(difficultyLevel);
        return prize.getPrize();
    }
    
    public void levelUp(){
        difficultyLevel = difficultyLevel+1; 
    }
    
    public int currentLevel(){
        return difficultyLevel;
    }
    
    public Category getCategory(){
        validateCategory();
        return category;
    }
}
