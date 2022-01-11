import java.util.Scanner;

public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s) {
        int vowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                vowels++;
            } else if (s.charAt(i) == 'e') {
                vowels++;
            } else if (s.charAt(i) == 'i') {
                vowels++;
            } else if (s.charAt(i) == 'o') {
                vowels++;
            } else if (s.charAt(i) == 'u') {
                vowels++;
            }

        }
        return vowels;
    }

    //Code you problem number two here
    static int problemTwo(String s) {
        int bob = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.substring(i, i + 3).equals("bob")) {
                bob++;
            }
        }
        return bob;
    }

    //Code your solution to problem number 3 here
    static String problemThree(String s) {
        int start = 0;
        int length = 1;
        int tempLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) <= s.charAt(i + 1)) {
                tempLength++;
                int a = i + 1;
                if (length < tempLength) {
                    length = tempLength;
                    start = a - (length - 1);
                }

            } else {
                tempLength = 1;
            }
        }
        String answer = s.substring(start,start+length);
        return answer;
    }

    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
    }
}
