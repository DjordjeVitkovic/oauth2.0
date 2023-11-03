CREATE TABLE IF NOT EXISTS authentication_methods
(
    id                    BIGSERIAL PRIMARY KEY,
    authentication_method VARCHAR(125) NOT NULL,
    client_id             BIGSERIAL    NOT NULL,
    CONSTRAINT authentication_method_client_id FOREIGN KEY (client_id)
        REFERENCES clients (id)
);

ALTER TABLE clients
    DROP COLUMN authentication;

INSERT INTO authentication_methods (id, authentication_method, client_id)
VALUES (1, 'client_secret_basic', 1);




