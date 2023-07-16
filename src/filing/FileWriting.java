package filing;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWriting {

	public static void dataWrite(String data,String fileName)  {
		File file = new File(fileName);
		FileWriter fw;
		try {
			fw = new FileWriter(file,true);
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void refreshData(String data,String fileName) {
		
		File file = new File(fileName);
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}
	}
}
