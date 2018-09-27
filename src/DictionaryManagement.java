import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    public static void insertFromCommandLine() {
        System.out.print("Số lượng từ: ");
        DictionaryCommandLine.N = DictionaryCommandLine.input.nextInt();
        for (int i = 0; i < DictionaryCommandLine.N; i++) {
            Word tmp = new Word();
            String eng = DictionaryCommandLine.input.next();
            tmp.world_target = eng;
            String vie = DictionaryCommandLine.input.nextLine();
            tmp.world_explain = vie;
            Dictionary.wordArray.add(tmp);
        }

    }

    //  File readFile = new File("dictionaries.txt");
    public static void insertFromFile() {
        Scanner scanner = null;
        String Filepath = "dictionaries.txt";
        try {
            scanner = new Scanner(new File(Filepath));
        }catch (FileNotFoundException e){
            scanner = new Scanner(System.in);
            System.out.print("File not found");
        }
        while (scanner.hasNext())
        {
            String eng = scanner.next();
            String vie = scanner.nextLine();
            Word tmp = new Word();
            tmp.world_target= eng;
            tmp.world_explain = vie;
            Dictionary.wordArray.add(tmp);
        }
    }
    public static void dictionaryLookup(){
        Word UserSearch = new Word();
        UserSearch.world_target = DictionaryCommandLine.input.next();
        String tmp = UserSearch.world_target;
        for (int i = 0 ; i < Dictionary.wordArray.size(); i++)
        {
            Word tmp1 = new Word();
            tmp1 = Dictionary.wordArray.get(i);
            if (tmp.equals(tmp1.world_target)){
                System.out.println(tmp1.world_explain);
            }
        }

    }

    public static void addDictionary()
    {
        Word userInput = new Word();
        userInput.world_target = DictionaryCommandLine.input.next();
        userInput.world_explain = DictionaryCommandLine.input.nextLine();
        Dictionary.wordArray.add(userInput);
    }
    public static void removeFromDictionary()
    {
        Word userInput = new Word();
        userInput.world_target = DictionaryCommandLine.input.next();
        //  userInput.world_explain = DictionaryCommandLine.input.nextLine();
        String tmp = userInput.world_target;
        for (int i = 0 ; i < Dictionary.wordArray.size(); i++)
        {
            if (Dictionary.wordArray.get(i).world_target.equals(tmp)){
                Dictionary.wordArray.remove(i);
            }
        }
    }
    public static void updateDictionary(){
        Word userInput = new Word();
        userInput.world_target = DictionaryCommandLine.input.next();
        userInput.world_explain= DictionaryCommandLine.input.next();
        String tmp1 = userInput.world_target;
        String tmp2 = userInput.world_explain;
        for (int i = 0 ; i < Dictionary.wordArray.size(); i++){
            if (Dictionary.wordArray.get(i).world_explain.equals(tmp2) || Dictionary.wordArray.get(i).world_target.equals(tmp1)){
                Dictionary.wordArray.remove(i);
                Dictionary.wordArray.add(userInput);
            }
        }

    }
    public static void dictionaryExportToFile() throws IOException {
        BufferedWriter outputWriteer = null;
        outputWriteer = new BufferedWriter(new FileWriter("dictionaryExport.txt"));
        try {
            for (int i = 0; i < Dictionary.wordArray.size(); i++) {
                Word tmp = Dictionary.wordArray.get(i);

                outputWriteer.write(tmp.world_target + "\t" + tmp.world_explain);
                outputWriteer.newLine();
            }
            outputWriteer.flush();
            outputWriteer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void Trim()
    {
        for (int i = 0 ; i < Dictionary.wordArray.size(); i++)
        {
            Dictionary.wordArray.get(i).world_target.trim();
            Dictionary.wordArray.get(i).world_explain.trim();
        }
    }


}
