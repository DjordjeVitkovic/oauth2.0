CREATE TABLE IF NOT EXISTS clients
(
    id             BIGSERIAL PRIMARY KEY,
    client_id      VARCHAR(125) NOT NULL,
    client_secret  VARCHAR(125) NOT NULL,
    authentication VARCHAR(125),
    created        TIMESTAMP    NOT NULL
);

CREATE TABLE IF NOT EXISTS redirect_urls
(
    id        BIGSERIAL PRIMARY KEY,
    url       VARCHAR(500) NOT NULL,
    client_id BIGSERIAL    NOT NULL,
    CONSTRAINT redirect_urls_client_id FOREIGN KEY (client_id)
        REFERENCES clients (id)

);

CREATE TABLE IF NOT EXISTS scopes
(
    id        BIGSERIAL PRIMARY KEY,
    scope     VARCHAR(125) NOT NULL,
    client_id BIGSERIAL    NOT NULL,
    CONSTRAINT scopes_client_id FOREIGN KEY (client_id)
        REFERENCES clients (id)
);

CREATE TABLE IF NOT EXISTS grant_types
(
    id          BIGSERIAL PRIMARY KEY,
    grant_types VARCHAR(125) NOT NULL,
    client_id   BIGSERIAL    NOT NULL,
    CONSTRAINT grant_types_client_id FOREIGN KEY (client_id)
        REFERENCES clients (id)
);


CREATE INDEX IF NOT EXISTS idx_clients_client_id ON clients (client_id);
CREATE INDEX IF NOT EXISTS idx_redirect_urls_url ON redirect_urls (url);
CREATE INDEX IF NOT EXISTS idx_scopes_scope ON scopes (scope);
CREATE INDEX IF NOT EXISTS idx_grant_type_grant_type ON grant_types (grant_types);


