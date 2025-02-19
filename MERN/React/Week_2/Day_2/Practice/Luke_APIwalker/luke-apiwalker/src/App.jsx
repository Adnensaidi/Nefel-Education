import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Form from './components/Form';
import Display from './components/Display';

import './App.css';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route element={<Form />} path="/" />
          <Route element={<Display />} path="/display/:type/:id" />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;