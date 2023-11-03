INSERT INTO clients (id, client_id, client_secret, authentication, created) VALUES (1, 'client', 'secret', 'client_secret_basic', current_timestamp);
INSERT INTO grant_types (id, grant_types, client_id) VALUES (1, 'AUTHORIZATION_CODE', 1);
INSERT INTO grant_types (id, grant_types, client_id) VALUES (2, 'CLIENT_CREDENTIALS', 1);
INSERT INTO redirect_urls (id, url, client_id) VALUES (1, 'http://example.com/auth', 1);
INSERT INTO scopes (id, scope, client_id) VALUES (1, 'OIDC', 1);

