import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DictionaryApplication extends JFrame implements ActionListener {


    JTextField InsertWord;
    JPanel panel;
    JLabel showIm;
    TextArea WordMean;
    JButton read;
    JFrame frame;
    JButton seachButton;
    TextArea SuggestArea;
    JButton Addnew;
    JButton DelWord;
    JButton UpdateWord;
    JButton exit;


    public static ArrayList dictionarySearcher(String a) {
        ArrayList<Word> suggestArea = new ArrayList<Word> ();
        for (int i = 0; i < Dictionary.wordArray.size (); i++) {
            String tmp = Dictionary.wordArray.get (i).world_target;
            if (tmp.startsWith (a)) {
                suggestArea.add (Dictionary.wordArray.get (i));
            }
        }
        return suggestArea;

    }

    public void JFrameDemo() {
        createAndShow ();

    }

    public void createAndShow() {
        ///////////Initial Fram//////////////
        frame = new JFrame ("TPDict");
        frame.setSize (800, 500);
        frame.setLocationRelativeTo (null);
        frame.setBackground (Color.BLUE);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setResizable (false);
        frame.getContentPane ().setBackground(new java.awt.Color(107, 225, 222));




        seachButton = new JButton ("Search");
        seachButton.setBounds (500, 400, 100, 35);
        frame.add (seachButton);


        InsertWord = new JTextField ();
        InsertWord.setBounds (20, 60, 200, 25);
        frame.add (InsertWord);


        panel = (JPanel) frame.getContentPane ();
        panel.setLayout (null);

        showIm = new JLabel ();
        showIm.setIcon (new ImageIcon ("logo_TPDict.png"));

        panel.add (showIm);
        showIm.setBounds (0, 0, 100, 60);


        WordMean = new TextArea ();
        WordMean.setBounds (250, 60, 400, 300);
        WordMean.setFont (new Font ("Serif", Font.ITALIC, 20));
        WordMean.setFocusable (false);

        frame.add (WordMean);

        read = new JButton ("Read");
        read.setBounds (336, 400, 100, 35);
        frame.add (read);

        SuggestArea = new TextArea ();
        SuggestArea.setBounds (20, 100, 200, 250);
        SuggestArea.setFocusable (false);
        frame.add (SuggestArea);

        Addnew = new JButton ("Add");
        Addnew.setBounds (680,100,80,25);
        frame.add (Addnew);

        DelWord = new JButton ("Delete");
        DelWord.setBounds (680,150,80,25);
        frame.add (DelWord);

        UpdateWord = new JButton ("Update");
        UpdateWord.setBounds (680,200,80,25);
        frame.add (UpdateWord);

        exit = new JButton ("Exit");
        exit.setBounds (680,250,80,25);
        frame.add (exit);

        ///////////////change code above this//////////////////////
        frame.setVisible (true);

        ////////////////////////////setAction//////////////////////
        seachButton.setActionCommand ("search");
        seachButton.addActionListener (this);

        read.setActionCommand ("read");
        read.addActionListener (this);

        Addnew.setActionCommand ("add");
        Addnew.addActionListener (this);

        DelWord.setActionCommand ("delete");
        DelWord.addActionListener (this);

        UpdateWord.setActionCommand ("update");
        UpdateWord.addActionListener (this);

        exit.setActionCommand ("exit");
        exit.addActionListener (this);


        //////////////////////////////////////////////////////////
        Timer task = new Timer ();
        TimerTask SG = new TimerTask () {
            @Override
            public void run() {
                SuggestArea.setText (null);
                ArrayList<Word> tmp;
                String getT = InsertWord.getText ();
                tmp = dictionarySearcher (getT);
                for (int i = 0; i < tmp.size (); i++) {
                    String tmp2 = tmp.get (i).world_target;
                    SuggestArea.append (tmp2 + "\n");
                }
                //  SuggestArea.setText (null);
            }
        };
        task.schedule (SG, 1, 5000);


        //////////////////////////////////////////////////////////////


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("search".equals (e.getActionCommand ())) {
            String SearchWord = this.InsertWord.getText ();
            String output = DictionaryManagement.dictionaryLookup (SearchWord);
//            String[] part = output.split ("/");
//            String p1 = part[0];
//            String p2 = part[1];
//            String p3 = part[2];
//            this.WordMean.setText (p1 + "\n" + p2 + "\n" + p3);
            this.WordMean.setText (output);

        }
        if ("read".equals (e.getActionCommand ())) {
            String speak = InsertWord.getText ();
            BufferedWriter outputWriter = null;
            try {
                outputWriter = new BufferedWriter (new FileWriter ("Sound.vbs"));
                outputWriter.write ("CreateObject(\"SAPI.SpVoice\").Speak\"" + speak + "\"");
                outputWriter.flush ();
                outputWriter.close ();
            } catch (IOException e1) {
                e1.printStackTrace ();
            }
            try {
                Runtime.getRuntime ().exec (new String[]{"wscript.exe", "Sound.vbs"});
            } catch (IOException e1) {
                e1.printStackTrace ();
            }
        }
        if ("exit".equals (e.getActionCommand ()))
        {
            System.exit (0);
        }

        if ("add".equals (e.getActionCommand ())) {
              String addW =   JOptionPane.showInputDialog (rootPane,"Nhập từ muốn thêm");
              String addM = JOptionPane.showInputDialog (rootPane,"Nhập Nghĩa");
              JOptionPane.showMessageDialog (rootPane,"Đã được thêm");
           //   DictionaryManagement.updateDictionary (addW,addM);
            try {
                FileWriter fstream = new FileWriter("dictionaries.txt",true);
                BufferedWriter fbw = new BufferedWriter(fstream);
                fbw.write(addW+" "+addM);
                fbw.newLine();
                fbw.close();
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
            DictionaryManagement.insertFromFile ();
        }

        if ("delete".equals (e.getActionCommand ()))
        {
            String del = JOptionPane.showInputDialog (rootPane,"Nhập từ muốn xóa");
            ArrayList<Word> DeleteArray = new ArrayList<> ();
            Scanner scanner = null;
            String Filepath = "dictionaries.txt";
            try {
                scanner = new Scanner(new File (Filepath));
            }catch (FileNotFoundException e1){
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
                DeleteArray.add(tmp);
            }
            int index = 0;
            for (int i = 0 ; i< DeleteArray.size ();i++)
            {
                if (del.equals (DeleteArray.get (i).world_target))
                {
                    index = i;
                }
            }
            DeleteArray.remove (index);
            try{
                BufferedWriter outputWriteer = null;
                outputWriteer = new BufferedWriter(new FileWriter("dictionaries.txt"));
                    for (int i = 0; i < DeleteArray.size(); i++) {
                        Word tmp = DeleteArray.get(i);

                        outputWriteer.write(tmp.world_target + " " + tmp.world_explain);
                        outputWriteer.newLine();
                    }
                    outputWriteer.flush();
                    outputWriteer.close();
                }
                catch (IOException e1) {
                    e1.printStackTrace ();
                }
            JOptionPane.showMessageDialog (rootPane,"Đã xóa khỏi từ điển");
            DictionaryManagement.insertFromFile ();

        }

        if ("update".equals (e.getActionCommand ()))
        {
            JOptionPane.showInputDialog (rootPane,"Nhập từ muốn sửa");
        }


    }

}


