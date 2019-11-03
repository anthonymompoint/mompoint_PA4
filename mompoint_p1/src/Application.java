import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileInputStream;

public class Application
{
    public static void main(String[] args) throws IOException {
        String filename = "problem1.txt";

        DuplicateRemover remover = new DuplicateRemover();
        remover.write(filename);
        remover.remove("unique_words.txt");
    }
}
