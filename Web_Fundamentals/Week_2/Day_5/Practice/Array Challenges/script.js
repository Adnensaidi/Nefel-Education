// 1) Always Hungry

function alwaysHungry(arr) {
    let foundFood = false; 

    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === "food") { 
            console.log("yummy"); 
            foundFood = true;    
        }
    }

    if (!foundFood) { 
        console.log("I'm hungry"); 
    }
}


// 2) High Pass Filter


function highPass(arr, cutoff) {
    var filteredArr = [];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > cutoff) {
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}

var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // [6, 8, 10, 9]


// 3) Better than average
function betterThanAverage(arr) {
    var sum = 0;
    for (var i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    var average = sum / arr.length;
    var count = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > average) {
            count++;
        }
    }
    return count;
}

var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); // 4

// 4) Array Reverse

function reverse(arr) {
    for (var i = 0; i < arr.length / 2; i++) {
        var temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
    }
    return arr;
}

var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); // ["e", "d", "c", "b", "a"]

// 5) Fibonacci Array

function fibonacciArray(n) {
    var fibArr = [0, 1];
    for (var i = 2; i < n; i++) {
        fibArr.push(fibArr[i - 1] + fibArr[i - 2]);
    }
    return fibArr;
}

var result = fibonacciArray(10);
console.log(result); // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]





