console.log("---> JavaScript Arithmetic Operators <---");

console.log("---------------- '+' ----------------")

console.log(10 + 20);   // output: 30
console.log(10 + '20'); // output: 1020
console.log('10' + 20); // output: 1020
console.log('10' + '20'); // output: 1020
console.log(Number.POSITIVE_INFINITY + Number.NEGATIVE_INFINITY); // output: NaN

console.log("---------------- '-' -----------------");

console.log(Number.POSITIVE_INFINITY - Number.NEGATIVE_INFINITY);   // output: Infinity
console.log(Number.POSITIVE_INFINITY - Number.POSITIVE_INFINITY);   // output: NaN
console.log(Number.NEGATIVE_INFINITY - Number.NEGATIVE_INFINITY);   // output: NaN
console.log(10 - 20);       // output: -10
console.log(10 - '20');     // output: -10
console.log('10' - 20);     // output: -10
console.log('10' - '20');   // output: -10

console.log("---------------- '*' -----------------");

console.log(Number.POSITIVE_INFINITY * 10);                         // output: Infinity
console.log(Number.NEGATIVE_INFINITY * 10);                         // output: -Infinity
console.log(Number.POSITIVE_INFINITY * Number.NEGATIVE_INFINITY);   // output: -Infinity
console.log(Number.POSITIVE_INFINITY * -10);                        // output: -Infinity
console.log(Number.NEGATIVE_INFINITY * -10);                        // output: Infinity
console.log(10 * '20');                                             // output: 200
console.log(10 * 20);                                               // output: 200
console.log('20' * 10);                                             // output: 200
console.log('10' * '20');                                           // output: 200

console.log("---------------- '/' -----------------");

console.log(Number.POSITIVE_INFINITY / 10);                         // output: Infinity
console.log(Number.POSITIVE_INFINITY / Number.POSITIVE_INFINITY);   // output: NaN
console.log(Number.POSITIVE_INFINITY / Number.NEGATIVE_INFINITY);   // output: NaN
console.log(Number.NEGATIVE_INFINITY / Number.POSITIVE_INFINITY);   // output: NaN
console.log(Number.NEGATIVE_INFINITY / Number.NEGATIVE_INFINITY);   // output: NaN
console.log(Number.NEGATIVE_INFINITY / (-10));                      // output: Infinity
console.log(0 / 0);                                                 // output: NaN
console.log(10 / 0);                                                // output: Infinity
console.log(10 / 20);                                               // output: 0.5;
console.log(10 / '20');                                             // output: 0.5
console.log('10' / 20);                                             // output: 0.5
console.log('10' / '20');                                           // output: 0.5

console.log("---------------- 'valueOf() method' -----------------");

let num = {
    valueOf() {
        return 250;
    },
};

console.log(num + 50);
console.log(num - 50);
console.log(num * 50);
console.log(num / 50);

// :: All outputs are Normal

console.log("---------------- 'toString() method' -----------------");

let ammount = {
    toString() {
        return 500;
    }
}

console.log(ammount + 100);
console.log(ammount - 100);
console.log(ammount * 100);
console.log(ammount / 100);

// :: All outputs are Normal


console.log("---> JavaScript Remainder Operator <---");

console.log("---------------- '%' -----------------");

console.log(0 % 0);                         // output: NaN
console.log(5 % 0);                         // output: NaN
console.log(5 % 2);                         // output: 1
console.log(5 % -2);                        // output: 1
console.log(-5 % 2);                        // output: -1
console.log(-5 % (-2));                     // output: -1
console.log(Number.POSITIVE_INFINITY % 0);  // output: NaN
console.log(Number.NEGATIVE_INFINITY % 0);  // output: Nan
console.log(0 % Number.POSITIVE_INFINITY);  // output: 0
console.log(0 % Number.NEGATIVE_INFINITY);  // output: 0
console.log(5 % '0');                       // output: NaN
console.log('5' % 0);                       // output: NaN
console.log('5' % '0');                     // output: NaN

function isOdd(num) {
    return num % 2 == 1;
}

console.log(isOdd(5));                      // output: true

const isOddValue = (num) => num % 2 != 0;
console.log(isOddValue(5));                 // output: true