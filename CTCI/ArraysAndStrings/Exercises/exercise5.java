package ArraysAndStrings.Exercises;

public class exercise5 {
    
// There are 3 types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

// ex: pale, ple -> true
// ex: pales, pale -> true
// ex: pale, bale -> true
// ex: pale, bake -> false

// Note here that insertion and removal of characters are really the same, you can just flip the arguments. So, we should implement two checks, oneEditReplacement if the lengths are the same, and oneEditInsert if the lengths are different by 1 char. Otherwise, we can O(1) return false. 

// Since we are required to loop through both strings, time complexity is O(N). Space complexity is O(1).

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        }
        else if (first.length() == second.length() - 1) {
            return oneEditInsert(first, second);
        }
        else if (first.length() == second.length() + 1) {
            return oneEditInsert(second, first);
        }
        else {return false;}
    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean difference = false; //boolean counter, if there are more than one difference, we will exit as return false

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (difference) {
                    return false;
                }
                difference = true;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String s1, String s2) {
        int ind1 = 0;
        int ind2 = 0;
        
        while (ind1 < s1.length() && ind2 < s2.length()) {
            if (s1.charAt(ind1) == s2.charAt(ind2)) {
                ind1++;
                ind2++;
            }
            else {
                if (ind1 != ind2) {
                    return false;
                }
                ind2++;
            }
        }
        return true;
    }


    public static void main(String[]  args) {
        String str1 = "pale";
        String str2 = "pal";
        System.out.println(oneEditAway(str1,str2));
    }

}
