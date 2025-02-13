const pokemon = Object.freeze([
    { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
    { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
    { "id": 9,   "name": "Blastoise",  "types": ["water"] },
    { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
    { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
    { "id": 23,  "name": "Ekans",      "types": ["poison"] },
    { "id": 24,  "name": "Arbok",      "types": ["poison"] },
    { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
    { "id": 35,  "name": "Clefairy",   "types": ["normal"] },
    { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
    { "id": 52,  "name": "Meowth",     "types": ["normal"] },
    { "id": 63,  "name": "Abra",       "types": ["psychic"] },
    { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
    { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
    { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
    { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
    { "id": 98,  "name": "Krabby",     "types": ["water"] },
    { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
    { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
    { "id": 133, "name": "Eevee",      "types": ["normal"] },
    { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
    { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
    { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
    { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
]);

// 1. Pokemon with ids divisible by 3
const divisibleBy3 = pokemon.filter(p => p.id % 3 === 0);
console.log("Pokemon with IDs divisible by 3:", divisibleBy3);

// 2. Fire type Pokemon
const fireTypes = pokemon.filter(p => p.types.includes("fire"));
console.log("Fire type Pokemon:", fireTypes);

// 3. Pokemon with multiple types
const multipleTypes = pokemon.filter(p => p.types.length > 1);
console.log("Pokemon with multiple types:", multipleTypes);

// 4. Just the names of all Pokemon
const pokemonNames = pokemon.map(p => p.name);
console.log("All Pokemon names:", pokemonNames);

// 5. Names of Pokemon with id > 99
const highIdNames = pokemon.filter(p => p.id > 99).map(p => p.name);
console.log("Names of Pokemon with ID > 99:", highIdNames);

// 6. Names of Pokemon whose only type is poison
const poisonOnly = pokemon
    .filter(p => p.types.length === 1 && p.types[0] === "poison")
    .map(p => p.name);
console.log("Pokemon with only poison type:", poisonOnly);

// 7. First type of Pokemon whose second type is flying
const firstTypeFlying = pokemon
    .filter(p => p.types[1] === "flying")
    .map(p => p.types[0]);
console.log("First types of Pokemon with flying as second type:", firstTypeFlying);

// 8. Count of normal type Pokemon
const normalCount = pokemon
    .filter(p => p.types.includes("normal"))
    .length;
console.log("Number of normal type Pokemon:", normalCount);

// 9. All Pokemon except id 148
const excludeDragonair = pokemon.filter(p => p.id !== 148);
console.log("All Pokemon except Dragonair:", excludeDragonair);

// 10. Replace "normal" with "fairy" for Pokemon id 35
const updatedPokemon = pokemon.map(p => {
    if (p.id === 35) {
        return {
            ...p,
            types: p.types.map(type => type === "normal" ? "fairy" : type)
        };
    }
    return p;
});
console.log("Updated Pokemon list with Clefairy as fairy type:", updatedPokemon);