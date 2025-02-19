import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Form = () => {

    const [type, setType] = useState("people");
    const [id, setId] = useState(0);

    const navigate = useNavigate();

    const submitHandler = (e) => {
        e.preventDefault();
        navigate(`/display/${type}/${id}`);
        setType("people")
        setId(0)
    }

    return (
        <div>
            <form onSubmit={submitHandler}>

                <label htmlFor="type">Search for:</label>
                <select value={type} name="type" onChange={(e) => setType(e.target.value)}>
                    <option value="people">People</option>
                    <option value="planets">Planets</option>
                </select>
                <label htmlFor="id">ID:</label>
                <input value={id} onChange={(e) => setId(e.target.value)} type="number" />
                <input type="submit" value="Submit" />
            </form>
        </div>
    )
}

export default Form;