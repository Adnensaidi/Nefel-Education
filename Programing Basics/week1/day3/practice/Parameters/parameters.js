// Level 1: Using what you've learned about functions and parameters, create a function that, given a name, will say "good day" to that person by name.


function greet(name) {
    console.log("Good day " + name + "!");
}
greet("Anakin");

// Level 2: Further customize your function by including the time of day in your greeting. Hint: can functions only take one parameter?
function greet(name, time) {
    console.log("Good " + time + " " + name + "!");
}
greet("Anakin", "morning");

// Level 3: You and Count Dooku are enemies. Further customize your code to say, "I'm coming for you, Dooku!" if your function is called with "Count Dooku".
function greet(name, time) {
    if(name == "Count Dooku") {
        console.log("I'm coming for you, Dooku!");
    } else {
        console.log("Good " + time + " " + name + "!");
    }
}
greet("Anakin", "night");
greet("Count Dooku", "day");