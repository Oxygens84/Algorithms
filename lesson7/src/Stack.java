/*
 * Created by Oxana Lobysheva on 04/06/2019.
 */

public class Stack {

    private final int size;
    private final int[] array;
    private int top;

    public Stack(int size) {
        this.size = size;
        top = -1;
        array = new int[size];
        fillArrayByDefault();
    }

    private void fillArrayByDefault(){
        for (int i = 0; i < size; i++){
            array[i] = -1;
        }
    }

    public void push(int node){
        if (isAdded(node) == false) {
            array[++top] = node;
        }
    }

    public int pop(){
        return array[top--];
    }

    public int peek(){
        return array[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }


    public boolean isFull(){
        return (top == size - 1);
    }

    public boolean isAdded(int value){
        for (int i = 0; i < array.length; i++){
            if (value == array[i]){
                return true;
            }
        }
        return false;
    }
}
