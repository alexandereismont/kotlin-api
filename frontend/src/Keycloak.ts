import Keycloak from "keycloak-js";

const keycloak = Keycloak({
    url: 'http://localhost:8180/auth',
    realm: 'Base',
    clientId: 'ApiClient'
});

export default keycloak;
