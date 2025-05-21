let arr = "Nayankumar".split("");

let right = arr.length - 1, left = 0;

while (left < right) {
    let temp = arr[left];
    arr[left++] = arr[right];
    arr[right--] = temp;
}

console.log(arr.join("")); // ramuknayaN

let num = 21;

for (let index = 2; index <= Math.sqrt(num); index++) {
    console.log("Diviser num: " + index);          // print 2 times for 2 and 3
    if(num % index == 0){
        console.log("Number is Not prime Number");
        break;
    }
}

let i = 0;
while(i <= 10){
    if(i == 5) {
        i++;
        continue;
    }
    console.log(i++);
}

// output: 0 - 4 skip 5 and then 6 - 10

let value = 7;

do {
    console.log(value);     // output: 7 becz do-while is firstly doand then check the condition even condition is false then also run one's.
} while (value > 7);

let array = [10, 2, 19, 15, 20, 22];
let target = 22;

for (let i = 0; i < array.length - 1; i++) {
    for (let j = i + 1; j < array.length; j++) {
        if (array[i] + array[j] === target) {
            console.log(`Found: ${array[i]} + ${array[j]} = ${target}`);
        }
    }
}