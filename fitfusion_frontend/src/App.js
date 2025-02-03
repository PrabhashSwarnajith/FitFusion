import './App.css';
import Authentication from './pages/Authentication/AuthenticationPage';
import {Route, Routes} from "react-router-dom";
import React from "react";
import HomePage from "./pages/HomePage/HomePage";


function App() {
  return (
          <div className="App">
              <Routes>
                  <Route path='/' element={<Authentication/>}></Route>
                  <Route path='/home//*' element={<HomePage/>}></Route>
              </Routes>
          </div>
  );
}

export default App;
