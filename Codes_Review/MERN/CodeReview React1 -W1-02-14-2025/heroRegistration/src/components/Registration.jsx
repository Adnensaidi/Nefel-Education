import React, {useState} from 'react'
import '../assets/Registration.css'
import UserInfo from './UserInfo'

const Registration = () => {

    // 1 - Define State Variables for each input field in the form useState hook
    const [fullName,setFullName] = useState('')
    const [email,setEmail] = useState('')
    const [password,setPassword] = useState('')
    const [favHero,setFavHero] = useState('')
    const [termAccepted,setTermAccepted] = useState(false)

    const handleFullNameChange = (e) => {
        console.log("Full Name:", e.target.value);
        setFullName(e.target.value) 
    }
    const handleEmailChange = (e) => {
        setEmail(e.target.value)
    }
    const handlePasswordChange = (e) => {
        setPassword(e.target.value)
    }
    const handleFavHeroChange = (e) => {
        setFavHero(e.target.value)
    }
    const handleTermsChange = (e) => {
        setTermAccepted(e.target.checked)

    }

    const heroes = ['Superman','Wonder Woman','Batman','Spider-Man','Iron Man'];
    const [SubmitedData,setSubmittedData] = useState(null)

    // define a function to handle form submission and prevent the default behavior
    const handleSubmit = (e) =>{
        e.preventDefault(); // Prevent default form submission
        console.log("Form Submitted!");
        if(!termAccepted){
            alert("Please Accept the terms and conditions to proceed!")
        }
        else {
            setSubmittedData({fullName,email,password,favHero,})
            alert("Congratulations , you're ready to play the game!")
        }
    }


    return (
        <div className='registrationForm'>
            <div className='app-container'>
                <div className='form-container'>
                    <h2>Welcome To The Ultimate Registration Challenge</h2>
                    <p>Unkock the full potential of your skills by completing this form! Ready? Let's go!</p>
                <form onSubmit={handleSubmit}>
                    {/* Input for full name */}
                    <div className='input-group'>
                        <label>What's your name,adventurer?</label>
                        <input 
                        value={fullName}
                        onChange={handleFullNameChange}
                        type="text" 
                        placeholder='Type your name here'/>
                    </div>
                    {/* Input for email */}
                    <div className='input-group'>
                        <label>Where can we send your treasure chest,hero?</label>
                        <input 
                        value={email}
                        onChange={handleEmailChange}
                        type="email" 
                        placeholder='Enter your Email adresse' />
                    </div>
                    {/* Input for password */}
                    <div className='input-group'>
                        <label>Choose your secret password(keep it safe!)</label>
                        <input 
                        value={password}
                        onChange={handlePasswordChange}
                        type="password" 
                        placeholder='Create your password!'/>
                    </div>
                    <div>
                        <label> Select Your Favorite Hero</label>
                            <select 
                            onChange={handleFavHeroChange}>
                                <option value="">--Choose Your Hero--</option>
                                {heroes.map((hero,index) => (
                                    <option key={index} value={hero}> {hero} </option>
                                ))}
                            </select>
                    </div>
                    <div>
                        <input
                        checked={termAccepted}
                        onChange={handleTermsChange}
                        type="checkbox" />
                        
                        <label> I accept the terms and conditions</label>
                    </div>
                    <button type='submit' className='submit-button'>
                        Ready to Start the Game!
                    </button>
                </form>
                </div>
            </div>
            {/* Right Side: User Info Display */}
            <div className='user-info-container'>
                <h3> Your Profile:</h3>
                {/* Pass the collected form data as props to the UserInfo */}
                <UserInfo data={SubmitedData} />
            </div>
        </div>
    )
}

export default Registration