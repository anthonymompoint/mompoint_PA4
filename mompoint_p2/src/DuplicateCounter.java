import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

    Map< String,Integer> wordCounter = new HashMap< String,Integer>();

    public void count(String datafile) throws IOException {

        FileInputStream fileByteStream = new FileInputStream(datafile);
        Scanner scnr = new Scanner(fileByteStream);
        String word;

        if(scnr.hasNext())
        {
            word = scnr.next();
            if(!wordCounter.containsKey(word))
                wordCounter.put(word, 1);
        }
        else
        {
            fileByteStream.close();
            scnr.close();
            return;
        }

        while(scnr.hasNext())
        {
            word = scnr.next();
            if(!wordCounter.containsKey(word))
                wordCounter.put(word, 1);
            else
            {
                Integer num = wordCounter.remove(word);
                wordCounter.put(word, num + 1);
            }
        }
        fileByteStream.close();
        scnr.close();
    }

    public void write(String outputFile) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        PrintWriter outWriter = new PrintWriter(outputStream);

        for(String word : wordCounter.keySet())
        {
            outWriter.println(word + " " + wordCounter.get(word));
        }
        outWriter.flush();
        outputStream.close();
        outWriter.close();
    }
}
