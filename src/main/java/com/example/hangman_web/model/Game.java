package com.example.hangman_web.model;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private String word;
    private String wordAtLine;
    private int life = 10;
    private Set<Character> inputs = new HashSet<>();
    private boolean isEnd = false;
    public Game(){
        word = "macska";
        wordAtLine = "_".repeat(word.length());
    }

    public void useChoice(String choice){
        if(inputs.add(choice.charAt(0))){
            if(isInTheWord(choice)){
                overRideLine(choice);
            } else {
                --life;
            }
        }
        if(life == 0 || word.equals(wordAtLine)){
            isEnd = true;
        }
    }

    private void overRideLine(String input){
        char inputAtChar = input.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == inputAtChar){
                wordAtLine =
                        wordAtLine.substring(0,i)
                        + inputAtChar
                        + wordAtLine.substring(i+1);
            }
        }
    }
    private boolean isInTheWord(String string){
        overRideLine(string);
        return word.contains(string);
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordAtLine() {
        return wordAtLine;
    }

    public void setWordAtLine(String wordAtLine) {
        this.wordAtLine = wordAtLine;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Set<Character> getInputs() {
        return inputs;
    }

    public void setInputs(Set<Character> inputs) {
        this.inputs = inputs;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
