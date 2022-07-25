import React from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import AdicionarLinguagem from './components/adicionar-linguagem';

import Home from './views/home';

function App() {
  return (
   <React.StrictMode>
    <Router>
      <Routes>
        <Route exact path ="/" element={<Home />} />
        <Route exact path ="/adicionar-linguagem" element={<AdicionarLinguagem />} />
      </Routes>
    </Router>
   </React.StrictMode>
  );
}

export default App;
