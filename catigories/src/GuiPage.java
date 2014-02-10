import java.awt.*; 

import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
/*
 * Classname:BasicBST
 * 
 * Version information: 1
 *
 * Date: 2/9/2014
 * 
 * Copyright notice: none
 */
public class GuiPage extends JPanel implements ActionListener { 

JTextField textField;
JLabel categories,scores;
JButton button;
String text;
JsoupParser parser = new JsoupParser();
int zombieScore; 
int spaceScore; 
int scienceScore; 

//set up the panel
public GuiPage(){ 
	button = new JButton("start");
  setLayout(new BorderLayout());
  scores = new JLabel("SCORES    ");
  categories = new JLabel("Space: "+"  "+
                          "Science: "+"  "+
                          "Zombies: ");

 // button.setVerticalAlignment(JButton.SOUTH_EAST);
  scores.setVerticalAlignment(JLabel.NORTH);
  categories.setVerticalAlignment(JLabel.NORTH);

  textField = new JTextField("type your webpage here",20);
  textField.addActionListener(this);   

  add(textField,BorderLayout.NORTH);  
  add(scores,BorderLayout.WEST);
  add(categories,BorderLayout.CENTER);
  add(button,BorderLayout.SOUTH);
  
  button.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent evt) {
      text = textField.getText();
      try {
    	  //get the users words and set them
    	//  scoreCategories(parser.JsoupParsing(text),parser.getScience());
    	//scoreCategories(parser.JsoupParsing(text),parser.getSpace());
    	  scoreCategories(parser.JsoupParsing(text),parser.getZombies());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      System.out.println("zombieScore: "+zombieScore);
      
  }
  });  
}//end constructor

public String getTextFieldValue(){
	return text;
}



//set up the frame and display frame
private static void createAndShowGUI() { 
JFrame frame = new JFrame("categories"); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400,200);

//add panel to frame 
  frame.add(new GuiPage());

//frame.pack();
frame.setVisible(true);
}//end creatAndShow

//run the program
    public void runGui() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
             } //end run
          });//end new runnable
      }//end runGui

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void scoreCategories(String[] DLwords,ArrayList<WebPage<String>> categorie){
	int catScore = 0;
		for(WebPage<String> p: categorie){
			p.pageWords.setBoolean(true);
			for(String s:DLwords){
				p.pageWords.find(s);
				catScore += p.pageWords.getScore();
				System.out.println(catScore);
			}//end DLwords for
		}//end categories for
	 // return catScore;
	}// end method
	
	
	
} // end class
