console.log("JavaScript is connected");

let numCounts = [9, 12, 9]; 
let counts = document.querySelectorAll('.count');

function addLike(index) {
    numCounts[index]++;
    counts[index].innerText = numCounts[index] + " like(s)";
}