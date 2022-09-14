package training.supportbank;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class DataReader {
    public static void main(String args[]) throws IOException, CsvValidationException {
//        created a string variable for path
        String path = "/Users/lsudhiku/Work/SupportBankCsvFile/Transactions2014.csv";
        String[] line;

        CSVReader csv = new CSVReader(new FileReader(path));

        while ((line = csv.readNext()) != null){

//            Assign a variable to each column
            String Date = line[0];
            String From = line[1];
            String To = line[2];
            String Narrative = line[3];
            String Amount = line[4];

//            changing the type for amount from string to double
            try {
                double amount = Double.parseDouble(Amount);
//
            }catch (NumberFormatException e){
                e.printStackTrace();
            }




        }
    }
}