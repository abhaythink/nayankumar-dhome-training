console.log("---||----------------------|> Javascript Object Methods <|----------------------||---");

// Do not use Arrow function inside the obj when work with 'this' key word becz the arrow function is not invoke on any obj its find the obj inside the scope so that result may be diffrent

let person = {
    id: 101,
    firstname: 'Nayankumar',
    lastname: 'Dhome',
    age: 24,
    fullName : function () {                                // Standard Function Expression
        console.log(this.firstname + " " + this.lastname);
    },
    fullName() {                                            //  Shorthand Method Definition
        console.log(this.firstname + " " + this.lastname);
    }
};
person.greet = function () {
    console.log(`Hello! ${this.firstname}`);
}

person.greet();

person.fullName();

console.log(Object.keys(person));       // output: id, firstname, lastname, age, greet  :: greet also consider as a key of the obj
console.log(Object.values(person));     // output: 101, Nayankumar, Dhome, 24, f, f
console.log(Object.entries(person));    // output: this gives key value pair data of person object

let persn = {
    id: 501,
    firstname: 'Nayankumar',
    lastname: 'Dhome',
    age: 25,
    bloodGroup: 'o+'
}

let cpPerson = Object.assign(person, persn);
console.log(cpPerson);                  // Modifiy the original 'person' obj and return the modified person obj
console.log(person);                    // Modified Person obj

// function Student(rollNo, name, marks, attendace) {
//     this.rollNo = rollNo;
//     this.name = name;
//     this.marks = marks;
//     this.attendace = attendace;
// }

// from ES2015 this is best practices to create constructor
class Student {

    constructor(rollNo, name, marks, attendace) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.attendace = attendace;
    }

}

let student1 = new Student(33,'Nayankumar', 75, 89);
let student2 = new Student(273, 'Rohit', 85, 85);
let student3 = new Student(274, 'Nayan', 87, 78);

let groupTeam = [student1, student2, student3];

for(const {rollNo, name, marks, attendace} of groupTeam) {
    console.log(rollNo + " " + name + " " + marks + " " + attendace);
}

console.log("---||----------------------|> JavaScript Prototype <|----------------------||---");

class Animal {
    constructor(name) {
        this.name = name;
    }

    speak() {
        console.log(`${this.name} is make sound.`);
    }
}

class Dog extends Animal {
    constructor(name) {
        super(name);
    }
    walk() {
        console.log(`${this.name} is walking.`);
    }
}

let dog = new Dog("Buddy");
dog.speak();
dog.walk();

console.log(Object.getPrototypeOf(Dog.prototype) === Animal.prototype);                           // true
console.log(Object.getPrototypeOf(Animal.prototype) === Object.prototype);                        // true
console.log(Object.getPrototypeOf(Object.prototype) === null);                                    // true
console.log(Object.getPrototypeOf(Dog.prototype) === Object.getPrototypeOf(Object.prototype));    // false

for(const property in student1) {
    console.log(property + ": " + student1[property]);
}

class Employee {
    constructor(id, name, salary, city, country, pinCode) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = {
            city: city,
            country: country,
            pinCode: pinCode
        };
    }
}

let emp = new Employee(101, 'Nayan', 3.5, 'Pune', 'India', 411041);
console.log("Employee: ")
for(const prop in emp) {
    if(prop === 'address') {
        console.log(prop + ": ");
        for (const addressProp in emp[prop]) {
            console.log("  " + addressProp + ": " + emp[prop][addressProp]);
        }
    } else {
        console.log(prop + ": " + emp[prop]);
    }
}


class Car {

    static count = 0;

    #id;                                                        // # makes the property/methods private
    #name;
    #price;

    constructor(id, name, price) {
        this.#id = id;
        this.#name = name;
        this.#price = price;
        console.log(new.target.name);
        Car.count++;    // or this.constructor.count++;
    }

    get id() {
        return this.#id;
    }

    set id(id) {
        this.#id = id;
    }

    get name() {
        return this.#name;
    }

    set name(name) {
        if(name !== '') {
            this.#name = name;
        } else {
            throw new Error("Invalid name");
        }
    }

    get price() {
        return this.#price;
    }

    set price(price) {
        if(price >= 1000000) {
            this.#price = price;
        } else {
            throw new Error("Invalid price");
        }
    }

    static count() {
        return this.count;
    }
}

let car = new Car('C1-001', 'Toyota', 2000000);
console.log("Initial car:", car);

car.id = 'C1-501';
console.log("Updated car:", car);

try {
    car.name = '';                  // Not - Valid throws the error
} catch (err) {
    console.error(err.message);
}

console.log("Updated car:", car);

console.log(Car.count);