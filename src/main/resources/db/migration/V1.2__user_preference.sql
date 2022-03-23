create table if NOT EXISTS user_preference (
    id BIGINT(19) AUTO_INCREMENT PRIMARY KEY,
    user VARCHAR(100) NOT NULL UNIQUE,
    superhero_id BIGINT NOT NULL,
    FOREIGN KEY (superhero_id) REFERENCES superhero(id)
)
