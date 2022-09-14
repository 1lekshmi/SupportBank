package training.supportbank;
import java.util.Scanner;
import com.opencsv.CSVReader;
import org.apache.commons.text.WordUtils;

public class Main {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.println("If you want to list all the accounts, enter \"List All \".");
        System.out.println("If you want account details on a certain account, enter \"List <name>\" and replace <name> with the name of the account holder. " );;
        String command = WordUtils.capitalizeFully(input.nextLine());


        if (command.equals("List All")){
            // print out name and the balance


        } else {
            //extracting the name entered
            String[] commands = command.split(" ");
            String inputtedName = commands[1];

            // need to insert a function that will print out all the transactions, with the date and narrative.
        }

    }
}
