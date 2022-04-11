import React from 'react';
import {NavBar} from "./navbar/NavBar";
import {Forms} from "./forms/Forms";
import './app.scss';
import {SuperheroTable} from "./table/superheroTable";
import keycloak from "./Keycloak";
import { ReactKeycloakProvider } from '@react-keycloak/web'


function App() {

    return (
        <ReactKeycloakProvider authClient={keycloak}>
            <div className="App">
                <NavBar/>
                <div className={`formsDiv`}>
                    <Forms/>
                    <SuperheroTable/>
                </div>
            </div>
        </ReactKeycloakProvider>
    );
}

export default App;
