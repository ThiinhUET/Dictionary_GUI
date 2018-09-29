import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DictionaryApplication extends JFrame implements ActionListener {



    private JFrame frame;
    private JButton seachButton;
    JTextField InsertWord;
    JPanel panel;
    JLabel showIm;
    TextArea WordMean;
    JButton undoButton;

    public void JFrameDemo(){
        createAndShow();

    }
    public  void createAndShow() {
        ///////////Initial Fram//////////////
        frame = new JFrame("TPDict");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);


        seachButton = new JButton("Search");
        seachButton.setBounds(470, 60, 100, 35);
        frame.add(seachButton);


        InsertWord = new JTextField();

        InsertWord.setBounds(50, 60, 400, 25);
        frame.add(InsertWord);


        panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        showIm = new JLabel();
        showIm.setIcon(new ImageIcon("logo_TPDict.png"));

        panel.add(showIm);
        showIm.setBounds(0, 0, 100, 60);


        WordMean = new TextArea();
        WordMean.setBounds(50, 100, 400, 300);
        frame.add(WordMean);

        undoButton = new JButton("Undo");
        undoButton.setBounds(470, 110, 100, 35);
        frame.add(undoButton);

        ////////////////////////////setAction//////////////////////
        seachButton.setActionCommand("search");
        seachButton.addActionListener(this);

    }

            @Override
            public void actionPerformed(ActionEvent e) {

                if ("search".equals(e.getActionCommand()))
                {
                    String SearchWord = this.InsertWord.getText();
                    DictionaryManagement.dictionaryLookup(SearchWord);
                }


        }
}
