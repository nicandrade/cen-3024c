package com.word.module7;

/**
 * This class is used to define objects that store a word value and the number of instances it appears in a document/URL.
 * @author Nic Andrade
 */
public class WordFrequency extends App implements Comparable <WordFrequency> {
    private String word;
    private int count;

    /**
     *This is method establishes the object with a word and count of the word.
     *
     * @param word String to store the word variable.
     * @param count Integer to store the count of the word variable.
     */
    public WordFrequency (String word, int count){
        this.word = word;
        this.count = count;
    }

    /**
     * Method to return the count of the WordFrequency object.
     *
     * @return Integer value of the object.
     */
    public int getCount() {
        return count;
    }

    /**
     * Method to return the string of the WordFrequency object.
     *
     * @return String value of the object.
     */
    public String getWord() {
        return word;
    }

    /**
     * Method used to compare two objects count values.
     *
     * @param o the object to be compared.
     * @return Integer count of the calculated value.
     */
    @Override
    public int compareTo(WordFrequency o) {
        return o.getCount()-this.getCount();
    }

}
