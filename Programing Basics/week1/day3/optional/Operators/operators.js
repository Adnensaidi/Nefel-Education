function howMuchLeftOverCake(numberOfPieces, numberOfPeople) {
    const leftovers = numberOfPieces % numberOfPeople;

    if (leftovers === 0) {
        console.log("No leftovers for you!");
    } else if (leftovers <= 2) {
        console.log("You have some leftovers");
    } else if (leftovers <= 5) {
        console.log("You have leftovers to share");
    } else {
        console.log("Hold another party!");
    }
}

howMuchLeftOverCake(12, 5); 
