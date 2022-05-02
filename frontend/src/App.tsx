import React from 'react';
import {NavBar} from "./navbar/NavBar";
import './app.scss';
import keycloak from "./Keycloak";
import {ReactKeycloakProvider} from '@react-keycloak/web'
import {Route, Routes, Link as RouterLink} from 'react-router-dom';
import {DataContainer} from "./containers/dataContainer/DataContainer";
import {Link} from "@mui/material";

function App() {

    return (
        <ReactKeycloakProvider authClient={keycloak}>
            <>
                <NavBar />
                <Routes>
                    <Route path="/data" element={<DataContainer/>}>
                    </Route>
                </Routes>
            </>
            {/*<div className="App">
                <div className={`formsDiv`}>
                    <DataContainer />
                </div>
            </div>*/}
        </ReactKeycloakProvider>
    );
}

export default App;
