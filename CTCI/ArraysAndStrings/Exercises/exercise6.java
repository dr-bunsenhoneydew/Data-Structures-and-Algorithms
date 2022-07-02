package ArraysAndStrings.Exercises;

public class exercise6 {
    
// Implement a method to perform basic string compression using the counts of repeated characters. For example, the string 'aabcccccaaa' would become a2b1c5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. you can assume the string has only uppercase and lowercase letters (a-z).

// First thoughts are to implement StringBuilder so that we are not bogged down by constantly concatenating our result string. If we were to iterate through the original string, and build our result, this would require O(N) time complexity and O(N) space complexity.

    public static String stringCompression(String str) {
        StringBuilder resultString = new StringBuilder();
        char currChar = ' ';
        int currCount = 0;

        for (int i = 0; i < str.length(); i++) {
            
            //if it is a new character, update variables and add the new character
            if (str.charAt(i) != currChar) {
                currChar = str.charAt(i);
                currCount = 1;
                resultString.append(currChar);
                //if there is only one of the characters, or if it is the end of the string, also add the count
                if (i + 1 == str.length() || str.charAt(i+1) != currChar) {
                    resultString.append(currCount);
                }
            }
            //otherwise, if it is the same character as the previous, update the count
            else {
                currCount++;
                //if we are not at the end of the string AND the next character is the same, continue
                if (i+1 < str.length() && str.charAt(i+1) == currChar) {
                    continue;
                }
                //otherwise, we must be either at the end of the string OR the next character is different. Thus, we need to append the current count
                else {
                    resultString.append(currCount);
                }
            }
        }

        if (str.length() < resultString.length()) {return str;} 
        else {return resultString.toString();}
    }

    public static void main (String[] args) {
        String str1 = "aaabcdeffffffff";
        System.out.println(stringCompression(str1));
    }



}
