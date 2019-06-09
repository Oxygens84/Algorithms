/*
 * Created by Oxana Lobysheva on 09/06/2019.
 */

public class Lesson8 {

    private static long countOperations = 0;

    public static void main(String[] arg){

        System.out.println("\n\n1. Реализовать сортировку подсчетом.");

            countOperations = 0;
            int[] array_100_1 = new int[100];
            fillArray(array_100_1, 100);
            long counting_100 = countingSorting(array_100_1, array_100_1.length);

            countOperations = 0;
            int[] array_10000_1 = new int[10000];
            fillArray(array_10000_1, 10000);
            long counting_10000 = countingSorting(array_10000_1, array_10000_1.length);

            countOperations = 0;
            int[] array_1000000_1 = new int[1000000];
            fillArray(array_1000000_1, 1000000);
            long counting_1000000 = countingSorting(array_1000000_1, array_1000000_1.length);

            System.out.println("result array 10000:");
            printArrayByX(array_10000_1, 0, 100);

        System.out.println("\n\n2. Реализовать быструю сортировку.");

            countOperations = 0;
            int[] array_100_2 = new int[100];
            fillArray(array_100_2, 100);
            long quick_100 = quickSorting(array_100_2, 0, array_100_2.length-1);

            countOperations = 0;
            int[] array_10000_2 = new int[10000];
            fillArray(array_10000_2, 10000);
            long quick_10000 = quickSorting(array_10000_2, 0, array_10000_2.length-1);

            countOperations = 0;
            int[] array_1000000_2 = new int[1000000];
            fillArray(array_1000000_2, 1000000);
            long quick_1000000 = quickSorting(array_1000000_2, 0, array_1000000_2.length-1);

            System.out.println("result array 10000:");
            printArrayByX(array_10000_2, 0, 100);

        System.out.println("\n\n3. *Реализовать сортировку слиянием.");

            countOperations = 0;
            int[] array_100_3 = new int[100];
            fillArray(array_100_3, 100);
            long merge_100 = mergeSorting(array_100_3, 0, array_100_3.length-1);

            countOperations = 0;
            int[] array_10000_3 = new int[10000];
            fillArray(array_10000_3, 10000);
            long merge_10000 = mergeSorting(array_10000_3, 0, array_10000_3.length-1);

            countOperations = 0;
            int[] array_1000000_3 = new int[1000000];
            fillArray(array_1000000_3, 1000000);
            long merge_1000000 = mergeSorting(array_1000000_3, 0, array_1000000_3.length-1);

            System.out.println("result array 10000:");
            printArrayByX(array_10000_3, 0, 100);


        System.out.println("\n\n5. Проанализировать время работы каждого из вида сортировок для 100, 10000, 1000000 элементов.");

            System.out.println("compare/swap operations for counting sorting for 100 = " + counting_100);
            System.out.println("compare/swap operations for counting sorting for 10000 = " + counting_10000);
            System.out.println("compare/swap operations for counting sorting for 1000000 = " + counting_1000000);

            System.out.println("compare/swap operations for quick sorting for 100 = " + quick_100);
            System.out.println("compare/swap operations for quick sorting for 10000 = " + quick_10000);
            System.out.println("compare/swap operations for quick sorting for 1000000 = " + quick_1000000);

            System.out.println("compare/swap operations for merge sorting for 100 = " + merge_100);
            System.out.println("compare/swap operations for merge sorting for 10000 = " + merge_10000);
            System.out.println("compare/swap operations for merge sorting for 1000000 = " + merge_1000000);

            System.out.println("for 100 min operations = " + getMin(counting_100, quick_100, merge_100));
            System.out.println("for 10000 min operations = " + getMin(counting_10000, quick_10000, merge_10000));
            System.out.println("for 1000000 min operations = " + getMin(counting_1000000, quick_1000000, merge_1000000));

    }


    //1. Реализовать сортировку подсчетом.
    private static long countingSorting(int[] array, int limit){
        if (array == null || array.length == 0)  return countOperations;
        if (limit <= 0) return countOperations;
        int[] tmp = new int[limit];
        for (int k = 0; k < array.length; k++){
            tmp[array[k]]++;
            countOperations++;
        }
        int b = 0;
        for (int t = 0; t < tmp.length; t++){
            for (int i = 0; i < tmp[t]; i++){
                array[b++] = t;
                countOperations++;
            }
        }
        return countOperations;
    }


    //2. Реализовать быструю сортировку.
    private static long quickSorting(int[] array, int start, int end){
        if (array == null || array.length == 0)  return countOperations;
        if (start >= end) return countOperations;
        int middle = start + (end - start) / 2;
        int pivot = array[middle];
        int i = start, j = end;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
                countOperations++;
            }
            while (array[j] > pivot) {
                j--;
                countOperations++;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
                countOperations++;
            }
        }
        if (start < j) {
            quickSorting(array, start, j);
        }
        if (end > i) {
            quickSorting(array, i, end);
        }
        return countOperations;
    }

    //3. *Реализовать сортировку слиянием.
    private static long mergeSorting(int[] array, int start, int end) {
        if (array == null || array.length == 0)  return countOperations;
        if (start >= end) return countOperations;
        if (start < end) {
            countOperations++;
            int middle = start + (end - start) / 2;
            mergeSorting(array, start, middle);
            mergeSorting(array, (middle + 1), end);
            merge(array, start, end);
        }
        return countOperations;
    }

    private static void merge(int[] array, int start, int end) {
        int[] tmp = new int[array.length];
        int middle = start + (end - start) / 2;
        for (int i = start; i <= end; i++) {
            tmp[i] = array[i];
            countOperations++;
        }
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= end) {
            if (tmp[i] <= tmp[j]) {
                array[k] = tmp[i];
                i++;
                countOperations++;
            } else {
                array[k] = tmp[j];
                j++;
                countOperations++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tmp[i];
            k++;
            i++;
            countOperations++;
        }

    }

    private static int getRandomIntCustomised(int limit){
        int a, b, tmp;
        int randomNumber = 1;
        for (int i = 0; i < 100; i++){
            b = (int)(System.nanoTime()%10);
            a = (int)(System.nanoTime()%10);
            tmp = (a * randomNumber + b)%limit;
            randomNumber = tmp;
        }
        return randomNumber;
    }

    private static void fillArray(int[] array, int limit){
        if (limit > 0) {
            for (int k = 0; k < limit; k++){
                array[k] = getRandomIntCustomised(limit);
            }
        }
    }

    private static void printArrayByX(int[] array, int start, int step){
        int end = start + step;
        if (end <= array.length) {
            for (int i = start; i < end; i++) {
                System.out.print(array[i] + "  ");
            }
            System.out.println();
            printArrayByX(array, end, step);
        }
    }

    public static void swap (int[] array, int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static long getMin(long x1, long x2, long x3){
        long min = x1;
        if (min > x2) min = x2;
        if (min > x3) min = x3;
        return min;
    }

}

