import React, {useState,useEffect} from 'react'
import axios from 'axios'
import CharactersList from './components/CharactersList'
import CharacterDetails from './components/CharacterDetails'
import './App.css'


function App() {
// State to store the list of caracters
const [characters, setCharacters] = useState([])

// State to store the selected character
const [selectedCharachter , setSelectedCharacter]=useState(null)

useEffect(()=>{
  axios.get(' https://rickandmortyapi.com/api/character')
  .then((response) => {
    setCharacters(response.data.results)
    console.log("API response received", response);
  })
  .catch((error) => {
    console.log('Error fetching characters:',error);
  })
}
)

  return (
      <div className='container'>
      <CharactersList characters= {characters} onSelectCharacter= {setSelectedCharacter} />
      {/*  Pass selectedCharacter to CharacterDetails ( Lifting State ) */}
      <CharacterDetails selectedCharachter={selectedCharachter}/>
      </div>
      
  )
}

export default App
