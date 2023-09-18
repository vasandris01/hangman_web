package com.example.hangman_web.model;

public class Game {
    private String word;
    private String wordAtLine;

    public Game(){
        word = "macska";
        wordAtLine = "_".repeat(word.length());
    }


    public boolean isInTheWord(String string){
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
}
