package ArraysAndStrings.Exercises;

public class exercise3 {
    
    // Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.

    // The approach here, given the fixed amount of space in an array is to calculate the room we will need. To do so, find the difference between '%20' and ' ' = 2, and multiply it by the # of spaces to find the total space needed in the final array. Then iterate backwards through the original list, copying the new values to the new char array.

    // Final time complexity here is O(N), with space complexity of O(1).

    public static void replaceSpace(char[] str, int trueLength) {

        //count whitespace
        int count = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                count++;
            }
        }

        //initiate int new index to be at end of empty spots
        int newIndex = trueLength + (count * 2);

        // if there are empty spots, make the last of which \0
        if (newIndex + 1 < str.length) {
            str[newIndex + 1] = '\0';
        }

        for (int i = trueLength - 1; i>= 0; i--) {
            if (str[i] == ' ') {
                str[newIndex - 1] = '0';
                str[newIndex - 2] = '2';
                str[newIndex - 3] = '%';
                newIndex -= 3;
            }
            else {
                str[newIndex - 1] = str[i];
                newIndex -= 1;
            }
        }
        System.out.println(str);
    }



    public static void main(String[]  args) {
        String str = "Hi this is Ryan       ";
        replaceSpace(str.toCharArray(), str.trim().length());
    }

}
