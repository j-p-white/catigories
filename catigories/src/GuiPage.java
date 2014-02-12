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
static String text;
static JsoupParser parser = new JsoupParser();
static Integer zombieScore; 
static Integer spaceScore; 
static Integer scienceScore; 

public static void createPane(Container frame){
	int xVal = 2; // controls 1st half of labels
	int xVal2 = 0;//
	int myIpadx = 80;
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
	
	button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt) {
		  parser.readInFiles();
		  text = textField.getText();
		  try {
			  //get the users words and set them
			  zombieScore = scoreCategories(parser.JsoupParsing(text),parser.getZombies());
			  scienceScore = scoreCategories(parser.JsoupParsing(text),parser.getScience());
			  spaceScore = scoreCategories(parser.JsoupParsing(text),parser.getSpace());
			  
			  zombieL.setText("zombieScore: "+ zombieScore.toString());
			  spaceL.setText("spaceScore : "+ spaceScore.toString());
			  scienceL.setText("sceinceScore is: "+ scienceScore.toString());
			  categories.setText("winning Category: "+winnningCat(spaceScore,scienceScore,zombieScore));
		
			  		  
			  
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		});
	
	textField = new JTextField("type your webpage here");
	
	c.gridx = xVal; //left
	c.gridy = 0; // top
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridwidth = 3; // 3 columns long 
	results.add(textField,c);
	
	zombieL = new JLabel("zombieScore: ");
	c.gridx = xVal;//left 
	c.gridy = 1;
	c.weightx = 0.5; 
	c.ipadx = myIpadx;
	results.add(zombieL,c);
	
	spaceL = new JLabel("spaceScore: ");
	c.gridx = xVal;//left 
	c.gridy = 2;
	c.weightx = 0.5; 
	c.ipadx = myIpadx;
	results.add(spaceL,c);
	
	scienceL = new JLabel("scienceScore: ");
	c.gridx = xVal;//left 
	c.gridy = 3;
	c.weightx = 0.5;
	c.ipadx = myIpadx;
	results.add(scienceL,c);
	
	categories = new JLabel("winning Category: ");
	c.gridx = xVal2; // right 
	c.gridy = 6;// top
	c.weightx = 0.5;
	c.ipadx = myIpadx;
	results.add(categories,c);
	
	scores = new JLabel("winning URL: "); 
	c.gridx = xVal2; 
	c.gridy = 5; //almost bottom
	c.weightx = 0.5;
	c.ipadx = myIpadx;
	results.add(scores,c);
	
}// end setup 

//set up the frame and display frame
private static void createAndShowGUI() { 
JFrame frame = new JFrame("categories"); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(405,205);
//add my stuff to frame 
frame.getContentPane().add(results);
createPane(frame);
// frame abilitys
frame.setResizable(true);
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
				p.setPageScore(p.pageWords.getScore());
				catScore += p.pageWords.getScore();
			}//end DLwords for
		}//end categories for
	 return catScore;
	}// end method
	
	//scores.setText("winning Url: "+ );
	
	public static String winnningCat(Integer spaceScore,Integer scienceScore, Integer zombieScore){
		Integer winning = spaceScore;
		String goodString = "space";
		scores.setText("winning Url: "+winningUrlCat(parser.getSpace()));
		if(winning < zombieScore){
			winning = zombieScore;
			goodString = "zombie";
			scores.setText("winning Url: "+winningUrlCat(parser.getZombies()));
		}
		if(winning < scienceScore){
			winning = scienceScore;
			goodString = "science";
			scores.setText("winning Url: "+winningUrlCat(parser.getScience()));
		}
		return goodString;
		
	}//end winningCat
	
	public static String winningUrlCat(ArrayList<WebPage<String>> winningAry){
		int winningPageScore =0; 
		String pageUrl = "no score";
			for(WebPage<String> p: winningAry){
			  if(winningPageScore < p.pageScore){
				 winningPageScore = p.pageScore;
				 pageUrl = p.websiteName;
			  }//end if
			}//end  for
		return pageUrl;
	}
	
} // end class
