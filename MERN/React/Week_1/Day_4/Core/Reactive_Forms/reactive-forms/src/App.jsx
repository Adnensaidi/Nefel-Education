import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ReactiveForm from './components/ReactiveForm';

function App() {
  return (
    <div className="min-h-screen bg-gray-50 py-8">
      <ReactiveForm />
    </div>
  );
}

export default App;