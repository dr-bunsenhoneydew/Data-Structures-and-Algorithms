package ArraysAndStrings.Exercises;

public class exercise9 {
    
// Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring(e.g. "waterbottle" is a rotation of "erbottlewat").

// First thoughts: Call s2 a rotation of s1. s2 will therefore always be a substring of s1s1 - e.g. 'erbottlewat' will always be a substring of 'watERBOTTLEWATerbottle'. We can use this to call isSubstring once to determine if it is indeed a rotation. Also, in order to confirm if it is a rotation, the lengths should be the same. If not, we can confidentally return false.

// Time complexity will be O(N), with space complexity O(N).

    public static boolean stringRotation(String s1, String s2) {
        if (s1.length() > 0 && s1.length() == s2.length()) {
            String s1s1 = s1.concat(s1);
            return isSubstring(s1s1, s2);
        }
        return false;
    }

}
