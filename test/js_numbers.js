let num = 0o61; // 0o use for Octal(base 8) numbers that contains 0 - 7 numbers
console.log(num); // output: 49

let num2 = 0x2f; // 0x use for Hexadacimal(base 16) numbers that contains 0 - 9 and a throgh f
console.log(num2); // output: 47

let discount = 19.99;
let price = 208.15;
let diffrence = .08; // alowed but not recommended

let pi = 3.14e7 // when we have small big or large big number use e-nottation e repreent 10 and after that number is represented the power of the 10 and multiply to the begaining value
console.log(pi); // output: 31400000

let bint = 789456123n;
let bin = BigInt(100025); // Both the way we can create BigInt value
console.log(bint);
console.log(bin);

let bigAmmount = 10_000_000_000; // '_' is used for Numeric Separator
console.log(bigAmmount);