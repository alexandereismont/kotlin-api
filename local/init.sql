CREATE SCHEMA keycloak;

CREATE USER keycloak;
ALTER USER keycloak WITH PASSWORD 'password';
GRANT ALL ON SCHEMA keycloak TO keycloak;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA keycloak TO keycloak;

CREATE SCHEMA api;
CREATE USER app_user;
ALTER USER app_user WITH PASSWORD 'password';
GRANT ALL ON SCHEMA api TO app_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA api TO app_user;
