package training.supportbank;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.text.WordUtils;

public class Main {
    public static void main(String args[]) throws IOException, CsvException {

        Scanner input = new Scanner(System.in);
        System.out.println("If you want to list all the accounts, enter \"List All \".");
        System.out.println("If you want account details on a certain account, enter \"List <name>\" and replace <name> with the name of the account holder. " );;
        String command = WordUtils.capitalizeFully(input.nextLine());


        if (command.equals("List All")){

            Accounts JonA = new Accounts("Jon A");
            Double bal = JonA.getBalance();
            System.out.println("Jon A: " + bal);


        } else {
            //extracting the name entered
            String[] commands = command.split(" ");
            String inputtedName = commands[1];
//          the code above needs to be changed so that inputtedName is commands - first word(i.e; list)

            // need to insert a function that will print out all the transactions, with the date and narrative.
        }








    }
}
