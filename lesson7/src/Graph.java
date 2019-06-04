/*
 * Created by Oxana Lobysheva on 04/06/2019.
 */

import java.io.*;

public class Graph {

    private Vertex[] vertexList;
    private int vertexCount;
    private int[][] matrix;

    Queue queue;
    Stack stack;

    public Graph(int size){
        matrix = new int[size][size];
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                matrix[i][j] = 0;
        vertexCount = 0;
        vertexList = new Vertex[size];
        queue = new Queue(size);
        stack = new Stack(size);
    }

    public void addVertex(String label){
        if (getVertexIndex(label) == -1) {
            vertexList[vertexCount++] = new Vertex(label);
        }
    }

    public int getVertexIndex(String label){
        for (int i = 0; i < vertexList.length; i++){
            if (vertexList[i]  != null && label.equals(vertexList[i].getLabel())){
                return i;
            }
        }
        return -1;
    }

    public void addOneWayEdge(String start, String end, int value){
        int start_index = getVertexIndex(start);
        int end_index = getVertexIndex(end);
        if (start_index != -1 && end_index != -1){
            matrix[start_index][end_index] = value;
            matrix[end_index][start_index] = 0;
        }

    }

    public void addTwoWayEdge(String start, String end, int value){
        int start_index = getVertexIndex(start);
        int end_index = getVertexIndex(end);
        if (start_index != -1 && end_index != -1){
            matrix[start_index][end_index] = value;
            matrix[end_index][start_index] = value;
        }
    }


    public void breadthFirstSearch(int value){
        queue.add(value);
        System.out.println("breadthFirstSearch: vertex = " + vertexList[value].getLabel());

        while (getNext(value) != -1) {
            int next = getNext(value);
            queue.add(next);
            vertexList[next].setVisited(true);
        }
        vertexList[value].setDone(true);
        queue.remove();
        cleanStatus();
        if (!queue.isEmpty()) {
            breadthFirstSearch(queue.getFirstValue());
        }

    }


    public void depthFirstSearch(int value){
        stack.push(value);
        System.out.println("depthFirstSearch: vertex = " + vertexList[value].getLabel());
        stack.pop();
        while (getNext(value) != -1) {
            int next = getNext(value);
            stack.push(next);
            vertexList[next].setVisited(true);
        }
        vertexList[value].setDone(true);
        cleanStatus();
        if (!stack.isEmpty()) {
            depthFirstSearch(stack.peek());
        }
    }

    public void cleanStatus(){
        for (int i = 0; i < vertexCount; i++) {
            vertexList[i].setVisited(false);
        }
        if (isFinished()){
            for (int i = 0; i < vertexCount; i++) {
                vertexList[i].setDone(false);
            }
        }
    }


    private int getNext (int value){
        for(int i = 0; i < vertexCount; i++) {
            if (matrix[value][i] > 0 && vertexList[i].isVisited() == false && vertexList[i].isDone() != true) {
                return i;
            }
        }
        return -1;
    }

    private boolean isFinished(){
        for(int i = 0; i < vertexCount; i++) {
            for (int k = 0; k < vertexCount; k++) {
                if (matrix[i][k] > 0 && vertexList[i].isDone() != true) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printMatrix(){
        System.out.print("  ");
        for (int k = 0; k < vertexList.length; k++){
            System.out.print(vertexList[k].getLabel() + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++){
            System.out.print(vertexList[i].getLabel() + " ");
            for (int k = 0; k < matrix[i].length; k++){

                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
    }


    public void fillGraphFromFile(String path){
        if (path == null) return;
        try {

            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    getData(line);
                }
            } while (line != null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData(String data){
        data.replace("[^[A-Za-z0-9]]", " ").trim();
        String[] parts = data.split(" ");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() > 1) {

                String start = String.valueOf(parts[i].charAt(0));
                String end = String.valueOf(parts[i].charAt(1));
                Integer value = Integer.valueOf(parts[i].replaceAll( "[^\\d]", "" ));

                addVertex(start);
                addVertex(end);
                addTwoWayEdge(start, end, value);
            }
        }
    }

}
