let arr1 = new Array();
console.log(arr1);  // output: []
arr1.push(10);   // [] ---> [10]            :: Adding from ending
arr1.unshift(5); // [10] ---> [5, 10]       :: Adding from starting

console.log(arr1); // output: [5, 10]

console.log("||------------------||--------------------||");

let arr2 = Array();
console.log(arr2); // output: []
arr2.push(50);      // [] ---> [50]
arr2.unshift(25);  // [50] ---> [25, 50]
console.log(arr2);

console.log("||------------------||--------------------||");

let httpStatusCodeRanges = ['200-299', '300-399', '400-499', '500-599'];
console.log(httpStatusCodeRanges);        // output: ['200-299', '300-399', '400-499', '500-599']
console.log(httpStatusCodeRanges.shift()); // output: 200-299            :: ['200-299', '300-399', '400-499', '500-599']  ---> ['300-399', '400-499', '500-599']   :: Removing from starting
console.log(httpStatusCodeRanges.pop());   // output: 500-599            :: ['300-399', '400-499', '500-599']  ---> ['300-399', '400-499']                         :: Removing from ending
console.log(httpStatusCodeRanges);         // output: ['300-399', '400-499']