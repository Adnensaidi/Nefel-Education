import React from 'react'
import PropTypes from 'prop-types'

const FirstComp = props => {
    const {adnen} = props
    return (
    <div>      
        <h1>{adnen}</h1>
    <h2>Things I need to do:</h2>
    <ul>
      <li>Learn React</li>
      <li>Climb Mt. Everest</li>
      <li>Run a marathon</li>
      <li>Feed the dogs</li>
    </ul>
    </div>
  )
}

FirstComp.propTypes = {}

export default FirstComp