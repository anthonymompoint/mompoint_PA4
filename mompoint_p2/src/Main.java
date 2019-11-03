import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "problem2.txt";
        DuplicateCounter counter = new DuplicateCounter();
        counter.count(filename);
        counter.write("unique_words_counts.txt");
    }
}
