function sayHello() {
    console.log("hello");
}

function say(msg){                  // msg is a parameter
    console.log(msg);
}

function getPIValue() {
    return Math.PI;
}

function greatByName(name) {
    console.log("Hello, " + name);
}

function add(num1, num2) {
    return num1 + num2;
}


sayHello();                         // output: hello
say("Hello world!");                // output: Hello world!
let piValue = getPIValue();         
console.log(piValue);               // output: 3.141592...
greatByName("Nayankumar")           // output: Hello, Nayankumar
let result = add(10, 20);
console.log("Result: " + result);   // output: Result: 30

function addNumbers() {
    let sum = 0;
    for (let index = 0; index < arguments.length; index++) {
        sum += arguments[index];        
    }
    return sum;
}


console.log("Sum: " + addNumbers(10,15,20,25,30));      // output: Sum: 100