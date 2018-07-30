import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Books from './components/Books';
import Authors from './components/Authors';



class App extends Component {
  render() {
    return (
      <div className="App" style={{'display':'flex','justify-content':'center', 'flex-direction':'column',}}>
        <Header/>
        <Books/>
        <Authors/>
      </div>
    );
  }
}

export default App;
