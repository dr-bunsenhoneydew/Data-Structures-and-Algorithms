package ArraysAndStrings.Exercises;

public class exercise3sb {

    // Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.

    // This approach uses StringBuilder as opposed to a char array as in exercise3.java. While this only traverses the initial string once, it results in a time complexity of O(N) and a space complexity of O(N). The previous method was O(N), O(1) respectively.

    public static void main (String[] args) {
        String str = "Hello my name is Ryan";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }
}
