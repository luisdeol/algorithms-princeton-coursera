package com.luisdeol;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by luisdeol on 25/03/17.
 */
public final class CsvReaderAndWriter {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "timestamp,friendOne,friendTwo";


    private CsvReaderAndWriter(){

    }

    public static void WriteCsvFile(String fileName, int friendOne, int friendTwo){
        FileWriter fileWriter = null;
        try{
            Date date = new Date();
            fileWriter = new FileWriter(fileName, true);
            fileWriter.append(date.toString());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Integer.toString(friendOne));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(Integer.toString(friendTwo));
            fileWriter.append(NEW_LINE_SEPARATOR);
        }
        catch (Exception e){
            System.out.println("Error in WriteCsvFile !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
