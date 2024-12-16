// the rider must be at least 42 inches to ride 
const height = int(input("enter your height"))
// the rider must be older than 10 years to ride 
const age = int(input("enter your age "))

1-
if (height >= 42) {
    console.log("get that ride kiddo!")
} else{
    console.log("Sorry kiddo. Maybe next year")
}

2-
if (height >= 42 && age >= 10) {
    console.log("get that ride kiddo!")
} else{
    console.log("Sorry kiddo. Maybe next year")
}

3-
if (height >= 42 || age >= 10) {
    console.log("get that ride kiddo!")
} else{
    console.log("Sorry kiddo. Maybe next year")
}