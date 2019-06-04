/*
 * Created by Oxana Lobysheva on 04/06/2019.
 */

public class Run {


    public static void main(String[] arg){

        System.out.println("\n1. Написать функции, которые считывают матрицу смежности из файла и выводят ее на экран");

        Graph graph_file = new Graph(8);
        graph_file.fillGraphFromFile("./src/matrix.txt");
        graph_file.printMatrix();
        graph_file.breadthFirstSearch(3);
        graph_file.depthFirstSearch(3);

        System.out.println("\n2. Написать рекурсивную функцию обхода графа в глубину.");
        System.out.println("3. Написать функцию обхода графа в ширину.");
        System.out.println("4. *Создать библиотеку функций для работы с графами.");

        Graph graph_manual = new Graph(6);
        graph_manual.addVertex("A");
        graph_manual.addVertex("B");
        graph_manual.addVertex("C");
        graph_manual.addVertex("D");
        graph_manual.addVertex("E");
        graph_manual.addVertex("F");
        graph_manual.addTwoWayEdge("A", "B", 1);
        graph_manual.addTwoWayEdge("B", "D", 7);
        graph_manual.addTwoWayEdge("C", "D", 8);
        graph_manual.addTwoWayEdge("C", "E", 5);
        graph_manual.addTwoWayEdge("D", "E", 3);
        graph_manual.addTwoWayEdge("B", "C", 9);
        graph_manual.addTwoWayEdge("A", "C", 2);
        graph_manual.addTwoWayEdge("E", "F", 3);
        graph_manual.addTwoWayEdge("D", "F", 1);
        graph_manual.printMatrix();
        graph_manual.breadthFirstSearch(0);
        graph_manual.depthFirstSearch(0);

    }

}



