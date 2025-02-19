import React, { useState } from 'react'

const CharactersList= ({characters  , onSelectCharacter}) => {
    // state To store the number of characters to display 
    const [numCharacters , setNumCharacters]=useState(20)

    // Slice the character array to limit the number of display characters
    const limitedCharacters = characters.slice(0, numCharacters)

    return (
        <div className='col-md-4 p-4 w-50'>
            {/* Input field to allow the user to specify the number of Characters to display */}
            <input 
            type="number"
            placeholder='Number of Characters' 
            className='form-control mb-3'
            value={numCharacters}
            onChange={(e) => setNumCharacters(e.target.value)}/>

            <div className='list-group' style={{maxHeight:'400px', overflow:'scroll', width:'300px'}}>
                {limitedCharacters.map((character)=> (
                    <button key={character.id} 
                    onClick={()=> onSelectCharacter(character)}
                    className='list-group-item list-group-item-action p-3'>
                    <span> {character.name}</span> </button>
                ))}
            </div>
        </div>
    )
}

export default CharactersList