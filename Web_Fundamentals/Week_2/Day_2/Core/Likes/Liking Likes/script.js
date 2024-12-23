console.log("JavaScript is connected");

let numCount = 0; 
let count = document.querySelector('.count');

function addLike() {
    numCount++;
    count.innerText = `${numCount} like(s)`; 
}
