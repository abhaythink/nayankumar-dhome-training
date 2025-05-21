let id; // Decler a Variable
console.log(id); // output: 'undefined' becz the value is not assign to variable
id = 101; // assign a vale in different line
console.log(id);

let myAge = 24; // decleration and assign value in single line
console.log(myAge);

const DOB = "22/06/2001"; // const is used for constant variables if you assign a value then it can not be change
console.log(DOB);

// DOB = "02/09/2001"; // Uncaught TypeError: Assignment to constant variable.

var a = 10;
var a = 20;  // in var the re-decleration allowed

function testVarLet() {
    if(true){
        var c = 50;     // scope: Throughout the function
        let d = 500;    // scope: Troughout the block
        console.log(c); // output: 50
        console.log(d); // output: 500
    }
    console.log(c); // output: 50
    // console.log(d);  // Uncaught ReferenceError ReferenceError: d is not defined becz its not in the scope
};
testVarLet();

console.log("\n----> Data Types<----");
// Primitive Data types in JS
// null, undefined, boolean, number, string, symbol, bigint

let isPrime = true;
console.log(typeof(isPrime));  // type of use for finding which type of dat it's conating --- output: boolean

console.log(typeof(id));  // output: number

console.log(typeof(DOB));  // output: string

let myName;
console.log(typeof myName) // output: undefined

let mobileNumber = 7898455621;
console.log(typeof(mobileNumber));

let obj = null;
console.log(typeof(obj));  // output: object -- trhis is a null type but its a bug in JavaScript
console.log(obj == undefined);  // null == undefined

let orderAmmount = 150.25;
let numberOfItems = 20;
console.log(typeof(orderAmmount) == typeof(numberOfItems));  // becz is JS the floating numbers and Integers has same data type which is a 'number'

let price = 170.00; // interpreted as an integer 170 --becz JavaScript automatically converts a floating-point number into an integer if the number appears to be a whole number.

console.log(Number.MAX_VALUE); // output: some big Number it near to Infinity
console.log(Number.MIN_VALUE); // output: small Number near to Zero but Not a Zero wich greater than Zero becz: consloe.log(Number.MIN_VALUE - Number.MIN_VALUE) is 0 Actualy Number is 0.0---324times zeros and then 5.

console.log(Number.POSITIVE_INFINITY); // output: Infinity
console.log(Number.NEGATIVE_INFINITY); // output: -Infinity

console.log(Number.MAX_VALUE + Number.MAX_VALUE); //output: Infinity
console.log(-Number.MIN_VALUE - Number.MIN_VALUE); //output: some small

console.log(Number.MIN_VALUE + 10000000); // output: 10000000 becz we add this value is vary samll number so that small number is can not detected in here

console.log('a'/10); // output: NaN this means Not a Number

console.log(NaN + 100); // output: NaN --becz NaN with and Operater output should be NaN except: NaN == NaN this gives false

console.log(NaN == NaN); // output: false --becz NaN is not equal to anybody even if self also

console.log(typeof(Number.MAX_VALUE)); // Number

let msg = 'Hi';
let resMsg = "Hello"; // Both msg and resMes as known as String literal and you can create string literal both the way like in single and double quote

console.log('I\'m Nayankumar Dhome'); // This is how we use escape character

let nm  = "Nayankumar";
nm[0] = 'n';
console.log(nm);

console.log(Boolean('Hi')); //output: true becz its not a non empty
console.log(Boolean('')); // output: false becz its a empty string

console.log(Boolean(undefined)); // output: false
console.log(Boolean(NaN));      // output: false

console.log(Boolean(0)); // output: false becz its zero
console.log(Boolean(Number.MAX_VALUE)); // output: true becz its zon-zero value
console.log(Boolean(Number.NEGATIVE_INFINITY)); // output: true becz its no-zero value

console.log(Boolean({eid: id}));        // output: true becz non-empty object

console.log(Boolean(Symbol())); // output: true

console.log(Boolean(2048n)); // output: true

let sy = Symbol();
console.log(sy);
let s = Symbol();
console.log(s);

console.log(sy == s); // output: false becz Symbol generate new Symbol every time;

console.log(Symbol('discription'));

let bint = 1024n;
console.log(typeof(bint)); // output: bigint
let num = BigInt(123);  // Both the way we can cerate bigint
console.log(num);

let employee = {
    eid: 101,
    name: 'Nayankumar Dhome',
    salary: 3
};

console.log(employee); // output: {eid: 101, name: 'Nayankumar Dhome', salary: 3}
console.log(employee.name);
console.log(employee['eid']);
console.log(employee.age); // output: undefined becz entity does not contain age attribute/key

let unNamed = {}
console.log(unNamed); // // output: {}

console.log(Boolean(employee)); // output: true becz it non-empty object
console.log(Boolean(unNamed)); // output: true becz it also non-empty object

console.log(Boolean({})); // output: true becz its also a non-empty object