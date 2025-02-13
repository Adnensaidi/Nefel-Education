import React, { useState } from "react";

const PersonCard = ({ firstName, lastName, age, hairColor }) => {
    const [currentAge, setCurrentAge] = useState(age);

    return (
        <div style={{ textAlign: "center", marginBottom: "20px" }}>
        <h2>{lastName}, {firstName}</h2>
        <p>Age: {currentAge}</p>
        <p>Hair Color: {hairColor}</p>
        <button onClick={() => setCurrentAge(currentAge + 1)}>
            Birthday Button for {firstName} {lastName}
        </button>
        </div>
    );
};

export default PersonCard;
