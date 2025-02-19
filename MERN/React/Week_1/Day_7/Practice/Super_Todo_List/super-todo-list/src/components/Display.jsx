import Item from './Item'

const Display = (props) => {

    const { todoList, toggleCompleted, deleteTodo } = props;


    return (
        <>

        {
        todoList.map((todo, index) => (
            <div key={todo.id}>
            <Item styled={todo.markedDelete ? "completed" : ""} 
            itemText="Todo: "
            itemContent={todo.content} 
            checkboxHandler={()=>toggleCompleted(todo.id)}
            buttonHandler={()=>deleteTodo(todo.id)}
            buttonText="Delete Todo"
            />
            </div>
        ))
        }

        </>
    );
};

export default Display;