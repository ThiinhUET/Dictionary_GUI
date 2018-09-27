import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandLine {
    public static void dictionaryBasic()
    {
        DictionaryManagement.insertFromFile();
        DictionaryCommand.showAllWords();

    }
    public static void dictionaryAdvanced() throws IOException {

        DictionaryManagement.insertFromFile();


    }
    public static void dictionarySearcher(){
        String userInput = input.next();
        for (int i = 0 ; i < Dictionary.wordArray.size(); i++)
        {
            String tmp = Dictionary.wordArray.get(i).world_target;
            if (tmp.contains(userInput)){
                System.out.print(tmp + " ");
            }
        }

    }
    public static void menu()
    {
        System.out.println("==================WELCOME TO TPDict================");
        System.out.println("Press 1 | Search ");
        System.out.println("Press 2 | Remove word from dictionary ");
        System.out.println("Press 3 | Update dictionary ");
        System.out.println("Press 4 | Add a word to dictionary ");
        System.out.println("Press 5 | Find all word contain string ");
        System.out.println("Press 0 | Close dictionary ");
        System.out.println("===================================================");
    }
    public static final Scanner input = new Scanner(System.in);
    static int N ;

    public static void main(String[] args) throws IOException {
        dictionaryAdvanced();
        boolean loop = true;
        while (loop)
        {
            menu();
            int option = input.nextInt();
            if (option == 0)
            {
                loop = false;
            }
            else if (option == 1)
            {
                DictionaryManagement.dictionaryLookup();

            }
            else if (option == 2)
            {
                DictionaryManagement.removeFromDictionary();

            }
            else if (option == 3)
            {
                DictionaryManagement.updateDictionary();
                DictionaryManagement.dictionaryExportToFile();
                System.out.println("Updated!");

            }
            else if (option == 4)
            {
                DictionaryManagement.addDictionary();
                DictionaryManagement.dictionaryExportToFile();
                System.out.println("Added!");

            }
            else if (option == 5){
                dictionarySearcher();
            }
        }


    }
}
