import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandLine {
    public static void dictionaryBasic()
    {
        DictionaryManagement.insertFromFile();
        DictionaryCommand.showAllWords();

    }
    public static void dictionaryAdvanced() {

        DictionaryManagement.insertFromFile();


    }

    public static void keyReleased(KeyEvent ke)
    {
        String str= KeyEvent.getKeyText (ke.getKeyCode());
        System.out.println(str); /*hiển thị các kí tự bạn gõ để biết giá trị */

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

    public static void main(String[] args) {
        dictionaryAdvanced();
        new DictionaryApplication().JFrameDemo();


    }
}
