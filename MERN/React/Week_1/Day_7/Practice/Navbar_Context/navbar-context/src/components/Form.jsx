import React, { useContext } from "react";
import { UserContext } from "../App";

const inputStyle = {
    padding: "5px 8px",
    fontSize: "2em"
};

const Form = () => {
    const { name, setName } = useContext(UserContext);

    return (
        <div style={{ padding: "15px" }}>
            <label>Name:</label>{" "}
            <input
                style={inputStyle}
                value={name}
                onChange={e => setName(e.target.value)}
            />
        </div>
    );
};

export default Form;