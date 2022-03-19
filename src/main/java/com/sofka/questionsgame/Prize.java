package com.sofka.questionsgame;

public class Prize {
    private int difficultyLevel;
    private int prize;
   
   public Prize(int difficultyLevel){
       if (difficultyLevel == 1){
           prize = 5000; 
       }else if(difficultyLevel == 2){
           prize = 10000;
       }else if(difficultyLevel == 3){
           prize = 15000;
       }else if(difficultyLevel == 4){
           prize = 20000;
       }else if (difficultyLevel == 5){
           prize = 50000;
       }
   }
   
    public int getPrize() {
        return prize;
    }
}
