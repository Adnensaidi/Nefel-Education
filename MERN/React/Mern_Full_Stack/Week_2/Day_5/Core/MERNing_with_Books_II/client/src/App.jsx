import './App.css'
import BookDetails from './components/BookDetails'
import Books from './components/Books'
import Create from './components/Create'
import NavBar from './components/NavBar'
import {Route,Routes,BrowserRouter as Router} from "react-router-dom"
function App() {

  return (
    <>
      <Router>
      <NavBar/>
        <Routes>
          <Route path='/' element={<Books/>}/>
          <Route path='/book/:id' element={<BookDetails/>}/>
          <Route path='/book/create' element={<Create/>}/>
        </Routes>
      </Router>
    </>
  )
}

export default App
