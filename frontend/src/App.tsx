import React from 'react';
import {NavBar} from "./navbar/NavBar";
import {Forms} from "./forms/Forms";
import './app.scss';
import {SuperheroTable} from "./table/superheroTable";

function App() {
    return (
        <div className="App">
            <NavBar />
            <div className={`formsDiv`}>
                <Forms />
                <SuperheroTable />
            </div>
        </div>
    );
}

export default App;
