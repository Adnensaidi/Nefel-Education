import React from 'react'
import '../assets/Registration.css'

const UserInfo = (props) => {
    const {data} = props // Destructure Props 

    return (
        <div>
            <h4>Here's your mission info:</h4>
            <div className='user-info-item'>
                <strong>Your Name:</strong> {/* Display user's full name */}
            </div>
            <div className='user-info-item'>
                <strong>Your Email:</strong> {/* Display user's email */}
            </div>            
            <div className='user-info-item'>
                <strong>Your Secret Password:</strong> {/* Display user's Secret Password */}
            </div>            
            <div className='user-info-item'>
                <strong>Your Favorite Hero:</strong> {/* Display user's Favorite Hero */}
            </div>
        </div>
    )
}

export default UserInfo