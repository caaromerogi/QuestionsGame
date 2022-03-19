package com.sofka.questionsgame;


public class Player {
    private String name;
   private int accumulatedPrize;

    public Player(String name) {
        this.name = name;
        this.accumulatedPrize = 0;
    }

    public String getName() {
        return name;
    }

    public int getAccumulatedPrize() {
        return accumulatedPrize;
    }
    
    public void losePrize(){
        this. accumulatedPrize = 0;
    }
  
    public void increaseAccumulated(int prize){
       accumulatedPrize = accumulatedPrize + prize; 
    }
}
