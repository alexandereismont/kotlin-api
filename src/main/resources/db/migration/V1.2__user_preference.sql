create table if NOT EXISTS user_preference (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    superhero_id BIGINT NOT NULL,
    FOREIGN KEY (superhero_id) REFERENCES superhero(id)
)
