import React from 'react';
import {NavBar} from "./navbar/NavBar";
import './app.scss';
import keycloak from "./Keycloak";
import {ReactKeycloakProvider} from '@react-keycloak/web'
import {DataContainer} from "./containers/dataContainer/DataContainer";

function App() {

    return (
        <ReactKeycloakProvider authClient={keycloak}>
            <div className="App">
                <NavBar/>
                <div className={`formsDiv`}>
                    <DataContainer />
                </div>
            </div>
        </ReactKeycloakProvider>
    );
}

export default App;
