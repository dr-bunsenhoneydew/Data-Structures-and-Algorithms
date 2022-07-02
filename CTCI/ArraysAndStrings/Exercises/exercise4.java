package ArraysAndStrings.Exercises;

import java.util.HashMap;

public class exercise4 {

// Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words. You can ignore casing and non-letter characters.

// First thoughts, in order to be a palindrome, the word should have all even counts of characters, with a max of an odd character. We should begin by traversing the string in order to create a dictionary of counts. Then, travers the dictionary to see if our even/odd conditions have been met. 

// Final time complexity of this implementation is O(N) with O(N) space complexity as we create the hashmap.

    public static void plaindromePermutation(String str) {
        //create char frequency hashmap
        HashMap<Character,Integer> dict = new HashMap<Character,Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (!dict.containsKey(str.charAt(i))) {
                dict.put(str.charAt(i),1);
            }
            else {
                dict.put(str.charAt(i), dict.get(str.charAt(i)) + 1);
            }
        }

        //itereate through keyset of char frequency hashmap to count number of odd freq characters. If this is greater than 1, it is not a permutation of a palindrome.
        int countOdd = 0;
        for (char k : dict.keySet()) {
            if (dict.get(k) % 2 != 0) {
                countOdd++;
            }
        }

        if (countOdd > 1) {
            System.out.println("Not a permutation of palindrome");
        }
        else {
            System.out.println("Yes, permutation of palindrome");
        }
    }
    


    public static void main(String[] args) {
        String str1 = "racecar";
        String str2 = "banana";
        String str3 = "tacocat";

        plaindromePermutation(str1); // returns yes, palindrome
        plaindromePermutation(str2); // returns no, NOT palindrome
        plaindromePermutation(str3); // returns yes, palindrome

    }
}
