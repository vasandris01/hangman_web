package com.example.hangman_web.model;

public class Game {
    private String word;
    private String wordAtLine;

    public Game(){
        word = "macska";
        wordAtLine = "_".repeat(word.length());
    }

    public void useChoice(String choice){

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
}
