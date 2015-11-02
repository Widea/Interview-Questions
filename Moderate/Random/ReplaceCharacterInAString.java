// Program to replace all instances of a given character in a string

public class ReplaceCharacterInAString {
	
	static String replaceCharacter(String s, char c, char x) {
		if(s.isEmpty()){
			return s;
		}
		
		StringBuffer output = new StringBuffer(s);
		while(true) {
			int temp = output.lastIndexOf(String.valueOf(c));
			if(temp == -1)
				break;
			output.setCharAt(temp, x);
		}
		return output.toString();
	}
	
	 public static void main(String[] a) {
		 System.out.println(replaceCharacter("Funtion", 'a', 's'));
		 System.out.println(replaceCharacter("Hola humpa it is me!", 'i', 'z'));

	 }
}
