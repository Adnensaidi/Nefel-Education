import React from 'react'
import './MainContent.css'
import Subcontent from './Subcontent'
import Advertissment from './Advertissment'

function MainContent() {
    return (
    <div className="main-content">
        <div className="subcontent-container">
        <Subcontent />
        <Subcontent />
        <Subcontent />
        </div>
        <Advertissment />
    </div>
    )
}

export default MainContent