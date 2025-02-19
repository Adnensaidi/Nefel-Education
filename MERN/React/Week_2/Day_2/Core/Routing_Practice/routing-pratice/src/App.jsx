import React from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import { Routes } from 'react-router-dom';
import { Route } from 'react-router-dom';
import Home from './components/Home';
import Number from './components/Number';
import Word from './components/Word';
import StyledWord from './components/StyledWord';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/:number" element={<Number />} />
        <Route path="/:word" element={<Word />} />
        <Route path="/:word/:textColor/:bgColor" element={<StyledWord />} />
      </Routes>
    </Router>
  );
};

export default App;