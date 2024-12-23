// Print odds 1-20

for (var i = 1; i < 21; i++) {
    if (i % 2 !== 0) {
        console.log(i);
    }
}


// Decreasing Multiples of 3
for (var i = 100; i >= 0; i--) {
    if (i % 3 === 0) {
        console.log(i);
    }
}

// Print the sequence
for (var i = 4; i >= -3.5; i -= 1.5) {
    console.log(i);
}


//Sigma 
var s = 0;
for (var i = 1; i <= 100; i++) {
    s += i; 
}
console.log(s);

// Factorial

var s = 1; 
for (var i = 1; i <= 12; i++) { 
    s *= i; 
    }
    console.log(s);