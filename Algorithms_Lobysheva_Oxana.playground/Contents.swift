import UIKit

var array_base: [Int] = [9, 23, 0, 2, 3, -8, 1, 14, -12, 0]
var array_base_sorted: [Int] = [-12, -8, 0, 0, 1, 2, 3, 9, 14, 23]

var array_base_big: [Int] = []

for _ in 0...2000 {
    array_base_big.append(Int.random(in: -100...100))
}

print("\n----------------------------------------------------------------------------");

print("\n1. Попробовать оптимизировать пузырьковую сортировку.");
print("   Сравнить количество операций сравнения оптимизированной и не оптимизированной программы. ");
print("   Написать функции сортировки, которые возвращают количество операций.\n");

func bubbleSort(array: inout [Int]) -> Int {
    var countCompareOperations: Int = 0
    var countSwapOperations: Int = 0
    for i in 0..<array.count {
        for k in 0..<(array.count - 1) {
            countCompareOperations += 1
            if array[i] < array[k] {
                countSwapOperations += 1
                let tmp: Int = array[i]
                array[i] = array[k]
                array[k] = tmp
            }
        }
    }
    print("countCompareOperations = \(countCompareOperations) countSwapOperations = \(countSwapOperations)")
    return countCompareOperations + countSwapOperations
}

func bubbleSortOptimized(array: inout [Int]) -> Int {
    var countCompareOperations: Int = 0
    var countSwapOperations: Int = 0
    for i in 0..<array.count {
        for k in 0..<(array.count - 1 - i) {
            countCompareOperations += 1
            if array[k] > array[k + 1] {
                countSwapOperations += 1
                let tmp: Int = array[k]
                array[k] = array[k + 1]
                array[k + 1] = tmp
            }
        }
    }
    print("countCompareOperations = \(countCompareOperations) countSwapOperations = \(countSwapOperations)")
    return countCompareOperations + countSwapOperations
}


var array1: [Int] = array_base
print("array: \(array1)")
print("total for bubleSort = \(bubbleSort(array: &array1)) \n")
print("result: \(array1) \n")

var array2: [Int] = array_base
print("array: \(array2)")
print("total for bubleSortOptimized = \(bubbleSortOptimized(array: &array2)) \n")
print("result: \(array2) \n")


print("\n----------------------------------------------------------------------------");

print("\n2. *Реализовать шейкерную сортировку.\n");

func coctailSort(array: inout [Int]) -> Int {
    var countCompareOperations: Int = 0
    var countSwapOperations: Int = 0
    var stepLeft: Int = 0
    var stepRight: Int = array.count-1
    repeat {
        for i in stride(from: stepLeft, to: stepRight, by: 1) {
            countCompareOperations += 1
            if array[i] > array[i + 1] {
               countSwapOperations += 1
               let tmp: Int = array[i]
               array[i] = array[i + 1]
               array[i + 1] = tmp
            }
        }
        stepRight -= 1
        for k in stride(from: stepRight, to: stepLeft, by: -1) {
            countCompareOperations += 1
            if array[k] < array[k - 1] {
               countSwapOperations += 1
               let tmp = array[k]
               array[k] = array[k - 1]
               array[k - 1] = tmp
            }
        }
        stepLeft += 1
    } while (stepLeft < stepRight)
    print("countCompareOperations = \(countCompareOperations) countSwapOperations = \(countSwapOperations)")
    return countCompareOperations + countSwapOperations
}

var array3: [Int] = array_base
print("array: \(array3)")
print("total for coctailSort = \(coctailSort(array: &array3)) \n")
print("result: \(array3) \n")

print("\n----------------------------------------------------------------------------");

print("\n3. Реализовать бинарный алгоритм поиска в виде функции, которой передается отсортированный массив.");
print("   Функция возвращает индекс найденного элемента или -1, если элемент не найден.\n");

func binarySearch(array: inout [Int], item: Int) -> Int {
    var start: Int = 0
    var end: Int = array.count - 1
    var i: Int = (start + end) / 2
    while ((array[i] != item) && (start <= end)) {
        if (array[i] > item) {
            end = i - 1
        } else {
            start = i + 1
        }
        i = (start + end) / 2
    }
    if (start <= end) {
        return i
    }
    return -1
}

var array4: [Int] = array_base_sorted
print("array: \(array4)")
print("index of 15 (not in array) = \(binarySearch(array: &array4, item: 15))")

for element in array_base {
    print("index of \(element) = \(binarySearch(array: &array4, item: element))");
}

print("\n----------------------------------------------------------------------------");

let st: Int = Int(pow(Double(array_base_big.count),2))
print("O(N^2): \(st)")

var arraybig_1: [Int] = array_base_big
let bubleSort: Int = bubbleSort(array: &arraybig_1)
print("bubleSort = \(bubleSort)")
print("bubleSort - O(N^2) = \(bubleSort - st)")
print("% = \(((bubleSort - st)*100)/st) %\n")

var arraybig_2: [Int] = array_base_big
let bubbleSortOpt: Int = bubbleSortOptimized(array: &arraybig_2)
print("bubbleSortOptimized = \(bubbleSortOpt)")
print("bubbleSortOptimized - O(N^2) = \(bubbleSortOpt - st)")
print("% = \(((bubbleSortOpt - st)*100)/st) %\n")

var arraybig_3: [Int] = array_base_big
let coctailS: Int = coctailSort(array: &arraybig_3)
print("coctailSort = \(coctailS)")
print("coctailSort - O(N^2) = \(coctailS - st)")
print("% = \(((coctailS - st)*100)/st) %\n")
