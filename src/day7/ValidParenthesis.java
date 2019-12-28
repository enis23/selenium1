package Stacks;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    // Hash table that takes care of the mappings.
    static HashMap<Character, Character> mappings;

    public static void main(String[] args) {

        // Initialize hash map with mappings. This simply makes the code easier to read.
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        boolean result = isValid("[{]");
    }
//when thru array, to get to 9 element, you have to go thru all the elements. 1, 2,3,4,5,6,,7, ,8,9 ;
    //where in HashMap, you can go to the key directly.
    public static boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
