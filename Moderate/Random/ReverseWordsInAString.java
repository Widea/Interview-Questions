// program to reverse the words in a string.

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String input = "Java is awesome!";
        System.out.println("In: " + input);

        String output = reverseWords(input);
        System.out.println("Out: " + output);
    }

    private static String reverseWords(String input) {
        String[] split = input.split(" ");
        StringBuilder output = new StringBuilder("");
        for (int i = split.length - 1; i >= 0; i--) {
            output.append(split[i]+" ");       
        }
        return output.toString();
    }
}
