import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Books from './components/Books';
import Authors from './components/Authors';
import {BrowserRouter as Router, Route} from 'react-router';



class App extends Component {
  render() {
    return (
      <Router>
      <div className="App" style={{'display':'flex','justify-content':'center', 'flex-direction':'column',}}>
        <Header/>
        <Books/>
      </div>
      </Router>
    );
  }
}

export default App;
