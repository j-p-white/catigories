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
public class GuiPage { 

static JTextField textField;
static JLabel categories,scores;
static JLabel zombieL;
static JLabel spaceL;
static JLabel scienceL;
static JButton button;
static JPanel results = new JPanel();
String text;
JsoupParser parser = new JsoupParser();
static Integer zombieScore; 
static Integer spaceScore; 
static Integer scienceScore; 

public static void createPane(Container frame){
	int xVal = 2; // controls 1st half of labels
	int xVal2 = 0;//
	results.setSize(400,200);
	results.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	results.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL; 
	
	button = new JButton("start"); 
	c.weightx = 0.5; // half the column
	c.gridx = 4; // left
	c.gridy = 4;//bottom row 
	results.add(button,c);
	
	textField = new JTextField("type your webpage here");
	c.gridx = xVal; //left
	c.gridy = 0; // top
	c.ipadx = 3; // make it wide
	c.gridwidth = 3; // 3 columns long 
	results.add(textField,c);
	
	zombieL = new JLabel("zombieScore: ");
	c.gridx = xVal;//left 
	c.gridy = 1;
	c.weightx = 0.5; 
	results.add(zombieL,c);
	
	spaceL = new JLabel("spaceScore: ");
	c.gridx = xVal;//left 
	c.gridy = 2;
	c.weightx = 0.5; 
	results.add(spaceL,c);
	
	scienceL = new JLabel("scienceScore: ");
	c.gridx = xVal;//left 
	c.gridy = 3;
	c.weightx = 0.5; 
	results.add(scienceL,c);
	
	categories = new JLabel("winning Category: ");
	c.gridx = xVal2; // right 
	c.gridy = 1;// top
	c.weightx = 0.5; 
	results.add(categories,c);
	
	scores = new JLabel("winning URL: "); 
	c.gridx = xVal2; 
	c.gridy = 3; 
	c.weightx = 0.5; 
	results.add(scores,c);
	
}

////set up the panel
//public GuiPage(){ 
//	setLayout(new GridBagLayout());
//	GridBagConstraints c = new GridBagConstraints();
//	
//	button = new JButton("start");
//	c.weightx(0.5);
//	c.fill =GridBagConstraints.HORIZONTAL;
//	c.gridx(0);
//	c.gridy(2);
//	add(button,c);
//	
//	textField = new JTextField("type your webpage here",25); 
//   
//  button.addActionListener(new ActionListener(){
//  public void actionPerformed(ActionEvent evt) {
//	  parser.readInFiles();
//      text = textField.getText();
//      try {
//    	  //get the users words and set them
//    	  zombieScore = scoreCategories(parser.JsoupParsing(text),parser.getZombies());
//    	  scienceScore = scoreCategories(parser.JsoupParsing(text),parser.getScience());
//    	  spaceScore = scoreCategories(parser.JsoupParsing(text),parser.getSpace());
//    	  
//    	 System.out.println("space: "+spaceScore+""+"zombie: "+zombieScore+" "+"science: "+scienceScore);
//    	  scores.setText("winning Url: "+"\n"+"jamie");
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//  }
//  });  
//}//end constructor

//set up the frame and display frame
private static void createAndShowGUI() { 
JFrame frame = new JFrame("categories"); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(405,205);
//add my stuff to frame 
frame.getContentPane().add(results);
createPane(frame);
// frame abilitys
frame.setResizable(false);
frame.pack();
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
