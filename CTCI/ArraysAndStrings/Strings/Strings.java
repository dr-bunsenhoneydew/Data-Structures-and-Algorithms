package ArraysAndStrings.Strings;
//Strings are immutable. Once created they cannot be changed

public class Strings {

    public static void main(String[] args) {
    //Create strings using the built in object class String
    //Either as a literal, or using new constructor method
    String str = "abcde";
    String str2 = new String("my string");
    
    //Strings can be any character
    String strNums = "12345";
    String strRandomSymbols = "!@#$%";



    //Top Methods for Strings
    // .indexOf() - Used to find characters and substrings in a string. It returns the index of the first occurrence from the left of the passed string within this string; moreover, if we provide the fromIndex parameter, it starts searching from that index. Returns either the first occurence as an int, 0 if passed an empty string, or -1 if no match.

    int ind = str.indexOf('c', 0);
    System.out.println("Index of 'c' in String 'abcde' is " + ind);
   
   
    // .toCharArray() - Used to form a new character array from this string. The newly allocated array's contents are initialized to contain the characters represented by this string, and its length is the length of this string. No parameters. Returns a char[] array in memory with content as characters of the string. Can use this to implement array methods.

    char[] arr = str.toCharArray();
    System.out.println(arr);
    System.out.println(arr[0]);

   
    // .charAt() - the character at the designated index (follows 0 based indexing) is extracted from the string. It's useful for checking a certain index without looping over the whole string. Indexing method for Strings. Returns char. 

    char x = str.charAt(2);
    System.out.println("Char At Index 2 of 'abcde' is " + x);

    // .concat() - the passed string is appended to the end of the specified string. This creates an entirely NEW string by copying both over. Run times a long - opt for StringBuilder 

    String concatStr = strRandomSymbols.concat(str2);
    System.out.println("Concatenated string: " + concatStr);

    
    // .replace() - used for replacing characters and substrings in a string. This returns a NEW string object that has replaced all instances of an oldChar with a newChar

    String replacedStr = str.replace('a', 'c');
    System.out.println("Replaced String: " + replacedStr);


    // .substring() - used to extract a portion of a string from a given string. It creates a new string object without altering the original string. Returns a NEW string object resulting from splicing the two indices.

    String subStr = strNums.substring(1,3);
    System.out.println("Substring: " + subStr);


    // .split() - used to separate the specified string depending on the regular expression. The limit parameter can be used to limit the number of strings returned after separating. Returns a new ARRAY.

    String[] newStrArr = str2.split(" ");
    System.out.println("Split String: " + newStrArr[0] + " " + newStrArr[1]);

    
    // .compareTo() - used to compare two Strings alphabetically. Returns 0 if the argument is equal to the given string; < 0 if lexicographically less than the string argument, and > 0 if lexicographically greater than the string argument
    // **** ALSO .equals() to compare strings, this method returns a boolean value

    String myStr1 = "Hello";
    String myStr2 = "Hello";
    String myStr3 = "Another String";
    System.out.println(myStr1.equals(myStr2)); // Returns true because they are equal
    System.out.println(myStr1.equals(myStr3)); // false






    }
   
}
