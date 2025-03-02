import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import {BrowserRouter as Router , Routes, Route , Link} from "react-router-dom"
import AllPost from './components/AllPost'
import CreatePost from './components/CreatePost'

function App() {


  return (
    <>
    <Router>
      <Routes>
        <Route path='/' element={<AllPost></AllPost>} >
        </Route>
        <Route path='/create' element={<CreatePost></CreatePost>}></Route>
      </Routes>
    </Router>
    </>
  )
}

export default App
