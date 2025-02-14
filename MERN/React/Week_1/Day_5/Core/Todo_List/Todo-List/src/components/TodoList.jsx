import React, { useState } from 'react';
import TodoItem from './TodoItem';

const TodoList = () => {
    const [tasks, setTasks] = useState([]);
    const [taskText, setTaskText] = useState('');

    const addTask = () => {
        if (taskText.trim() === '') return;
        const newTask = {
        id: Date.now(),
        text: taskText,
        completed: false
        };
        setTasks([...tasks, newTask]);
        setTaskText('');
    };

    const toggleTask = (id) => {
        setTasks(tasks.map(task => 
        task.id === id ? { ...task, completed: !task.completed } : task
        ));
    };

    const deleteTask = (id) => {
        setTasks(tasks.filter(task => task.id !== id));
    };

    return (
        <div>
        <h1>Todo List</h1>
        <input 
            type="text" 
            value={taskText} 
            onChange={(e) => setTaskText(e.target.value)}
        />
        <button onClick={addTask}>Add</button>
        <div>
            {tasks.map(task => (
            <TodoItem 
                key={task.id} 
                task={task} 
                onToggle={toggleTask} 
                onDelete={deleteTask}
            />
            ))}
        </div>
        </div>
    );
};

export default TodoList;
