let num = 10;

if(num % 2) {
    console.log("Odd Number")
} else {
    console.log("Even Number");
}
// :: output: Even Number

function isEvenOrOdd(num) {
    if(num % 2) {
        return "Number is Odd";
    } else {
        return "Number is Even";
    }
}

console.log(isEvenOrOdd(9)); // output: Number is Odd

let output = (num) => num % 2 ? "Number is Odd" : "Number is Even";     //Arrow function + Ternary Operator

console.log(output(7));     // output: Number is Odd

let authenticated = true;

let msg = authenticated
            ? (alert('You will redirected to main area'), '/admin')
            : (alert('Access Denied'), '403"');

console.log(msg);   // pop-up the alert msg: you will redirected to main area