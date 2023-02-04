public class WordFrequency extends Main implements Comparable <WordFrequency> {
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
        // usually toString should not be used,
        // instead one of the attributes or more in a comparator chain
        return o.getCount()-this.getCount();
    }

}
