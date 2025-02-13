import { useState } from 'react';

const PersonCard = (props) => {
    const {firstName, lastName, age, hairColor} = props;
    const [personAge, setPersonAge] = useState(age)

    return(
        <div className="personCard">
            <h3>{lastName}, {firstName}</h3>
            <p>Age: {personAge}</p>
            <p>Hair Color: {hairColor}</p>
            <button onClick={()=>setPersonAge(personAge+1)}>Birthday{firstName} {lastName}</button>
        </div>
    )
} 
export default PersonCard;