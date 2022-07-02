package ArraysAndStrings.Exercises;

import java.util.*;

public class exercise2 {
    
    //Given two strings, write a method to decide if one is a permutation of the other

    //Important to clarify what counts as a permutation. "God" a permutation of dog? What about white space? Let's assume case sensitive and whitespace matters. 

    //First thoughts are we can sort each and then compare, this will require time complexity of O(N log N) and space O(N) in order to create the new sorted arrays

    //Sorting and comparing:
    public String sorting(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public boolean sortingAndComparing(String one, String two) {
        if (one.length() != two.length()) {return false;}
        return sorting(one).equals(sorting(two));
    }


    //You can also traverse the two strings and compare with a dictionary of counts that should sum to 0. This has a time complexity of O(N) and a space complexity of O(1) w/ an array of 128 characters.

    public boolean traversingAndComparing(String one, String two) {
        if (one.length() != two.length()) {return false;}
        
        int[] countArr = new int[128]; //Assuming ASCII
        for (int i = 0; i < one.length(); i++) {
            countArr[one.charAt(i)]++;
        }
        for (int j = 0; j < two.length(); j++) {
            countArr[two.charAt(j)]--;
            if (countArr[two.charAt(j)] < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        exercise2 myEx = new exercise2();
        System.out.println(myEx.sortingAndComparing("dad","add")); //returns true
        System.out.println(myEx.sortingAndComparing("banana","abanan")); //returns true
        System.out.println(myEx.sortingAndComparing("hair","fair")); //returns false
        System.out.println(myEx.sortingAndComparing("me","bee")); //returns false

        System.out.println(myEx.traversingAndComparing("dad","add")); //returns true
        System.out.println(myEx.traversingAndComparing("banana","abanan")); //returns true
        System.out.println(myEx.traversingAndComparing("hair","fair")); //returns false
        System.out.println(myEx.traversingAndComparing("me","bee")); //returns false


    }

}
