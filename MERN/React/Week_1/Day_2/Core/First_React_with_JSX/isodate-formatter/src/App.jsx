import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import FirstComp from './components/FirstComp'

function App() {
  const data = "Hello Dojo!"


  return (
    <>
      <FirstComp adnen={data}></FirstComp>
    </>
  )
}

export default App
