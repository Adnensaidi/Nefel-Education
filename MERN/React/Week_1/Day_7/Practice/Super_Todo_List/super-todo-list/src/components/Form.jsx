import { useState } from "react";

const Form = (props) => {

    const [content, setContent] = useState("");

    const { addTodo } = props;

    const submitHandler = (e) => {
        e.preventDefault();
        addTodo({
        content: content,
        markedDelete: false,
        id: Math.floor(Math.random() * 100000000).toString(),
        })
        setContent("");
    };

    return (
        <div>
        <form onSubmit={submitHandler}>
            <input
            value={content}
            onChange={(e) =>{
                setContent(e.target.value)
            }}
            type="text"
            name="content"
            />
            <button>Add</button>
        </form>
        </div>
    );
};

export default Form;