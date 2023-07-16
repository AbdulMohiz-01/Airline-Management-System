package resources;

import java.util.ArrayList;

public  class TokenizeFunctions {

	public static ArrayList tokenizeData(String line) {
		String data="";
		ArrayList<String> info = new ArrayList<String>();
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i)!=',') {
				data+=line.charAt(i);
			}
			else {
				info.add(data);
				data="";
			}
			
		}
		return info;
	}
	public static ArrayList tokenizeSpecificInformation(String line,String word) {
		String data="";
		ArrayList<String> info = new ArrayList();
		boolean getTheInfo = false;
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i)!=',') {
				data+=line.charAt(i);
			}
			else {
				if(word.equals(data)) {
					getTheInfo = true;
				}
				 info.add(data);
				data="";
				
			}
			
			
		}
		if(getTheInfo) return info;
		return null;
	}
}
