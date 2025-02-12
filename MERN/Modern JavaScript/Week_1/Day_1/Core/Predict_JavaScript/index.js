// Problem 1
const cars = ['Tesla', 'Mercedes', 'Honda']
const [randomCar] = cars
const [, otherRandomCar] = cars

console.log(randomCar);
console.log(otherRandomCar);

// Problem 2
const employee = {
    employeeName: 'Elon',
    age: 47,
    company: 'Tesla'
}
const { employeeName: otherName } = employee;

console.log(otherName);
// console.log(employeeName); // Uncommenting this will cause an error

// Problem 3
const person = {
    name: 'Phil Smith',
    age: 47,
    height: '6 feet'
}
const password = '12345';
const { password: hashedPassword } = person;

console.log(password);
console.log(hashedPassword);

// Problem 4
const numbers = [8, 2, 3, 5, 6, 1, 67, 12, 2];
const [, first] = numbers;
const [,,, second] = numbers;
const [,,,,,,,, third] = numbers;

console.log(first === second);
console.log(first === third);

// Problem 5
const lastTest = {
    key: 'value',
    secondKey: [1, 5, 1, 8, 3, 3]
}
const { key } = lastTest;
const { secondKey } = lastTest;
const [, willThisWork] = secondKey;

console.log(key);
console.log(secondKey);
console.log(secondKey[0]);
console.log(willThisWork);

// Problem 6
var beatles = ['Paul', 'George', 'John', 'Ringo'];
function printNames(names) {
    function actuallyPrintingNames() {
    for (var index = 0; index < names.length; index++) {
        var name = names[index];
        console.log(name + ' was found at index ' + index);
    }
    console.log('name and index after loop is ' + name + ':' + index);
    }
    actuallyPrintingNames();
}
printNames(beatles);

// Problem 7
function actuallyPrintingNames() {
    for (let index = 0; index < names.length; index++) {
    let name = names[index];
    console.log(name + ' was found at index ' + index);
    }
    console.log('name and index after loop is ' + name + ':' + index);
}

// Problem 8
const beatles = ['Paul', 'George', 'John', 'Ringo'];
function printNames(names) {
    function actuallyPrintingNames() {
    for (let index = 0; index < names.length; index++) {
        const name = names[index];
        console.log(name + ' was found at index ' + index);
    }
    }
    actuallyPrintingNames();
}
printNames(beatles);

// Problem 9
const planet = {
	name:"Jupiter",
	milesFromSun: 49849,
	mass: 393983,
	composition: ["gas", "liquid", "oxygen"]
}
const planetCopy = {...planet}

console.log(planet.composition[0] == planetCopy.composition[0]);
console.log(planet = planetCopy);
