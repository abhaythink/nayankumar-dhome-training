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

// functions in variables

console.log("---||----------------------|> functions in variables <|----------------------||---");

function add(num1, num2) {
    return num1 + num2;
}

let sum = add;  // We can assign function to another variable then that variable also treated as a function
// when we assign it we not use ().

let resultValue = sum(5, 15);
console.log(resultValue);    // output: 20


console.log("---||----------------------|> function to another function <|----------------------||---");

// We can pass funtion as a argument to another funtion and it can use inside it.

function sumOfSquare(num1, num2, fn) {
    return fn(num1, num2) * fn(num1, num2);
}

let sqOfSum = sumOfSquare(10, 5, sum);
console.log(sqOfSum);   // output: 225

console.log("---||----------------------|> function to another function <|----------------------||---");

// We can write funtion inside another funtion and from that we return it
// Also called 'higher-order function'

function comparedBy(propertyName, desending = false) {
    return function(obj1, obj2) {
        let x = obj1[propertyName],
        y = obj2[propertyName];

        if(x > y) return desending ? -1 : 1;
        if(x < y) return desending ? 1 : -1;
        return 0;
    }
}

let team = [
    {id: 101, name: 'Nayankumar', salary: 3},
    {id: 205, name: 'Vikas', salary: 4.5},
    {id: 407, name: 'Ramesh', salary: 2.7}
];

team.sort(comparedBy('salary', true));

console.table(team);

team.sort(comparedBy('name', true));

console.table(team);

let salarySorted = [...team].sort(comparedBy('salary', true));          // [...team] :: [...] is uded for creates a shallow copy becz .sort() funtion operates on main array so we shold make the copy of it so original array should not affecte from this 
console.log("Sorted team by salary: ");
console.table(salarySorted);

let nameSorted = [...team].sort(comparedBy('name', true));
console.log("Sorded team by name: ");
console.table(nameSorted);

let biNum = numricConverter(intToBinary, 1000);             // we can invoke Higher order functions before initilization
console.log(biNum);

let intNum = numricConverter(binaryToInt, 101);             // we can invoke Higher order functions before initilization
console.log(intNum);

function binaryToInt(bi) {
    return parseInt(bi,2);
}

function intToBinary(num) {
    return num.toString(2);
}

function numricConverter(fn, value) {
    return fn(value);
}




console.log("---||----------------------|> JavaScript anonymous functions <|----------------------||---");

// Anonymous function is function without name
// An anonymous function never invoke after intialization so we should assing the variable to it

// let sqr = square(5);         // We can not invoke anonymous fnction before initialization

let square = function (num) {
    return num * num;
}

let sqr = square(5);
console.log(sqr);       // output: 25

let user = {
    id: 101,
    username: 'nayankumar_dhome',
    password: 'Pass@123'
};

setTimeout(function (user){
    console.log(`Welcome ${user.username}`)
}, 1000, user);              // Execute this function after 1 sec

(function () {
    console.log("Hello!");
})();                       // Immediately invoked anonymous function

(function () {
    console.log(`Hello ${user.username}`);
})(user);


console.log("---||----------------------|> Arrow functions <|----------------------||---");

// arrow();     // we can not invoke arrow functon before intialization

let arrow = () => console.log("This is Arraw function");

arrow();

console.log("---||----------------------|> recursive function <|----------------------||---");

// Recursive function means the funtion calling it self.
// Recursive function always have a condition for when get terminet becz withot that codition they calling it self infinitly

let factorialVal = factorial(5);
console.log(factorialVal);        // output: 120

function factorial (num) {
    if(num == 1 || num == 0) {
        return 1;
    }
    return num * factorial(num - 1);
}

let factorialValue = factorial(5);
console.log(factorialValue);        // output: 120
