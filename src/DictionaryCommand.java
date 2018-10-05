public class DictionaryCommand {
    public static void showAllWords()
    {
        for (int i = 0 ; i < Dictionary.wordArray.size(); i++)
        {
            Word tmp = Dictionary.wordArray.get(i);
            System.out.println(tmp.world_target +"\t"+tmp.world_explain);
        }
    }

}
