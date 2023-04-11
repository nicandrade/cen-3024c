package com.word.module7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Primary controller for the JavaFX application.
 * @author Nic Andrade
 */
public class PrimaryController implements Initializable {

    @FXML
    private TableView<WordFrequency> tblWords;
    @FXML
    private TableColumn<WordFrequency, Integer> tblColCount;

    @FXML
    private TableColumn<WordFrequency, String> tblColWord;

    @FXML
    private Button btnPreivewUrl;

    @FXML
    private Button btnGenerateWordCount;

    @FXML
    private Label lblTest;


    @FXML
    private TextArea taPoemText;

    /**
     * Method used to fetch HTML content and clean up the variable of HTML tags and provide basic formating.
     * Additional values are stored as the keys to know when to start/stop the record of the variable.
     * @throws IOException
     */
    @FXML
    protected void previewUrl() throws IOException {
        //Variables
        String rawHtmlText;
        String poemOnlyText;
        String noHtmlText;
        String noPunctuationText;
        URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm"); //URL to be used
        String beforeKeyText = "The Raven"; //Title of poem
        String afterKeyText = "<!--end chapter-->"; //End of poem marker
        List<String> uniqueWordsFromSourceSet = new ArrayList<String>();
        List<String> allWordsFromSourceSet = new ArrayList<String>();
        ArrayList<WordFrequency> wordList = new ArrayList<>();
        int numberOfResults = 20;

        //Get HTML text from URL
        rawHtmlText = getHtmlText(url);

        //Remove text before and after keys
        poemOnlyText = removeExtraContent(rawHtmlText, beforeKeyText, afterKeyText);

        //Remove HTML code
        noHtmlText = removeHtmlTags(poemOnlyText);
        noPunctuationText = removePunctuation(noHtmlText);
        uniqueWordsFromSourceSet = updateUniqueWordsSet(noPunctuationText);
        allWordsFromSourceSet = allWordsFromSource(noPunctuationText);

        //Create frequency list
        WordFrequency[] wordFrequency = new WordFrequency[uniqueWordsFromSourceSet.size()];

        //Create Word with Counts
        WordFrequency word = null;
        for (int i = 0; i < uniqueWordsFromSourceSet.size(); i++) {
            uniqueWordsFromSourceSet.get(i);
            word = new WordFrequency(uniqueWordsFromSourceSet.get(i), Collections.frequency(allWordsFromSourceSet, uniqueWordsFromSourceSet.get(i)));
            wordList.add(word);
        }

        Collections.sort(wordList);
        System.out.println("//---------TOP " + numberOfResults + " WORDS & FREQUENCY---------//");
        for (int i = 0; i < numberOfResults; i++) {
            System.out.println(wordList.get(i).getWord() + " - " + wordList.get(i).getCount());
            list.add(new WordFrequency(wordList.get(i).getWord(),wordList.get(i).getCount()));
        }

        taPoemText.setText(noHtmlText);
    }

    ObservableList<WordFrequency> list = FXCollections.observableArrayList();

    /**
     * Method to load the JavaFX table rows and columns.
     */
    @FXML
    protected void loadWords() {
        tblColWord.setCellValueFactory(new PropertyValueFactory<WordFrequency, String>("word"));
        tblColCount.setCellValueFactory(new PropertyValueFactory<WordFrequency, Integer>("count"));
        tblWords.setItems(list);
    }

    /**
     * Method used to get the URL HTML and store it as a string.
     * @param url URL to be fetch the HTML code
     * @return String of the HTML code from the URL
     * @throws IOException
     */
    public static String getHtmlText(URL url) throws IOException {
        String returnText = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        return returnText;
    }

    /**
     * Method to remove text before and after two keys
     * @param startingText String of text to be analyzed
     * @param beforeText String to search for to remove all text before
     * @param afterText String to search for to remove all text after
     * @return
     */
    public static String removeExtraContent(String startingText, String beforeText, String afterText) {
        String returnText = startingText.substring(startingText.lastIndexOf(beforeText) + 0, startingText.lastIndexOf(afterText));
        return returnText;
    }

    /**
     * Method to remove HTML tags from String
     * @param startingText String of HTML text
     * @return
     */
    public static String removeHtmlTags(String startingText) {
        String returnText = startingText.replaceAll("\\<[^>]*>", "");
        return returnText;
    }


    /**
     * Method to remove punctuation from string; preserving only words
     * @param startingText String of inital text value to be parsed
     * @return String of cleaned up text with no punctuation.
     */
    public static String removePunctuation(String startingText) {
        String returnText = startingText.replaceAll("&mdash", " "); //Remove em-dash
        returnText = returnText.replaceAll("[\n\r]", " "); //Remove extra lines
        returnText = returnText.replaceAll("\\s+", " "); //Remove extra spaces
        returnText = returnText.replaceAll("\\p{Punct}", ""); //Remove punctuation marks
        returnText = returnText.replaceAll("“", ""); //Remove punctuation marks
        returnText = returnText.replaceAll("”", ""); //Remove punctuation marks
        returnText = returnText.replaceAll("  ", ""); //Remove extra space
        returnText = returnText.toLowerCase(); //Standardize word casing
        return returnText;
    }


    /**
     * Method to identify unique words of the provided text, and saved into a Collection
     * @param listOfWords String of the words to be converted to Collection
     * @return Collection of unique words of the provided text
     */
    public static List<String> updateUniqueWordsSet(String listOfWords) {
        List<String> returnSet = new ArrayList<String>();
        String[] temporaryStringArray = null;
        temporaryStringArray = listOfWords.split(" ");

        for (int i = 0; i < temporaryStringArray.length; i++) {
            returnSet.add(temporaryStringArray[i]);
        }
//        System.out.println(temporaryStringArray[4]);
        return returnSet.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Method to build an array of every word in the provided String
     *
     * @param listOfWords String of the text to be converted to an array
     * @return List of every word in the provided text as an entry.
     */
    public static List<String> allWordsFromSource(String listOfWords) {
        List<String> returnSet = new ArrayList<String>();
        String[] temporaryStringArray = null;
        temporaryStringArray = listOfWords.split(" ");

        for (int i = 0; i < temporaryStringArray.length; i++) {
            returnSet.add(temporaryStringArray[i]);
        }
        return returnSet;
    }

//    public abstract int compareTo(WordFrequency o);

    public static void main(String[] args) throws IOException {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        engine = wvHtmlPreivew.getEngine();
    }
}