import UIKit

print("----------------------------------------------------------------------------");

print("13. * Написать функцию, генерирующую случайное число от 1 до 100.");
print("      a. с использованием стандартной функции rand()\n");

func getRandomInt(start: Int, end: Int) -> Int{
    if (start <= end){
        let randomNumber: Int = Int.random(in: start...end);
        print("Рандомное число от \(start) до \(end) = \(randomNumber)");
        return randomNumber;
    }
    print("Указан некорректный диапазон: \(start) < \(end)");
    return 0;
}

getRandomInt(start: 1, end: 100);
getRandomInt(start: 1, end: 100);
getRandomInt(start: 4, end: 4);
getRandomInt(start: -40, end: -8);
getRandomInt(start: 40, end: 6);

print("----------------------------------------------------------------------------");

print("13. * Написать функцию, генерирующую случайное число от 1 до 100.");
print("      b. без использования стандартной функции rand()\n");

func getRandomIntCustomised() -> Int{
    var a,b,tmp: Int;
    var randomNumber: Int = 1;
    for _ in 1...10 {
        b = Int(mach_absolute_time()%10);
        a = Int(mach_absolute_time()%10);
        tmp = (a * randomNumber + b)%100;
        if (tmp < 0) {
            randomNumber = -1 * tmp + 1;
        } else {
            randomNumber = tmp + 1;
        }
    }
    print("Рандомное число = \(randomNumber)");
    return randomNumber;
}

getRandomIntCustomised();
getRandomIntCustomised();
getRandomIntCustomised();

print("----------------------------------------------------------------------------");

print("1. Ввести вес и рост человека. Рассчитать и вывести индекс массы тела");
print("   по формуле I=m/(h*h); где m-масса тела в килограммах, h - рост в метрах.\n");

func calculateMassIndex(m: Float, h: Float) -> Float {
    if (m <= 0 || h <= 0) {
        print("Ошибка: вес и рост должны быть больше нуля");
        return 0;
    } else {
        let i: Float = m / (h * h);
        print("Индекс массы для веса тела \(m) кг и роста \(h) м равен \(i)");
        return i;
    }
}

let result1 = calculateMassIndex(m: 50, h: 1.65);

print("----------------------------------------------------------------------------");

print("2. Найти максимальное из четырех чисел. Массивы не использовать.\n");

func getMaxInteger(x1: Int, x2: Int, x3: Int, x4: Int) -> Int {
    var max :Int = x1;
    if (x2 > max){
        max = x2;
    }
    if (x3 > max){
        max = x3;
    }
    if (x4 > max){
        max = x4;
    }
    print("Максимальное значение из \(x1), \(x2), \(x3) и \(x4) равно \(max)");
    return max;
}

let result2 = getMaxInteger(x1: getRandomIntCustomised(),
                            x2: getRandomIntCustomised(),
                            x3: getRandomIntCustomised(),
                            x4: getRandomIntCustomised());

print("----------------------------------------------------------------------------");

print("3. Написать программу обмена значениями двух целочисленных переменных:");
print("   a. с использованием третьей переменной\n");

func replaceIntVar1(i1: inout Int, i2: inout Int) -> Void {
    print("До изменения:    i1 = \(i1), i2 = \(i2)");
    let tmp: Int = i1;
    i1 = i2;
    i2 = tmp;
    print("После изменения: i1 = \(i1), i2 = \(i2)");
}

var i1: Int = getRandomIntCustomised();
var i2: Int = getRandomIntCustomised();
replaceIntVar1(i1: &i1, i2: &i2);

print("----------------------------------------------------------------------------");

print("3. Написать программу обмена значениями двух целочисленных переменных:");
print("   b. *без использования третьей переменной.\n");

func replaceIntVar2(i1: inout Int, i2: inout Int) -> Void{
    print("До изменения:    i1 = \(i1), i2 = \(i2)");
    i1 = i1 + i2;
    i2 = i1 - i2;
    i1 = i1 - i2;
    print("После изменения: i1 = \(i1), i2 = \(i2)");
}

replaceIntVar2(i1: &i1, i2: &i2);

print("----------------------------------------------------------------------------");

print("4. Написать программу нахождения корней заданного квадратного уравнения.\n");

func printEquation(a: Int, b: Int, c: Int) -> Void{
    var sign1: Character  = "+";
    var sign2: Character  = "+";
    if (b<0) {
        sign1 = " ";
    }
    if (c<0) {
        sign2 = " ";
    }
    print("Уравнение: \(a)x^2 \(sign1)\(b)x \(sign2)\(c) = 0");
}

func findXforQuadraticEquation(a: Int, b: Int, c: Int) -> Void {
    printEquation(a: a, b: b, c: c);
    if (a == 0){
        if (b == 0){
            if (c == 0){
                print("Решение: любое значение х. Причина: тождество 0 = 0");
            } else {
                print("Решение: нет. Причина: \(c) <> 0");
            }
        } else {
            let x1: Float = Float((-1 * c) / b);
            print("x = \(x1)");
        }
    } else {
        let tmp1: Float = Float((b * b) - (4 * a * c));
        if (tmp1 < 0 ){
            print("Решение: нет. Причина: корень из отрицательного числа");
        } else {
            if (tmp1 == 0) {
                let tmp2: Float = Float(sqrt(tmp1));
                let x2: Float = ((-1 * Float(b)) + tmp2 ) / (2 * Float(a));
                print("Решение: x = \(x2)");
            }
            if (tmp1 > 0) {
                let tmp2: Float = Float(sqrt(tmp1));
                let x3: Float = ((-1 * Float(b)) + tmp2 ) / (2 * Float(a));
                let x4: Float = ((-1 * Float(b)) - tmp2 ) / (2 * Float(a));
                print("Решение: x1 = \(x3), x2 = \(x4)");
            }
        }
    }
}

findXforQuadraticEquation(a: -10, b: 4, c: 6);
print();
findXforQuadraticEquation(a: 0, b: 0, c: 6);
print();
findXforQuadraticEquation(a: 0, b: 0, c: 0);
print();
findXforQuadraticEquation(a: 4, b: -14, c: -30);

print("----------------------------------------------------------------------------");

print("5. С клавиатуры вводится номер месяца. Определить, к какому времени года он относится.\n");

func specifySeason(monthNumber: Int) -> Void {
    if (monthNumber > 0 && monthNumber < 13){
        if (monthNumber <= 2 || monthNumber == 12){
            print("Сейчас зима");
        } else if (monthNumber <= 5) {
            print("Сейчас весна");
        } else if (monthNumber <= 8) {
            print("Сейчас лето");
        } else {
            print("Сейчас осень");
        }
    } else {
        print("Месяц номер \(monthNumber) не существует");
    }
}

specifySeason(monthNumber: 0);
specifySeason(monthNumber: 1);
specifySeason(monthNumber: 2);
specifySeason(monthNumber: 3);
specifySeason(monthNumber: 4);
specifySeason(monthNumber: 5);
specifySeason(monthNumber: 6);
specifySeason(monthNumber: 7);
specifySeason(monthNumber: 8);
specifySeason(monthNumber: 9);
specifySeason(monthNumber: 10);
specifySeason(monthNumber: 11);
specifySeason(monthNumber: 12);
specifySeason(monthNumber: 13);
specifySeason(monthNumber: -5);

print("----------------------------------------------------------------------------");

print("6. Ввести возраст человека (от 1 до 150 лет) и вывести его вместе с «год», «года» или «лет».\n");

func printAge(age: Int) {
    if (age > 0 && age <= 150) {
        let tmp1: Int = age + 10;
        let tmp2: Int = age + 100;
        if (tmp1%10 == 1  && tmp2%100 != 11) {
            print("Возраст = \(age) год");
        } else if ( (tmp1%10 > 1 && tmp1%10 < 5)  && (tmp2%100 < 11 || tmp2%100 > 14)) {
            print("Возраст = \(age) года");
        } else {
            print("Возраст = \(age) лет");
        }
    } else {
        print("Возраст \(age) вне диапазона");
    }
}

for i in 0...151 {
    printAge(age: i);
}

print("----------------------------------------------------------------------------");

print("7. С клавиатуры вводятся числовые координаты двух полей шахматной доски (x1,y1,x2,y2).");
print("   Требуется определить, относятся ли к поля к одному цвету или нет.\n");

func checkChessBoardColour(x1: Int, y1: Int, x2: Int, y2: Int) -> Void {
    if ( x1 < 1 || x1 > 10 || y1 < 1 || y1 > 10) {
        print("Ошибка: координаты первого поля введены неверно");
    } else if (x2 < 1 || x2 > 10 || y2 < 1 || y2 > 10) {
        print("Ошибка: координаты второго поля введены неверно");
    } else {
        let tmp1: Int = (x1 + y1) % 2;
        let tmp2: Int = (x2 + y2) % 2;
        if (tmp1 == 0 && tmp2 == 0) {
            print("Поля \(x1)-\(y1) и \(x2)-\(y2) одного цвета (белые)");
        } else if (tmp1 != 0 && tmp2 != 0) {
            print("Поля \(x1)-\(y1) и \(x2)-\(y2) одного цвета (черные)");
        } else {
            print("Поля \(x1)-\(y1) и \(x2)-\(y2) разного цвета");
        }
    }
}

checkChessBoardColour(x1: 1, y1: 1, x2: 2, y2: 2);
checkChessBoardColour(x1: 3, y1: 4, x2: 1, y2: 6);
checkChessBoardColour(x1: 3, y1: 4, x2: 11, y2: 10);
checkChessBoardColour(x1: 3, y1: 4, x2: 10, y2: 10);

print("----------------------------------------------------------------------------");

print("8. Ввести a и b и вывести квадраты и кубы чисел от a до b.\n");

func expInt(number: Int, degree: Int) -> Int{
    if (degree < 1) {
        return 0;
    }
    var res: Int = 1;
    for _ in 1...degree {
        res = res * number;
    }
    return res;
}


func massExponentiation(a: inout Int, b: inout Int) -> Void {
    if (a > b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }
    for i in a...b {
        print("\(i)^2 = \(expInt(number: i, degree: 2)), \(i)^3 = \(expInt(number: i, degree: 3))");
    }
}

var a: Int = -2;
var b: Int = 6;
massExponentiation(a: &a, b: &b);

print("----------------------------------------------------------------------------");

print("9. Даны целые положительные числа N и K. Используя только операции сложения и вычитания,");
print("   найти частное от деления нацело N на K, а также остаток от этого деления.\n");

func getQuotientAndRemainder(a: Int, b: Int) -> Void{
    if (a <= 0 || b <= 0){
        print("Ошибка: одно из чисел не прошло проверку");
    } else {
        var remainder: Int = a;
        var quotient: Int = 0;
        while (remainder >= b){
            quotient  = quotient + 1;
            remainder = remainder - b;
        }
        print("Частное от деления \(a) на \(b) = \(quotient)");
        print("Остаток от деления \(a) на \(b) = \(remainder)");
    }
}

getQuotientAndRemainder(a: 15, b: 6);

print("----------------------------------------------------------------------------");

print("10. Дано целое число N (> 0). С помощью операций деления нацело и взятия остатка от деления определить,");
print("    имеются ли в записи числа N нечетные цифры. Если имеются, то вывести True, если нет — вывести False.\n");

func isContainOddNumber(n: Int) -> Bool{
    if (n > 0) {
        var temp: Int = n;
        var x: Int;
        while (temp > 0){
            x = temp%10;
            if (x%2 != 0)  {
                return true;
            }
            temp = temp/10;
        }
    } else {
        print("Ошибка: число \(n) меньше нуля");
    }
    return false;
}

var number1: Int = 45;
var number2: Int = 28;
print("Содержит ли \(number1) нечетные цифры ? \(isContainOddNumber(n: number1))");
print("Содержит ли \(number2) нечетные цифры ? \(isContainOddNumber(n: number2))");

print("----------------------------------------------------------------------------");

print("11. С клавиатуры вводятся числа, пока не будет введен 0.");
print("    Подсчитать среднее арифметическое всех положительных четных чисел, оканчивающихся на 8.\n");



func averageSum(numbers: [Int]) -> Void {
    var counter: Int = 0;
    var sum: Int = 0;
    var average: Float = 0;
    for (_,element) in numbers.enumerated() {
        if (element == 0) {
            print("Среднее арифметическое = \(average)");
            return;
        }
        if ((element > 0) && (element%10==8)){
            counter += 1;
            sum = sum + element;
        }
        if (counter > 0) {
            average = Float(sum) / Float(counter);
        }
    }
    print("Среднее арифметическое = \(average)");
}

let myArray: [Int] = [88,-8,24,38,85,8,0,0,58];
averageSum(numbers: myArray);

print("----------------------------------------------------------------------------");

print("12. Написать функцию нахождения максимального из трех чисел.\n");

func getMaxInt(x1: Int, x2: Int, x3: Int) -> Int {
    var max: Int = x1;
    if (x2 > max){
        max = x2;
    }
    if (x3 > max){
        max = x3;
    }
    print("Максимальное значение из \(x1), \(x2) и \(x3) равно \(max)");
    return max;
}

let result12 = getMaxInt(x1: 24, x2: -56, x3: 108);

print("----------------------------------------------------------------------------");

print("14. * Автоморфные числа. Натуральное число называется автоморфным,");
print("      если оно равно последним цифрам своего квадрата.");
print("      Например, 25 :sup: 2 = 625. Напишите программу, которая вводит натуральное число N");
print("      и выводит на экран все автоморфные числа, не превосходящие N.\n");

func getAutomorphicNumber(limit: Int64) -> Void{
    if (limit > 0) {
        var auto, square, tmp: Int64;
        for i in 1...limit {
            square = i * i;
            var counter: Int = 0;
            repeat {
                counter = counter + 1;
                tmp = Int64(expInt(number: 10, degree: counter));
                auto = square % tmp;
            } while (auto < i);
            if (auto == i) {
                print("Автоморфное число = \(auto) [Квадрат: \(Int64(expInt(number: Int(auto), degree: 2)))]");
            }
        }
    } else {
        print("Число не является положительным");
    }
}

getAutomorphicNumber(limit: Int64(Int.random(in: 0...40000)));

