import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Pokemon = () => {
    const [pokemon, setPokemon] = useState([]);
    
    useEffect(() => {
        axios.get('https://pokeapi.co/api/v2/pokemon?limit=9')
            .then(response => {
                setPokemon(response.data.results);
            })
            .catch(err => {
                console.log(err);
            });
    }, []);

    return (
        <div>
            <h2 style={{textAlign: 'center', marginBottom: '20px'}}>Pokemon API</h2>
            <div style={{padding: '20px'}}>
                {pokemon.map((poke, index) => (
                    <div key={index} style={{margin: '5px 0', fontSize: '16px'}}>
                        • {poke.name}
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Pokemon;