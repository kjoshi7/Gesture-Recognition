package com.asu.mwdb.phase3.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.asu.mwdb.phase3.task3.decisiontree.io.DecisionTreeToDot;
import com.asu.mwdb.phase3.task3.decisiontree.io.ItemSetReader;
import com.asu.mwdb.phase3.task3.decisiontree.misc.Attribute;
import com.asu.mwdb.phase3.task3.decisiontree.misc.AttributeSet;
import com.asu.mwdb.phase3.task3.decisiontree.misc.DecisionTree;
import com.asu.mwdb.phase3.task3.decisiontree.misc.DecisionTreeBuilder;
import com.asu.mwdb.phase3.task3.decisiontree.misc.FileFormatException;
import com.asu.mwdb.phase3.task3.decisiontree.misc.Item;
import com.asu.mwdb.phase3.task3.decisiontree.misc.ItemSet;
import com.asu.mwdb.phase3.task3.decisiontree.misc.KnownSymbolicValue;
import com.asu.mwdb.phase3.task3.decisiontree.misc.SymbolicAttribute;

public class DecisionTreeDriver {

	static private ItemSet learningSet;
    static private ItemSet testSet;
    final static String dbFileName = "c://temp//traindb.db";
	final static String dbFileNameTest = "c://temp//testdb.db";
	
	
	public static void main(String args[]) throws FileFormatException, IOException {
		try {
		    learningSet = ItemSetReader.read(new FileReader(dbFileName));
		    testSet = ItemSetReader.read(new FileReader(dbFileNameTest));
		}
		catch(FileNotFoundException e) {
		    System.err.println("File not found : " + dbFileName + ".");
		    System.err.println("This file is included in the source " +
				       "distribution of jaDti.  You can find it at " 
				       );
		    System.exit(-1);
		}
		
		AttributeSet attributes = learningSet.attributeSet();

		
		Vector testAttributesVector = new Vector();
		List<Attribute> attributeList = attributes.addByName("attr");
		for(Attribute att : attributeList){
			testAttributesVector.add(att);
		}
		
		AttributeSet testAttributes = new AttributeSet(testAttributesVector);
		SymbolicAttribute goalAttribute =
		    (SymbolicAttribute) learningSet.attributeSet().findByName("label");

		DecisionTree tree = buildTree(learningSet, testAttributes,
					      goalAttribute);
		System.out.println("something");
		printDot(tree);
		System.out.println("something");
		for(double i = 0; i < testSet.size(); i++){
			printGuess(testSet.item((int)i), tree);
		}
	}
	
	  /*
     * Build the decision tree.
     */
    static private DecisionTree buildTree(ItemSet learningSet, 
					  AttributeSet testAttributes, 
					  SymbolicAttribute goalAttribute) {
	DecisionTreeBuilder builder = 
	    new DecisionTreeBuilder(learningSet, testAttributes,
				    goalAttribute);
	
	return builder.build().decisionTree();
    }
    

    /*
     * Prints a dot file content depicting a tree.
     */
    static private void printDot(DecisionTree tree) {
	System.out.println((new DecisionTreeToDot(tree)).produce());
    }
    

    /*
     * Prints an item's guessed goal attribute value.
     */
    static private void printGuess(Item item, DecisionTree tree) {
	AttributeSet itemAttributes = tree.getAttributeSet();
	SymbolicAttribute goalAttribute = tree.getGoalAttribute();
	
	KnownSymbolicValue guessedGoalAttributeValue = 
	    tree.guessGoalAttribute(item);

	String s = "The value guessed by the tree is " + 
	    tree.getGoalAttribute().valueToString(guessedGoalAttributeValue);
	
	System.out.println(s);
    }
	
}
