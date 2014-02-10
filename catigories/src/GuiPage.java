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
JLabel categories,scores,zombieL,spaceL,scienceL;
JButton button;
String text;
JsoupParser parser = new JsoupParser();
static Integer zombieScore; 
static Integer spaceScore; 
static Integer scienceScore; 

//set up the panel
public GuiPage(){ 
	spaceL = new JLabel("0");
	zombieL = new JLabel("0");
	scienceL = new JLabel("0");
	button = new JButton("start");
  setLayout(new BorderLayout());
  scores = new JLabel("SCORES    ");
  categories = new JLabel("Space: "+" "+spaceL +
                          "Science: "+" "+scienceL +
                          "Zombies: "+zombieL);
  
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
	  parser.readInFiles();
      text = textField.getText();
      try {
    	  //get the users words and set them
    	  zombieScore = scoreCategories(parser.JsoupParsing(text),parser.getZombies());
    	  scienceScore = scoreCategories(parser.JsoupParsing(text),parser.getScience());
    	  spaceScore = scoreCategories(parser.JsoupParsing(text),parser.getSpace());
    	  
    	 System.out.println("space: "+spaceScore+""+"zombie: "+zombieScore+" "+"science: "+scienceScore);
    	  
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  });  
}//end constructor

//set up the frame and display frame
private static void createAndShowGUI() { 
JFrame frame = new JFrame("categories"); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400,200);

//add panel to frame 
frame.add(new GuiPage());
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
	public static int scoreCategories(String[] DLwords,ArrayList<WebPage<String>> categorie){
	int catScore = 0;
		for(WebPage<String> p: categorie){
			p.pageWords.setBoolean(true);
			for(String s:DLwords){
				p.pageWords.find(s);
				catScore += p.pageWords.getScore();
			}//end DLwords for
		}//end categories for
	 return catScore;
	}// end method
	
	
} // end class
