// Problem 1: Age Check
const checkAge = (age) => {
    return age >= 18 ? "You are good to go!" : "Sorry! You must be 18 or older!"
}
console.log(checkAge(20)); // Output: You are good to go!
console.log(checkAge(16)); // Output: Sorry! You must be 18 or older!

// Problem 2: Rain Check
const checkRain = (isRaining) => {
    return isRaining ? "Get your rain jacket!" : "No rain on today's forecast!"
}
console.log(checkRain(true)); // Output: Get your rain jacket!
console.log(checkRain(false)); // Output: No rain on today's forecast!

// Problem 3: Even Number Check
const checkEven = (number) => {
    return number % 2 === 0 ? "That's an even number!" : "That's an odd number!"
}
console.log(checkEven(4)); // Output: That's an even number!
console.log(checkEven(7)); // Output: That's an odd number!

// Problem 4: Number Comparison
const compareNumbers = (num1, num2) => {
    return num1 > num2 
        ? `${num1} is more than ${num2}!` 
        : `${num1} is less than ${num2}!`
}
console.log(compareNumbers(10, 5)); // Output: 10 is more than 5!
console.log(compareNumbers(3, 8)); // Output: 3 is less than 8!