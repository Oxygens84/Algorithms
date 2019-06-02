/*
 * Created by Oxana Lobysheva on 02/06/2019.
 */


import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson6 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] arg){


        //-----------------------------------------------------------------------------

        System.out.println("\n\n1. Реализовать простейшую хэш-функцию. " +
                "На вход функции подается строка, на выходе сумма кодов символов.");

        String input = "qwerty12345";
        System.out.println(input + " => " + hashFunction(input));


        //-----------------------------------------------------------------------------

        System.out.println("\n\n2. Переписать программу, реализующее двоичное дерево поиска.");
        System.out.println("   а) Добавить в него обход дерева различными способами;");

        BinarySearchTree tree = new BinarySearchTree();

        tree.add(0);
        tree.add(1);
        tree.add(2);
        tree.add(6);

        tree.printTreePreOrder();
        tree.delete(2);
        tree.printTreePreOrder();

        tree.add(7);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(8);
        tree.add(9);
        tree.add(5);

        System.out.println("\nprintTreePreOrder:");
        tree.printTreePreOrder();

        System.out.println("\nprintTreeInOrder:");
        tree.printTreeInOrder();

        System.out.println("\nprintTreePostOrder:");
        tree.printTreePostOrder();

        System.out.println();
        tree.printKeys();

        //-----------------------------------------------------------------------------

        System.out.println("\n\n2. Переписать программу, реализующее двоичное дерево поиска.");
        System.out.println("   б) Реализовать поиск в двоичном дереве поиска;");

        for (int i = 0; i < 10; i++) {
            System.out.println("\nsearch for parent " + i);
            tree.find(i);
        }

        //-----------------------------------------------------------------------------


        System.out.println("\n\n2. Переписать программу, реализующее двоичное дерево поиска.");
        System.out.println("  в) *Добавить в программу обработку командной строки с помощью которой можно указывать");
        System.out.println("     из какого файла считывать данные, каким образом обходить дерево.");

        String path = "";
        String inputValue = "";
        int type = 0;
        BinarySearchTree treeFile = new BinarySearchTree();

        try {

            do {
                System.out.println("Введите путь к файлу. Образец: ./src/data.txt");
                path = sc.nextLine();
            } while (path.equals(""));

            do {
                System.out.println("Укажите вид обхода: " +
                        "\n1 - printTreePreOrder" +
                        "\n2 - printTreeInOrder" +
                        "\n3 - printTreePostOrder");
                inputValue = sc.nextLine();

                if (!inputValue.equals("")) {
                    type = Integer.parseInt(inputValue);
                }

            } while (inputValue.equals("") || type < 1 || type > 3);

            try {
                File file = new File(path);
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line;
                do {
                    line = reader.readLine();
                    if (line != null) {
                        treeFile.fillTree(line);
                    }
                } while (line != null);

                treeFile.printTree(type);
                treeFile.printKeys();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch Exception");
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception");
        } finally {
            sc.close();
        }


        //-----------------------------------------------------------------------------

        System.out.println("\n\n3. *Разработать базу данных студентов из двух полей “Имя”, “Возраст”, “Табельный номер”");
        System.out.println("  в которой использовать все знания, полученные на уроках.");
        System.out.println("  Считайте данные в двоичное дерево поиска. Реализуйте поиск по какому-нибудь полю базы данных (возраст, вес)");


        StudentDataBase students = new StudentDataBase();

        students.add(0, "Name0", 20);
        students.add(1, "Name1", 21);
        students.add(2, "Name2", 22);
        students.add(6, "Name6", 26);
        students.delete(2);
        students.add(7, "Name7", 27);
        students.add(4, "Name4", 24);

        System.out.println("\nprintTreePreOrder:");
        students.printTreePreOrder();
        students.printKeys();

        System.out.println("\nsearch for 6:");
        students.find(6);

    }


    //-----------------------------------------------------------------------------

    //1. Реализовать простейшую хэш-функцию. На вход функции подается строка, на выходе сумма кодов символов.

    public static String hashFunction(String input) {
        String output = "";
        byte[] array = input.getBytes();
        for (int i = 0; i < array.length; ++i) {
            output = output + array[i] + addChars(i);
        }
        return output;
    }

    public static String addChars(int k){
        String res = "";
        char[] chars = {
                'j' , 'k' , 'l' , 'm' , 'n' , 'o' , 'p' , 'q' , 'r' ,
                'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 'i' ,
                's' , 't' , 'u' , 'v' , 'w' , 'x' , 'y' , 'z'
        };
        do {
            if (k < chars.length) {
                res = res + chars[k];
            }
            k =- chars.length;
        } while (k > 0);
        return res;
    }

}