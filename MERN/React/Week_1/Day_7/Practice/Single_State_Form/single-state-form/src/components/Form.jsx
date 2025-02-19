import React, { useState } from 'react';


const Form = (props) => {

    const [user, setUser] = useState({
        firstName: "",
        lastName: "",
        email: "",
        password: "",
        confirmPassword: ""
    })




    const changeHandler = (e) => {

        setUser((prevUser) => ({
            ...prevUser,
            [e.target.name]: e.target.value
        })
        )

    }
    const formDataDivStyle = {
        textAlign: "left",
        width: "450px",
        margin: "auto",
    }

    const inputDataDivStyle = {
        borderRadius: "5px",
        backgroundColor: "#f2f2f2",
        border: "1px solid darkgrey",
        padding: "0px 10px",
        margin: "10px auto",
        width: "300px"
    }


    return (
        <div>
            <form>
                <div style={inputDataDivStyle}>
                    <label htmlFor="firstName">First Name</label>
                    <input
                        type="text"
                        name="firstName"
                        onChange={(e) => changeHandler(e)}
                    />
                </div>
                <div style={inputDataDivStyle}>
                    <label htmlFor="lastName">Last Name</label>
                    <input
                        type="text"
                        name="lastName"
                        onChange={(e) => changeHandler(e)}
                    />
                </div>
                <div style={inputDataDivStyle}>
                    <label htmlFor="email">Email</label>
                    <input
                        type="text"
                        name="email"
                        onChange={(e) => changeHandler(e)}
                    />
                </div>
                <div style={inputDataDivStyle}>
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        name="password"
                        onChange={(e) => changeHandler(e)}
                    />
                </div>
                <div style={inputDataDivStyle}>
                    <label htmlFor="confirmPassord">Confirm Password</label>
                    <input
                        type="password"
                        name="confirmPassword"
                        onChange={(e) => changeHandler(e)}
                    />
                </div>
            </form>

            <div style={formDataDivStyle}>
                <h3 style={{ textAlign: 'center' }}>Your Form Data</h3>
                <p>
                    <label>First Name: </label>{user.firstName}
                </p>
                <p>
                    <label>Last Name: </label>{user.lastName}
                </p>
                <p>
                    <label>Email: </label>{user.email}
                </p>
                <p>
                    <label>Password: </label>{user.password}
                </p>
                <p>
                    <label>Confirm Password: </label>{user.confirmPassword}
                </p>
            </div>
        </div>
    )
}

export default Form;