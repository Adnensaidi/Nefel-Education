//. 1. Creating the pizzaOven Function
function pizzaOven(crustType, sauceType, cheeses, toppings) {
    var pizza = {};
    
    pizza.crustType = crustType; 
    pizza.sauceType = sauceType; 
    pizza.cheeses = cheeses;     
    pizza.toppings = toppings;   
    return pizza;
}

// 2. Making Pizzas

var pizza1 = pizzaOven("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]);
console.log(pizza1);

// 3: Hand-Tossed Veggie Pizza

var pizza2 = pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);
console.log(pizza2);

// 4 Bonus: Random Pizza

var crustTypes = ["deep dish", "hand tossed", "thin crust", "gluten-free"];
var sauceTypes = ["traditional", "marinara", "alfredo", "pesto"];
var cheeseOptions = ["mozzarella", "cheddar", "parmesan", "feta"];
var toppingOptions = ["pepperoni", "sausage", "mushrooms", "olives", "onions", "spinach"];
