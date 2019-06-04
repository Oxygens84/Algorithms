/*
 * Created by Oxana Lobysheva on 04/06/2019.
 */

public class Queue {

    private int[] array;
    private int size;
    private int count;
    private int first;
    private int last;

    public Queue(int queueSize){
        size = queueSize;
        first = 0;
        last = -1;
        count = 0;
        array = new int[size];
        fillArrayByDefault();
    }

    public int getFirstValue(){
        return array[first];
    }

    private void fillArrayByDefault(){
        for (int i = 0; i < size; i++){
            array[i] = -1;
        }
    }

    public void add(int value){
        if (isAdded(value) == false) {
            if (last == size - 1) {
                last = 0;
            }
            array[++last] = value;
            count++;
        }
    }

    public int remove(){
        int temp = array[first++];
        count--;
        return temp;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return (count == 0);
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