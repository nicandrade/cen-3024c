package com.word.module7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyTest {

    private WordFrequency testObject = new WordFrequency("ventriloquist",5);
    @Test
    void getCount() {
        assertEquals(5, testObject.getCount());
    }

    @Test
    void getWord() {
        assertFalse(Boolean.parseBoolean("performer"),testObject.getWord());
    }

    @Test
    void compareTo() {
        WordFrequency compareObject = new WordFrequency("stage",3);
        assertEquals(-2, testObject.compareTo(compareObject));
    }
}