CREATE TABLE IF NOT EXISTS client_token_settings
(
    id             BIGSERIAL PRIMARY KEY,
    token_lifespan INT         NOT NULL,
    token_type     VARCHAR(45) NOT NULL,
    client_id      BIGSERIAL   NOT NULL,
    CONSTRAINT client_token_settings_client_id FOREIGN KEY (client_id)
        REFERENCES clients (id)
);

CREATE INDEX IF NOT EXISTS idx_client_token_settings_id ON client_token_settings (id);

INSERT INTO client_token_settings (id, token_lifespan, token_type, client_id)
VALUES (1, 5, 'reference', 1);