import React from 'react'

const CharacterDetails = ({selectedCharachter}) => {
    // if no character is selected, display a message 
    if (!selectedCharachter) {
        return <p className='card p-4 text-center'>Select a character to see details</p>
    }
    return (
        // Display the details of the selected character 

        <div className='card h-100 w-100'>
            <img src={selectedCharachter.image} alt={selectedCharachter.name} />
            <div className='card-body text-center'>
                <h4 className='font-weight-bold mb3'>{selectedCharachter.name}</h4>
            </div>
        </div>
    )
}

export default CharacterDetails