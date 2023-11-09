# Token types
- opaque -> that don't contain any data about client and user
- non-opaque -> contains data about client and user (JWT)

## ADD
- Clients' table should have ManyToMany relations to other tables and that should be updated.

VERIFIER_ts5qtg4KQGLOakWLOrUjGuPWE-n9Um1r3u8P0xhIg0
CHALLENGEEvjd8Q8ejEvJmB-N3ouyl6Ikh0IRHiQy6b4CUvtR-BA

# OAuth2.0 flow:
http://localhost:8080/oauth2/authorize?response_type=code&client_id=client&scope=openid&redirect_uri=http://example.com/auth&code_challenge=Evjd8Q8ejEvJmB-N3ouyl6Ikh0IRHiQy6b4CUvtR-BA&code_challenge_method=S256