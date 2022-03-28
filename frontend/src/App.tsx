import React from 'react';
import {NavBar} from "./navbar/NavBar";
import {Forms} from "./forms/Forms";
import './app.scss';

function App() {
    return (
        <div className="App">
            <NavBar />
            <div className={`formsDiv`}>
                <Forms />
            </div>
        </div>
    );
}

export default App;
