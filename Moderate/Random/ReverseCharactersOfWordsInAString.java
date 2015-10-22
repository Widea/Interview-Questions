// Program to reverse only the characters of each word in a given string

public class ReverseCharacetersOfWordsInAString {	
	public static void main(String[] args) {
        String input = "Java is awesome!";
        System.out.println("In: " + input);

        String output = reverseWords(input);
        System.out.println("Out: " + output);
    }

    private static String reverseWords(String input) {
        String[] split = input.split(" ");
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < split.length; i++) {
        	String temp = split[i];
        	for(int j = temp.length() -1 ; j >= 0 ; j--) {
        		output.append(temp.charAt(j));
        	}
        	output.append(" ");
        }
        return output.toString();
    }
}
