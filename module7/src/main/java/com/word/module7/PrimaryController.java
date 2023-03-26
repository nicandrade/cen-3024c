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

    @FXML
    protected void loadWords() {
        tblColWord.setCellValueFactory(new PropertyValueFactory<WordFrequency, String>("word"));
        tblColCount.setCellValueFactory(new PropertyValueFactory<WordFrequency, Integer>("count"));
        tblWords.setItems(list);
    }

    public static String getHtmlText(URL url) throws IOException {
        String returnText = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        return returnText;
    }

    public static String removeExtraContent(String startingText, String beforeText, String afterText) {
        String returnText = startingText.substring(startingText.lastIndexOf(beforeText) + 0, startingText.lastIndexOf(afterText));
        return returnText;
    }

    public static String removeHtmlTags(String startingText) {
        String returnText = startingText.replaceAll("\\<[^>]*>", "");
        return returnText;
    }

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