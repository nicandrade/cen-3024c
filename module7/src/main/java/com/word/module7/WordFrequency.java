package com.word.module7;

public class WordFrequency extends App implements Comparable <WordFrequency> {
    private String word;
    private int count;

    public WordFrequency (String word, int count){
        this.word = word;
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(WordFrequency o) {
        return o.getCount()-this.getCount();
    }

}
