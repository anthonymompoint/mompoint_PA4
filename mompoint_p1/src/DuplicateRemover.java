import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateRemover
{
    ArrayList<String> uniqueWords = new ArrayList<String>();

    public void write(String inputFileName) throws IOException {
        FileInputStream fileByteStream = new FileInputStream(inputFileName);
        Scanner scnr = new Scanner(fileByteStream);
        String word;
        if(scnr.hasNext())
        {
            word = scnr.next();
            if(!uniqueWords.contains(word))
                uniqueWords.add(word);
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
            if(!uniqueWords.contains(word))
                uniqueWords.add(word);
        }
        fileByteStream.close();
        scnr.close();
    }

    public void remove(String outputFileName) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(outputFileName);
        PrintWriter outWriter = new PrintWriter(outputStream);

        for(int i = 0; i < uniqueWords.size(); i++)
        {
            outWriter.print(uniqueWords.get(i) + " ");
        }
        outWriter.flush();
        outputStream.close();
        outWriter.close();
    }

}
