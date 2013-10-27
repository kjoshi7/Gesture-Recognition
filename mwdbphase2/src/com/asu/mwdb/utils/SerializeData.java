package com.asu.mwdb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import au.com.bytecode.opencsv.CSVWriter;

import com.asu.mwdb.gui.MainWindow;
import com.asu.mwdb.math.CosineSimilarity;
import com.asu.mwdb.math.Task3FindSimilarData.Entity;

public class SerializeData {
	
	private static double gestureGestureTFIDF[][] = null;
	private static double gestureGestureTFIDF2[][] = null;
	
	public static void serialize(String outputFileName,Object object) throws IOException{
		FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
		ObjectOutputStream objectOutputStream  = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(object);
	}
	
	
	
	private  static Object deserialize(String inputFileName) throws ClassNotFoundException, IOException{
		FileInputStream fileInputStream = new FileInputStream(inputFileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		return objectInputStream.readObject();
	
	
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, MatlabConnectionException, MatlabInvocationException {
		try {
		
			
			List<List<Map<String, List<Double>>>> dictionary = (List<List<Map<String, List<Double>>>>) deserialize("object/test.obj");
			
			
			MainWindow main = new MainWindow();
			
			Map<Integer, Set<String>> variable1 = main.createWordsPerSensor(dictionary);
            List<Map<String, Double[]>> computedScores = main.createSensorWordScores(variable1, dictionary);
            
            
            System.out.println("Scores of phase 2 : "+computedScores.size());
			
            //print all
            
            for (int i = 0; i < computedScores.size(); i++) {
				Iterator<Entry<String, Double[]>> iterator = computedScores.get(i).entrySet().iterator();
				
				System.out.println("***************************");
				System.out.println("\tSensor\t"+i);
            	while(iterator.hasNext()){
            		Entry<String, Double[]> entry = iterator.next();
            		System.out.println(entry.getKey()+"\t"+Arrays.toString(entry.getValue()));
            	}
            	System.out.println("***************************");
				
			}
            
            List<List<String>> order = main.savewordstoCSV(computedScores);
            for (int i = 0; i < order.size(); i++) {
            	System.out.println(order.get(i).toString());
			}
//            System.out.println(order.toString());
			
//			Map map = constructGesstureWords.getTfIDFMapGlobal();
			
//			serialize("data/test.obj", map);
            
             main.transformDataForLDA("data");
//            main.executePCA("data",order);
//            main.executeSVD("data", order);
            

           // constructGestureGestureMatix(dictionary);
            
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	private static void constructGestureGestureMatix(List<List<Map<String, List<Double>>>> dictionary) throws IOException {
		
		computeSimilarilty(dictionary,Entity.TFIDF);
		computeSimilarilty(dictionary,Entity.TFIDF2);
		writeGestureGestureToFile(Entity.TFIDF);
		writeGestureGestureToFile(Entity.TFIDF2);
		
	}
	
	/**
	 * Once the gesture-gesture matrix is created, write the matrix into file 
	 * for future reference
	 * @param entity
	 * @throws IOException
	 */
	private static void writeGestureGestureToFile(Entity entity) throws IOException {
		double[][] doubleValues= null;
		String fileName = "." + File.separator + "data" + File.separator;
		switch(entity) {
			case TFIDF:
						doubleValues = gestureGestureTFIDF;
						fileName = fileName + "ggTFIDF.csv";
						break;
			case TFIDF2:
						doubleValues = gestureGestureTFIDF2;
						fileName = fileName + "ggTFIDF2.csv";
						break;
			default:	
					    break;
		} 
		CSVWriter writer = new CSVWriter(new FileWriter(new File(fileName)), ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
		for (int rowCount = 0; rowCount < gestureGestureTFIDF.length; rowCount++) {
			String[] currentRowString = new String[doubleValues.length];
			double[] currentRowDouble = doubleValues[rowCount];
			for (int rowCount2 = 0; rowCount2 < currentRowString.length; rowCount2++) {
				currentRowString[rowCount2] = String.valueOf(currentRowDouble[rowCount2]);
			}
			writer.writeNext(currentRowString);
		}
		writer.close();
	}
	
	
	private static void computeSimilarilty(List<List<Map<String, List<Double>>>> dictionary, Entity entity) {
		double[][] doubleValues= null;
		doubleValues = new double[dictionary.size()][dictionary.size()];
		for (int currentFileIndex = 0; currentFileIndex < dictionary.size(); currentFileIndex++) {
			List<Map<String, List<Double>>> currentGesture = dictionary.get(currentFileIndex);
			for (int comparedFileIndex = 0; comparedFileIndex < dictionary.size(); comparedFileIndex++) {
				List<Map<String, List<Double>>> comparedGesture = dictionary.get(comparedFileIndex);
				double sum = 0.0d;
				try {
					for (int k = 0; k < comparedGesture.size(); k++) {
						Map<String, Double> inputMap = convertMap(
								comparedGesture.get(k), entity);
						Map<String, Double> dictMap = convertMap(
								currentGesture.get(k), entity);
						sum += CosineSimilarity.difference(inputMap, dictMap);
					}
					DecimalFormat df = new DecimalFormat("#.###");
					doubleValues[currentFileIndex][comparedFileIndex] = Double.parseDouble(df.format(sum))/20.0;
					doubleValues[comparedFileIndex][currentFileIndex] = Double.parseDouble(df.format(sum))/20.0;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		// this switch statement can be extended to include for additional parameters
		switch (entity) {
		case TFIDF:
					gestureGestureTFIDF = doubleValues;
					break;
		case TFIDF2:
					gestureGestureTFIDF2 = doubleValues;
					break;
		default:
					break;
		}
	}
	
	private static Map<String, Double> convertMap(Map<String, List<Double>> map,
			Entity entity) {
		// TODO Auto-generated method stub
			Map<String,Double> values = new HashMap<String, Double>(); 
			Iterator<Entry<String, List<Double>>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String, List<Double>> entry = iterator.next();
				values.put(entry.getKey(), entry.getValue().get(entity.ordinal()));
			}
			
		return values;
	}
	
}
