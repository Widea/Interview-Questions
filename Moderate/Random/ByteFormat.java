import java.text.DecimalFormat;

/*
 * Problem: Convert a number to a string that represents a rounded size in bytes.
 */

public class ByteFormat {
	public static void format(long inp) {
		String[] dim = {"Bytes", "Kb", "Mb", "Gb", "Tb"}; 
		float output = inp;
		int count = 0;
		
		DecimalFormat df = new DecimalFormat("00.00");
		
		while(output > 1024){
			output = output/1024;
			count++;
		}
		System.out.println("The formatted number is: " +df.format(output) + " " +dim[count]);
	}
	
	public static void main(String[] a) {
		
		format(156833213); // => "149.57 MB"
		format(8101);      // => "7.91 KB"
		format(12331);  // => "12.042 KB"
		format(123);  // => "12.042 KB"
	}
}
