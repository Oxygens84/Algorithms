
print("\n----------------------------------------------------------------------------")

print("\n1. Реализовать простейшую хэш-функцию. На вход функции подается строка, на выходе сумма кодов символов.\n")

func hashFunction(_ input: String) -> String{
    var output: String = ""
    let array: [UInt8] = Array(input.utf8)
    for i in 0..<array.count {
        var param: Int = i
        output += String(array[i]) + addChars(&param)
    }
    return output
}

func addChars(_ k: inout Int) -> String{
    var res: String = ""
    let chars: [Character] = [
        "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" ,
        "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" ,
        "s" , "t" , "u" , "v" , "w" , "x" , "y" , "z"
    ]
    repeat {
        if k < chars.count {
            res += String(chars[k])
        }
        k -= chars.count
    } while (k > 0)
    return res
}

let input: String = "qwerty12345"
print("\(input) => \(hashFunction(input))")
