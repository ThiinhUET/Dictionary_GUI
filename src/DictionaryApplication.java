import javax.swing.*;
import java.awt.*;

public class DictionaryApplication extends JFrame {

    private JFrame frame;
    private JButton seachButton;
    public void JFrameDemo(){
        createAndShow();

    }
    public void createAndShow(){

        frame = new JFrame("TPDict");
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);


        JButton seachButton = new JButton("Search");
        seachButton.setBounds(470,60,100,35);
        frame.add(seachButton);


        TextField InsertWord = new TextField();

        InsertWord.setBounds(50,60,400,35);
        frame.add(InsertWord);



        JPanel panel = (JPanel)frame.getContentPane();
        panel.setLayout(null);

       JLabel showIm = new JLabel();
       showIm.setIcon(new ImageIcon("logo_TPDict.png"));

       panel.add(showIm);
       showIm.setBounds(0,0,100,60);


        TextArea WordMean = new TextArea();
        WordMean.setBounds(50,100,400,300);
        frame.add(WordMean);



    }

}
