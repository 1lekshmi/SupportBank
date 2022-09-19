package training.supportbank;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.text.WordUtils;

import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
//    fields declared before the main function so that it will be available to use in this class
    static String date;
    static String from;
    static String to;
    static String narrative;
    static String amount;
    static Double amountDouble;


    public static void main(String[] args) throws IOException, CsvException {
        String path = "/Users/lsudhiku/Work/Training/SupportBank/SupportBankCsvFile/Transactions2014.csv";
        CSVReader csv = new CSVReader(new FileReader(path));
        csv.skip(1);


        List<String[]> entries = csv.readAll();
        List<String> accountNames = new ArrayList<String>();
        List<Transactions> listOfTransactions = new ArrayList<Transactions>();



        for(int i = 0; i <= entries.size() - 1; i++){
            String lines = Arrays.toString(entries.get(i));
            String[] data = lines.split(",");

            date = data[0].replace("[", " ");
            from = data[1];
            to = data[2];
            narrative = data[3];
            amount = data[4].replace("]", " ");
            amountDouble = Double.parseDouble(amount);

//            adds all the name to accountNames which is then used to create a new list with just the distinct names
            accountNames.add(from);


//            adds all the transactions to the 'listOfTransaction' list
            listOfTransactions.add(new Transactions(from,to,amountDouble,date,narrative));

        }


        List<String> distinctNames = accountNames.stream()
                .distinct()
                .collect(Collectors.toList());
//        System.out.println(distinctNames);




        Scanner input = new Scanner(System.in);
        System.out.println("If you want to list all the accounts, enter \"List All\".");
        System.out.println("If you want transaction details on a certain account, enter \"List <name>\" and replace <name> with the name of the account holder. " );
        String command = WordUtils.capitalizeFully(input.nextLine());

//
        if (command.equals("List All")){
            for (String accName:distinctNames) {
                Accounts newAcc = new Accounts(accName);
                Double bal = newAcc.getBalance();
                DecimalFormat df = new DecimalFormat("0.00");
                System.out.println(accName + ": " + df.format(bal));
            }


        } else {
            //extracting the name entered
            String inputtedName = command.substring(4);
            getAllTransactions(listOfTransactions, inputtedName);

    }
}

    private static void getAllTransactions(List<Transactions> listOfTransactions, String inputtedName) {
        listOfTransactions.stream().filter(transaction-> transaction.from.equals(inputtedName) || transaction.to.equals(inputtedName))
                .map(Transactions::allTransactions)
                .forEach(System.out::println);
    }
    }
