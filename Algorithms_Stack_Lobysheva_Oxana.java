public class Lesson5 {

    public static String output = "";

    public static void main(String[] arg){

        System.out.println("\n\n1. Реализовать перевод из 10 в 2 систему счисления с использованием стека.");

        translateFromDecimalIntoBinary(56666666);

        System.out.println("check \"stack too small\":");
        translateFromDecimalIntoBinary(999999999);


        System.out.println("\n\n3. Написать программу, которая определяет, является ли введенная скобочная последовательность правильной. ");
        System.out.println("  Примеры правильных скобочных выражений: (), ([])(), {}(), ([{}]), неправильных — )(, ())({), (, ])}), ([(]) для скобок [,(,{.");

        boolean res;

        String input1 = "(2+(2*2))";
        res = checkSyntax(input1);
        System.out.println("is " + input1 + " ok? " + res);

        String input2 = "([2/{5*(4+7)}]}";
        res = checkSyntax(input2);
        System.out.println("is " + input2 + " ok? " + res);


        System.out.println("\n\n5. **Реализовать алгоритм перевода из инфиксной записи арифметического выражения в постфиксную.");

        String input = "1+2*4/(50-7)+3/6";
        String output = doTranslation(input);
        System.out.println("Postfix for " + input + " is " + output);


    }

    //------------------------------------------------------------

    public static class StackString{

        private String[] array;
        private int last;
        private int size;

        StackString(int size){
            this.size = size;
            init(size);
        }

        private void init(int size){
            last = -1;
            array = new String[size];
        }

        private void push(String value){
            last++;
            array[last] = value;
        }

        private void pop(){
            array[last] = null;
            last--;
        }

        private String getLast(){
            return array[last];
        }

        private void print(){
            for (int i = array.length-1; i >= 0; i--){
                if (array[i] != null) {
                    System.out.print(array[i]);
                }
            }
            System.out.println();
        }

        private boolean isFull(){
            return ((size - 1) <= last);
        }

        private boolean isEmpty(){
            return last == -1;
        }
    }

    //------------------------------------------------------------


    //1. Реализовать перевод из 10 в 2 систему счисления с использованием стека.
    private static void translateFromDecimalIntoBinary(int int_number) {
        //Deque stack = new ArrayDeque<Integer>();
        //Stack stack = new Stack();
        StackString stack = new StackString(27);
        while(int_number > 0){
            if(!stack.isFull()) {
                stack.push(String.valueOf(int_number % 2));
                int_number = int_number / 2;
            } else {
                System.out.println("Error: stack is full");
                int_number = 0;
            }
        }
        stack.print();
    }


    //3. Написать программу, которая определяет, является ли введенная скобочная последовательность правильной.
    //   Примеры правильных скобочных выражений: (), ([])(), {}(), ([{}]), неправильных — )(, ())({), (, ])}), ([(]) для скобок [,(,{.
    //   Например: (2+(2*2)) или [2/{5*(4+7)}]
    public static boolean checkSyntax(String equation){
        StackString stack = new StackString(50);

        for (int i = 0; i < equation.length(); i++){
            String value = String.valueOf(equation.charAt(i));
            checkBrace(value, stack);
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkBrace(String value, StackString stack){
        //String[] openBraces = {"(", "{", "[", "<"};
        //String[] closedBraces = {")", "}", "]", ">"};
        String[] openBraces = {"(", "{", "["};
        String[] closedBraces = {")", "}", "]"};

        for (int i = 0; i < openBraces.length; i++){
            if (openBraces[i].equals(value)) {
                stack.push(value);
            }
        }

        for (int i = 0; i < closedBraces.length; i++){
            if (closedBraces[i].equals(value)){
                if (!stack.isEmpty()) {
                    if (openBraces[i].equals(stack.getLast())) {
                        stack.pop();
                    } else {
                        stack.push(value);
                    }
                } else {
                    stack.push(value);
                }
            }
        }

    }


    //5. **Реализовать алгоритм перевода из инфиксной записи арифметического выражения в постфиксную.

    public static String doTranslation(String input) {

        int size = input.length();
        StackString stack = new StackString(size);

        for (int i = 0; i < size; i++) {
            String value = String.valueOf(input.charAt(i));
            switch (value) {
                case "+":
                case "-":
                    getOperation(1, stack);
                    stack.push(value);
                    break;
                case "*":
                case "/":
                    getOperation(2, stack);
                    stack.push(value);
                    break;
                case "(":
                    stack.push(value);
                    break;
                case ")":
                    getBrace(stack);
                    break;
                default:
                    output = output + value;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            output = output + stack.getLast();
            stack.pop();
        }
        return output;
    }


    public static void getOperation(int priority, StackString stack) {
        while (!stack.isEmpty()) {
            String value = stack.getLast();
            stack.pop();
            if (value.equals("(")) {
                stack.push(value);
                break;
            }
            else {
                int priority2;
                if (value.equals("+") || value.equals("-")) {
                    priority2 = 1;
                } else {
                    priority2 = 2;
                }
                if (priority2 < priority) {
                    stack.push(value);
                    break;
                } else {
                    output = output + value;
                }
            }
        }
    }

    public static void getBrace(StackString stack){
        while (!stack.isEmpty()) {
            String value = stack.getLast();
            stack.pop();
            if (value.equals("(")) {
                break;
            } else {
                output = output + value;
            }
        }
    }

}
