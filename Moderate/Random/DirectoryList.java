import java.io.*;

/* Symantec Interview Question: Write a program to read a give directory in 
 * your hard drive and list all the sub directories and files as hierarchy structure.
 * Refernce: careercup.com
 */

public class DirectoryList {
	public static void getList(File inputFile) {
		if(inputFile.isDirectory()) {
			for(File f : inputFile.listFiles()) {
				if(f.isDirectory())
					System.out.println("Directory Name: "+f.getName());
					getList(f);
			}
		}
		else if(inputFile.isFile())	{
			System.out.println("File Name: "+inputFile.getName());
		}	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String file = "/Users/widea/Desktop/thesis";
		File inputFile = new File(file);
		getList(inputFile);
	}
}
