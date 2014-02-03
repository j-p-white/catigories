import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class guiPage extends JPanel implements ActionListener { 

protected JTextField textField;
JLabel categories,scores;  

//set up the panel
public guiPage(){ 
  setLayout(new BorderLayout());
  scores = new JLabel("SCORES    ");
  categories = new JLabel("world Travel: "+"  "+
                          "computer parts: "+"  "+
                          " economy: ");

  scores.setVerticalAlignment(JLabel.NORTH);
  categories.setVerticalAlignment(JLabel.NORTH);

  textField = new JTextField("type your webpage here",20);
  textField.addActionListener(this);   

  add(textField,BorderLayout.NORTH);  
  add(scores,BorderLayout.WEST);
  add(categories,BorderLayout.CENTER);
}//end constructor

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textField.selectAll();
    }

//set up the frame and display frame
private static void createAndShowGUI() { 
JFrame frame = new JFrame("categories"); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400,200);

//add panel to frame 
  frame.add(new guiPage());

//frame.pack();
frame.setVisible(true);
}//end creatAndShow

//run the program
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
             } //end run
          });//end new runnable
      }//end main
} // end class
