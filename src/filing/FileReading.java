package filing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import resources.TokenizeFunctions;

public class FileReading {
	public static ArrayList<ArrayList<String>> readSpecificData(String word,String fileName) {
		File file = new File(fileName);
		ArrayList<ArrayList<String>> allInfo = new ArrayList<ArrayList<String>>();
		BufferedReader br;
		try {
			String line="";
			br = new BufferedReader(new FileReader(file));
			 while((line=br.readLine()) !=null) {
				 allInfo.add(TokenizeFunctions.tokenizeSpecificInformation(line, word));
				 if(allInfo.get(allInfo.size()-1) == null) {
					 allInfo.remove(allInfo.size()-1);
				 }
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allInfo;
	}
	
	public static ArrayList<ArrayList<String>> readAllData(String fileName){
		File file = new File(fileName);
		ArrayList<ArrayList<String>> allInfo = new ArrayList<ArrayList<String>>();
		
		 BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			 String line ="";
		        while((line=br.readLine()) !=null) {
		        	allInfo.add(TokenizeFunctions.tokenizeData(line));
		        }
		        br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allInfo;
	}
}
