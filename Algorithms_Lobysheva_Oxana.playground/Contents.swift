import UIKit

print("\n----------------------------------------------------------------------------");

print("1. Реализовать функцию перевода из 10 системы в двоичную используя рекурсию.\n");

func translateFromDecimalIntoBinary(number: Int) -> String {
    var result: String = "";
    if(number > 0){
        result = translateFromDecimalIntoBinary(number: number/2) + String(number%2);
    }
    return result;
}


print("241 в двоичной системе: \(translateFromDecimalIntoBinary(number: 241))");

print("\n----------------------------------------------------------------------------");

print("2. Реализовать функцию возведения числа a в степень b: без рекурсии\n");

func exponent(number: inout Float, degree: inout Int) -> Void{
    var result: Float;
    if (degree < 0) {
        number = 1 / number;
        degree = -1 * degree;
    }
    if (degree == 0) {
        result = 0;
    } else {
        result = number;
    }
    for _ in 1...(degree-1){
        result = result * number;
    }
    print("result \(number)^\(degree) = \(result)");
}

var myNumber: Float = 50
var needDegree: Int = 3
exponent(number: &myNumber, degree: &needDegree);

print("\n----------------------------------------------------------------------------");

print("2. Реализовать функцию возведения числа a в степень b: рекурсивно\n");

func exponentR(number: inout Float, degree: inout Int) -> Float{
    if (degree == 0) {
        return 0;
    }
    var result: Float;
    if (degree < 0){
        number = 1 / number;
        degree = -1 * degree;
    }
    result = number;
    if (degree > 1) {
        result = result * exponentR(number: &number, degree: &degree);
    }
    return result;
}

exponent(number: &myNumber, degree: &needDegree);


print("\n----------------------------------------------------------------------------");
