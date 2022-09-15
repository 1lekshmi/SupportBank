package training.supportbank;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Accounts {
    String name;

    Double balance;

    Double moneyAdded = 0.00;

    Double moneyRemoved = 0.00;

//    static void main(String[] args)

//  constructor
    public Accounts(String name) throws IOException, CsvException {
        this.name = name;

//        created a string variable for path
        String path = "/Users/lsudhiku/Work/SupportBankCsvFile/Transactions2014.csv";
        CSVReader csv = new CSVReader(new FileReader(path));
        csv.skip(1);

        List<String[]> dataEntries = csv.readAll();
        List<String> accountHolderName = new ArrayList<String>();

        for(int i = 0; i <= dataEntries.size()-1; i++){
//            assigning each entry to a variable "lines"
            String lines = Arrays.toString(dataEntries.get(i));

//            separating the columns and storing them in a list
            String[] data = lines.split(",");

//            assigning a variable to each element in the 'data' list
            String date = data[0].replace("[","");
            String from = data[1];
            String to = data[2];
            String narrative = data[3];
            String amount = data[4].replace("]", "");

//            changing the type for the 'amount' variable
            Double amountdp = Double.parseDouble(amount);



            accountHolderName.add(from);

            if(from.equals(name)){

                double moneyAdded = this.moneyAdded + amountdp;

            } else if (to.equals(name)) {
                double moneyRemoved = this.moneyRemoved - amountdp;
            }

            this.balance = moneyAdded + moneyRemoved;
        }

//        a new list for the distinct names
        List<String > distinctNames = accountHolderName.stream()
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(distinctNames);

    }

// methods

    public Double getBalance(){
        return balance;
    }

}

