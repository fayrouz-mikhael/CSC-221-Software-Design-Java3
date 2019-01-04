package application;

import java.io.BufferedReader;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HistogramLetters {

	// this method for reading the characters from the text file
	
	public static  Map<Character,  Double> readfile() {
		 Map<Character,  Double>  probMap = null; 
		 try {
	            FileInputStream fstream = new FileInputStream("/Users/fayrouzmikhael/Desktop/Emma.txt");
	            DataInputStream in = new DataInputStream(fstream);
	            BufferedReader br = new BufferedReader(new InputStreamReader(in));
	            Pattern patt = Pattern.compile("[A-Za-z]"); // use pattern to get the specific characters which is only letters
	            String strLine;
	            double charcount =0.0;
	            HashMap<Character,  Double> map = new HashMap<Character,  Double>(); // using HashMap to insert the character and the number of its occurrence
	           String result = "";
	            while((strLine = br.readLine())!= null) {
	            	Matcher m = patt.matcher(strLine);
	            	
	            	while(m.find()) {
	            		int start = m.start(0); // is to read from the beginning of the text file to the end
	            		int end = m.end(0);
	            		
	            	
	            		charcount = charcount + strLine.substring(start, end).length(); // is to get the characters from the words
	            		
	            		 result = strLine.substring(start, end);
	            		
	            		 String s = result;
	 	            	for (int i = 0; i < s.length(); i++) { // for loop to go over the words and insert its letter and the number occurrence 
	 	            	    char c = s.charAt(i);
	 	            	   Double val = map.get(c);
	 	            	    if (val != null) {
	 	            	        map.put(c, new  Double(val + 1)); // to insert the characters in the event and its occurrence
	 	            	    }
	 	            	    else {
	 	            	       map.put(c, (double) 1);
	 	            	   }
	 	            	}
	            		
	            	}
	            
	            }
	            probMap = probablities(map,charcount); // assign probMap to the function of probablities 
	            
		 }
		 catch (Exception e) {
	            System.err.println("Error: " + e.getMessage());
	        }
		 
		 
		return probMap; // return probMao to the function of probablities 
	              
	}
	
	// this method to insert the each character and its probability in a map
	
	public static Map<Character, Double> probablities(Map<Character, Double> Map , double charcount){
		 
		  Map<Character, Double> probMap = new LinkedHashMap<Character, Double>();
		  
		  for(Map.Entry<Character ,Double>entry:Map.entrySet()) {
		probMap.put(entry.getKey(), entry.getValue()/charcount); // probability of event = frequency of event / total number of frequencies
		  }
		return sortByValue(probMap, charcount); // return the map and char count to function SortByValue
		  
	 }
	 
	
	// this method is for sorting the probabilities in decreasing order
	// this takes the map and the count of the characters
	
	 public static Map<Character, Double>  sortByValue(Map<Character, Double> unsortMap,double charcount) {

	        // 1. Convert Map to List of Map
	        List<Map.Entry<Character,  Double>> list =
	                new LinkedList<Map.Entry<Character, Double>>(unsortMap.entrySet());

	        // 2. Sort list with Collections.sort(), provide a custom Comparator
	        //    Try switch the o2 o1 position for a different order
	        Collections.sort(list, new Comparator<Map.Entry<Character,  Double>>() {
	            public int compare(Map.Entry<Character,  Double> o1,
	                               Map.Entry<Character,  Double> o2) {
	                return (o2.getValue()).compareTo(o1.getValue());
	            }
	        });

	        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
	        Map<Character,  Double> sortedMap = new LinkedHashMap<Character,  Double>();
	        for (Map.Entry<Character,  Double> entry : list) {
	            sortedMap.put(entry.getKey(), entry.getValue());
	            
	        }
	      return putFirstEntries(PieChart.number,sortedMap,charcount); // to return the number of events and sorted map and the total number of  
	      															  // characters to putFirstEntries function
	    }
	 
	 //this method is for putting the sorting events and probabilities in another Map
	 public static Map<Character, Double> putFirstEntries(int max, Map<Character, Double> source , double charcount) {
		 
		  int count = 0;
		  TreeMap<Character, Double>  target = new TreeMap<Character, Double> ();
		  for (Map.Entry<Character, Double> entry:source.entrySet()) {
		     if (count >= max) break;

		     target.put(entry.getKey(), entry.getValue());
		     count++;
		  }
		  List<Map.Entry<Character,  Double>> list =
	                new LinkedList<Map.Entry<Character, Double>>(target.entrySet());

	        // 2. Sort list with Collections.sort(), provide a custom Comparator
	        //    Try switch the o1 o2 position for a different order
	        Collections.sort(list, new Comparator<Map.Entry<Character,  Double>>() {
	            public int compare(Map.Entry<Character,  Double> o1,
	                               Map.Entry<Character,  Double> o2) {
	                return (o2.getValue()).compareTo(o1.getValue());
	            }
	        });

	        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
	        Map<Character,  Double> sortedMap = new LinkedHashMap<Character,  Double>();
	        for (Map.Entry<Character,  Double> entry : list) {
	            sortedMap.put(entry.getKey(), entry.getValue());
	            
	        }
		  return sortedMap;
		}
	 
	 
	 
	
}
	
