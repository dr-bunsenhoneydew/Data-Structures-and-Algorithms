package ArraysAndStrings.Exercises;

import java.util.HashSet;

public class exercise1 {

    // Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

    //First thoughts to avoid the double for loop, is that we can implement a set in order to observe if we've already seen a character in O(1) lookup time; however, the new set could create space O(N). This could also be implemented with an array of set characters which also has a lookup time of O(1). The array method would be set at size 128 given ASCII characters, so could be considered O(1) space. Let's try a set first...


    // This method has an overall time complexity of O(N) in order to iterate through the length of the string, and a size complexity of O(N)
    public static boolean ex1set(String str) {
        HashSet<Character> mySet = new HashSet<Character>();

        for (int i = 0; i < str.length(); i++) {
            if (!mySet.contains(str.charAt(i))) {
                mySet.add(str.charAt(i));
            }
            else {
                return false;
            }
        }
        return true;
    }

    // Now to implement the array method with a time complexity of O(N) - though you could argue O(1) given you never iterate past 128 characters - and space complexity of O(1)... THIS SEEMS TO BE THE BEST METHOD 

    public static boolean ex1arr(String str) {
        if (str.length() > 128) {return false;}

        boolean[] arr = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(arr[val]) {
                return false;
            }
            arr[val] = true;
        }
        return true;
    }


    //If you cannot use additional data structures, the naive approach would be to implement two loops across the string/array. This would ultimately lead to O(N^2), with space O(1);

    public static boolean naiveEx1(String str) {
        

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
    
            }
        }
        return true;
    }
    

    public static void main(String[] args) {
        String str1 = "abcdefgchi";
        String str2 = "abcdefghij";
        String str3 = "abcdefgg";
        
        System.out.println(ex1set(str1)); // returns false due to dupe 'c'
        System.out.println(ex1set(str2)); // returns true
        System.out.println(ex1set(str3)); // returns flase due to dupe 'g'

        System.out.println(ex1arr(str1)); // returns false due to dupe 'c'
        System.out.println(ex1arr(str2)); // returns true
        System.out.println(ex1arr(str3)); // returns flase due to dupe 'g'
        
        System.out.println(naiveEx1(str1)); // returns false due to dupe 'c'
        System.out.println(naiveEx1(str2)); // returns true 
        System.out.println(naiveEx1(str3)); //returns false due to dupe 'g'


    }
    
}
