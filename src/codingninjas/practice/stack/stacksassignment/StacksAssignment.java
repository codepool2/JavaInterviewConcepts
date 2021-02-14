package codingninjas.practice.stack.stacksassignment;

import java.util.Stack;

public class StacksAssignment {


    public static boolean checkRedundantBrackets(String expression) {


        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

             if (expression.charAt(i) != ')') {

                stack.push(expression.charAt(i));
            } else {

                if (stack.isEmpty()) {
                    return true;
                }

                int count = 0;

                while (!stack.isEmpty()) {

                    Character character = stack.pop();

                    if (character.equals('(')) {

                        if (count > 0) {

                            if(stack.isEmpty()){
                                return false;
                            }
                            break;
                        } else {
                            return true;
                        }

                    } else {
                        count++;
                    }


                }
            }

        }

         return !stack.isEmpty();
    }


    public static void main(String[] args) {

        System.out.println(checkRedundantBrackets("(a)"));
    }
}
