import React, { useState } from 'react';

const ReactiveForm = () => {
    const [formSubmitted, setFormSubmitted] = useState(false);
    const [users, setUsers] = useState([]);
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        confirmPassword: ''
    });

    const [touched, setTouched] = useState({
        firstName: false,
        lastName: false,
        email: false,
        password: false,
        confirmPassword: false
    });

    const validateField = (name, value) => {
        switch (name) {
        case 'firstName':
        case 'lastName':
            return value.length < 2 && value.length > 0
            ? `${name === 'firstName' ? 'First' : 'Last'} Name must be at least 2 characters`
            : '';
        case 'email':
            return value.length < 8 && value.length > 0
            ? 'Email must be at least 8 characters'
            : '';
        case 'password':
            return value.length < 8 && value.length > 0
            ? 'Password must be at least 8 characters'
            : '';
        case 'confirmPassword':
            return value !== formData.password && value.length > 0
            ? 'Passwords must match'
            : '';
        default:
            return '';
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({
        ...prev,
        [name]: value
        }));
        setTouched(prev => ({
        ...prev,
        [name]: true
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        
        const isValid = Object.keys(formData).every(
        key => !validateField(key, formData[key])
        );

        if (isValid) {
        setUsers(prev => [...prev, { ...formData }]);
        setFormData({
            firstName: '',
            lastName: '',
            email: '',
            password: '',
            confirmPassword: ''
        });
        setTouched({
            firstName: false,
            lastName: false,
            email: false,
            password: false,
            confirmPassword: false
        });
        setFormSubmitted(true);
        }
    };

    return (
        <div>
        <h1>{formSubmitted ? "Thank you for submitting the form!" : "Welcome, Please submit the form"}</h1>

        <form onSubmit={handleSubmit}>
            {Object.keys(formData).map((field) => (
            <div key={field}>
                <label>
                {field.replace(/([A-Z])/g, ' $1').split(' ').map(word => 
                    word.charAt(0).toUpperCase() + word.slice(1)
                ).join(' ')}
                </label>
                <input
                type={field.includes('password') ? 'password' : 'text'}
                name={field}
                value={formData[field]}
                onChange={handleChange}
                />
                {touched[field] && validateField(field, formData[field]) && (
                <p>{validateField(field, formData[field])}</p>
                )}
            </div>
            ))}

            <button type="submit">Create User</button>
        </form>

        {users.length > 0 && (
            <div>
            <h2>Users</h2>
            <div>
                {users.map((user, index) => (
                <div key={index}>
                    {user.firstName} {user.lastName} ({user.email})
                </div>
                ))}
            </div>
            </div>
        )}
        </div>
    );
};

export default ReactiveForm;
