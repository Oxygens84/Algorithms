import UIKit

func print(map: [[Int]]) {
    for i in 0..<map.count {
        print("\(map[i]) ")
    }
    print("\n");
}

var map: [[Int]] = [
    [1, 1, 1],
    [1, 1, 1, 1],
    [0, 1, 1, 0],
    [1, 0, 1, 1],
    [1, 1, 1, 1]
];

var char_1: [Character] = ["G", "E", "E", "K", "M", "I", "N", "D", "S"];
var char_2: [Character] = ["G", "E", "E", "K", "B", "R", "A", "I", "N", "S"];


print("\n----------------------------------------------------------------------------");

print("\n1. *Количество маршрутов с препятствиями. Реализовать чтение массива");
print("   с препятствием и нахождение количество маршрутов.\n");

func getPathWithBarrier(map: inout [[Int]]) -> Void {
    print(map: map);
    for i in 1..<map.count {
        for k in 1..<map[i].count {
            if map[i][k] != 0 {
                if map[i - 1].count > k {
                    map[i][k] = map[i - 1][k] + map[i][k - 1];
                } else {
                    map[i][k] = map[i][k - 1];
                }
            }
        }
    }
    print(map: map);
    let last: Int = map[map.count - 1].count;
    print("paths with barriers = \(map[map.count - 1][last - 1])");
}

getPathWithBarrier(map: &map);

print("\n----------------------------------------------------------------------------");

print("\n2. Решить задачу о нахождении длины максимальной последовательности с помощью матрицы.\n");


func getLongestSubsequence(_ char_1: [Character], _ char_2: [Character]) {
    print(char_1)
    print(char_2)
    var matrix: [[Int]] = Array(repeating: Array(repeating: 0, count: (char_2.count)), count: (char_1.count))
    for i in 0..<(char_1.count){
        for k in 0..<(char_2.count){
            if (i == 0 || k == 0){
                if char_1[i] == char_2[k] {
                  matrix[i][k] = 1;
                }
            } else {
                if (char_1[i-1] == char_2[k-1]) {
                    matrix[i][k] = 1 + matrix[i - 1][k - 1];
                } else {
                    matrix[i][k] = max(matrix[i - 1][k], matrix[i][k - 1]);
                }
            }
        }
    }
    print(map: matrix)
    print("longest common subsequence = \(matrix[char_1.count-1][char_2.count-1])");
}

getLongestSubsequence(char_1, char_2);


print("\n----------------------------------------------------------------------------");
